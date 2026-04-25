package com.example.cashflowpro.data.local.dao
import androidx.room.*
import com.example.cashflowpro.data.local.entity.ExpenseEntity
import kotlinx.coroutines.flow.Flow
import java.util.Date

@Dao
interface ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpense(expense: ExpenseEntity): Long
    @Update
    suspend fun updateExpense(expense: ExpenseEntity)
    @Delete
    suspend fun deleteExpense(expense: ExpenseEntity)

    @Query("SELECT * FROM expenses " +
            "WHERE date BETWEEN :startDate " +
            "AND :endDate ORDER BY date DESC")
    fun getExpensesByDateRange(startDate: Date, endDate: Date): Flow<List<ExpenseEntity>>

    @Query("SELECT * FROM expenses ORDER BY date DESC")
    fun getAllExpenses(): Flow<List<ExpenseEntity>>

    @Query("SELECT SUM(amount) FROM expenses WHERE categoryId = :categoryId AND  date BETWEEN :startDate AND :endDate")
    fun getTotalSpentByCategory(categoryId: Long, startDate: Date, endDate: Date): Flow<Double?>

}