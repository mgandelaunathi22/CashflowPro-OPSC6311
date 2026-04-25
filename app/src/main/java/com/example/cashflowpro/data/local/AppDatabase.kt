package com.example.cashflowpro.data.local
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cashflowpro.data.local.converter.Converters
import com.example.cashflowpro.data.local.dao.*
import com.example.cashflowpro.data.local.entity.*

@Database(
    entities = [
        UserEntity::class,
        CategoryEntity::class,
        ExpenseEntity::class,
               BudgetEntity::class
               ],
    version = 1,      //increase when you change schema
    exportSchema = true
)
@TypeConverters(Converters::class)

abstract class AppDatabase  : RoomDatabase(){
    abstract fun userDao(): UserDao
    abstract fun categoryDao(): CategoryDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun budgetDoa(): BudgetDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "cashflowpro_database.db"
                )
                    .fallbackToDestructiveMigration()  //for development only
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}