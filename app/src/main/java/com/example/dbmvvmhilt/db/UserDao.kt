package com.example.dbmvvmhilt.db

import androidx.room.*


@Dao
interface UserDao {

    @Query("SELECT * FROM user_table ORDER BY uid DESC")
    fun getUsers(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: UserEntity)

    //@Delete
// fun delete(user: UserEntity)
}