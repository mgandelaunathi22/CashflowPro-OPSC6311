package com.example.cashflowpro.repository
import com.example.cashflowpro.data.local.dao.CategoryDao
import com.example.cashflowpro.data.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

class CategoryRepository(private val categoryDao: CategoryDao) {
    //Add new category (digital envelope)
    suspend fun addCategory(category: CategoryEntity): Long {
        return categoryDao.insertCategory(category)
    }
    //Update existing category (e.g limit or name)
    suspend fun updateCategory(category: CategoryEntity) {
        categoryDao.updateCategory(category)
    }
    //Delete category
    suspend fun deleteCategory(category: CategoryEntity){
        categoryDao.deleteCategory(category)
    }
    //get all categories as Flow (observe live changes in UI)
    fun getAllCategories(): Flow<List<CategoryEntity>>{
        return categoryDao.getAllCategories()
    }
    //Get single category by ID
    suspend fun getCategoryByID(id: Long): CategoryEntity?{
        return categoryDao.getCategoryById(id)
    }
}