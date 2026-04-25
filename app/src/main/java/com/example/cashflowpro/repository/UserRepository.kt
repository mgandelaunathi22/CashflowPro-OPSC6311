package com.example.cashflowpro.repository
import com.example.cashflowpro.data.local.dao.UserDao
import com.example.cashflowpro.data.local.entity.UserEntity

class UserRepository(private val userDao: UserDao) {
    //Registers a new user
    suspend fun registerUser(user: UserEntity): Long {
        return userDao.insertUser(user)
    }
    //gets user by their username (for checking if the username exists)
    suspend fun getUserByUsername(username: String): UserEntity? {
        return userDao.getUserByUsername(username)
    }
    //Login user - returns UserEntity if credentials are correct, null otherwise
    suspend fun login(username: String, password: String): UserEntity?{
        return userDao.login(username, password)
    }
    //Check if any user exists (for first time setup)
    suspend fun isUserRegistered(): Boolean {
        // You can extend UserDao with a count query if needed
        return false // Implement based on your needs
    }

}