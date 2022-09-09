package com.example.dbmvvmhilt.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dbmvvmhilt.db.UserEntity
import com.example.dbmvvmhilt.repository.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: RoomRepository): ViewModel() {

    lateinit var userData: MutableLiveData<List<UserEntity>>

    init {
        userData = MutableLiveData()
        loadUsers()
    }

    fun loadUsersObserver(): MutableLiveData<List<UserEntity>>{
        return userData
    }

    fun loadUsers() {
        val list = repository.getUsers()
        userData.postValue(list)
    }

    fun insertUser(user: UserEntity) {
            repository.insert(user)
            loadUsers()
    }

}