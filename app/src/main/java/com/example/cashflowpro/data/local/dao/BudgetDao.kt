package com.example.cashflowpro.data.local.dao
import androidx.room.*
import com.example.cashflowpro.data.local.entity.BudgetEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BudgetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insertOrUpdateBudget(budget: BudgetEntity)

    @Query("SELECT * FROM budgets WHERE monthYear = :monthYear")
    suspend fun getBudgetForMonth(monthYear: String): BudgetEntity?

    @Query("SELECT * FROM budgets ORDER BY updatedAt DESC")
    fun getAllBudgets(): Flow<List<BudgetEntity>>
}