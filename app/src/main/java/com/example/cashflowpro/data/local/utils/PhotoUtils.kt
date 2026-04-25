package com.example.cashflowpro.data.local.utils
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * utility class to handle receipt photo storage and retrieval
 * stores images in app's private external files directory(not in Room DB)
 * Only the file path is saved in ExpenseEntity.receiptPath
 */

object PhotoUtils {
    private const val TAG ="PhotoUtils"
    private const val IMAGE_DIRECTORY ="receipts"

    /**
     * Saves a receipt image from Uri to internal storage and returns the file path.
     * @return Absolute file path of saved image, or null if failed
     */
    fun saveReceiptImage(context: Context, imageUri: Uri): String? {
        return try {
            val inputStream = context.contentResolver.openInputStream(imageUri)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream?.close()

            bitmap?.let { saveBitmapToFile(context, it) }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to save receipt image", e)
            null
        }
    }

    /**
     * Saves a Bitmap as JPEG file and returns the absolute path
     */
    private fun saveBitmapToFile(context: Context, bitmap: Bitmap): String? {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val fileName = "receipt_$timeStamp.jpg"

        val storageDir = File(context.getExternalFilesDir(null), IMAGE_DIRECTORY)
        if (!storageDir.exists()) {
            storageDir.mkdirs()
        }

        val imageFile = File(storageDir, fileName)

        try {
            FileOutputStream(imageFile).use { out ->
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, out)  // 85% quality - good balance
            }
            Log.d(TAG, "Receipt saved successfully: ${imageFile.absolutePath}")
            return imageFile.absolutePath
        } catch (e: IOException) {
            Log.e(TAG, "Error saving bitmap to file", e)
            return null
        }
    }

    /**
     * Deletes a receipt image file when expense is deleted
     */
    fun deleteReceiptImage(receiptPath: String?): Boolean {
        if (receiptPath.isNullOrEmpty()) return true

        return try {
            val file = File(receiptPath)
            if (file.exists()) {
                val deleted = file.delete()
                Log.d(TAG, "Receipt file deleted: $deleted - $receiptPath")
                deleted
            } else {
                true
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to delete receipt file: $receiptPath", e)
            false
        }
    }

    /**
     * Returns the File object for a given receipt path (for displaying image)
     */
    fun getReceiptFile(receiptPath: String?): File? {
        if (receiptPath.isNullOrEmpty()) return null
        val file = File(receiptPath)
        return if (file.exists()) file else null
    }
}