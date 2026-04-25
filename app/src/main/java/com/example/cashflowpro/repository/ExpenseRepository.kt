package com.example.cashflowpro.repository
import com.example.cashflowpro.data.local.dao.ExpenseDao
import com.example.cashflowpro.data.local.entity.ExpenseEntity
import kotlinx.coroutines.flow.Flow
import java.util.Date

class ExpenseRepository(private val expenseDao: ExpenseDao) {

    suspend fun addExpense(expense: ExpenseEntity): Long =
        expenseDao.insertExpense(expense)

    suspend fun updateExpense(expense: ExpenseEntity) =
        expenseDao.updateExpense(expense)

    suspend fun deleteExpense(expense: ExpenseEntity) =
        expenseDao.deleteExpense(expense)

    fun getAllExpenses(): Flow<List<ExpenseEntity>> =
        expenseDao.getAllExpenses()

    fun getExpensesByDateRange(start: Date, end: Date): Flow<List<ExpenseEntity>> =
        expenseDao.getExpensesByDateRange(start, end)

    fun getTotalByCategory(categoryId: Long, start: Date, end: Date): Flow<Double?> =
        expenseDao.getTotalSpentByCategory(categoryId, start, end)
}