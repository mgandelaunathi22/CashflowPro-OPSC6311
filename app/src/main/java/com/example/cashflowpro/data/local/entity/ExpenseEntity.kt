package com.example.cashflowpro.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "expenses",
    foreignKeys = [
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("categoryId"), Index("date")]

)
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true) val id: Long=0,
    val amount: Double,
    val date: Date, //or Long timestamp
    val description: String?,
    val categoryId: Long,
    val receiptPath: String? = null, //full file path saved receipt image (NOT the image bytes!)  IMPORTANT: store as path only
    val createdArt: Date = Date()


)
