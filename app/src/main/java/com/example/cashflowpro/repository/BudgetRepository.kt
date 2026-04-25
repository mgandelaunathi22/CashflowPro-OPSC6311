package com.example.cashflowpro.repository
import com.example.cashflowpro.data.local.dao.BudgetDao
import com.example.cashflowpro.data.local.entity.BudgetEntity
import kotlinx.coroutines.flow.Flow

class BudgetRepository(private val budgetDao: BudgetDao) {
    //set or update monthly total budget
    /*month year format "2026-04"

     */
    suspend fun setMonthlyBudget(monthYear: String, totalBudget: Double){
        val budget = BudgetEntity(
            monthYear = monthYear,
            totalMonthlyBudget = totalBudget
        )
        budgetDao.insertOrUpdateBudget(budget)
    }
    //get budget for a specific month
    suspend fun getBudgetForMonth(monthYear: String): BudgetEntity?{
        return budgetDao.getBudgetForMonth(monthYear)
    }
    fun getAllBudgets(): Flow<List<BudgetEntity>>{
        return budgetDao.getAllBudgets()
    }
}