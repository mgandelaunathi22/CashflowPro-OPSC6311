package com.example.cashflowpro.data.local.entity
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Long=0L,
    val username: String,
    val email: String?,
    val password: String

)
