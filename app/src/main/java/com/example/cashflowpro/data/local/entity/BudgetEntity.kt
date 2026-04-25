package com.example.cashflowpro.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "budgets")
data class BudgetEntity(
    @PrimaryKey val monthYear: String, //example "2026-04"
    val totalMonthlyBudget: Double,
    val updatedAt: Date = Date()
)
