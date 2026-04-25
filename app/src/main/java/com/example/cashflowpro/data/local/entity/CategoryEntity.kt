package com.example.cashflowpro.data.local.entity
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val name: String,     //example, "Transport", "Groceries"
    val color: String? = "#4CAF50",    //HEX colour for UI
    val monthlyLimit: Double? = null,    //per-category budget limit
    val icon: String? =null   //optional emoji or resource name
)
