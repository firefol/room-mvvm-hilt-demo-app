package com.example.dbmvvmhilt.di

import android.app.Application
import com.example.dbmvvmhilt.db.UserDao
import com.example.dbmvvmhilt.db.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Singleton
    @Provides
    fun getAppDB(context: Application): UserDatabase {
        return UserDatabase.getDatabase(context)
    }

    @Singleton
    @Provides
    fun getDao(userDatabase: UserDatabase): UserDao {
        return userDatabase.userDao()
    }
}