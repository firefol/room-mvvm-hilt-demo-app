package com.example.dbmvvmhilt.repository

import com.example.dbmvvmhilt.db.UserDao
import com.example.dbmvvmhilt.db.UserEntity
import javax.inject.Inject

class RoomRepository @Inject constructor(private val userDao: UserDao) {

    fun getUsers(): List<UserEntity> {
        return userDao.getUsers()
    }

    fun insert(user: UserEntity) {
        userDao.insert(user)
    }

    //suspend fun deleteUser(user: UserEntity) {
        //return userDao.delete(user )
    //}
}