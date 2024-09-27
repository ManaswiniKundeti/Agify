package com.example.myapplication.viewModel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.network.data.AgifyResponse
import com.example.myapplication.repository.AgifyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgifyViewModel @Inject constructor(
    private val repository: AgifyRepository
): ViewModel() {

    private val _ageState = MutableLiveData<Int>()
    val ageState = _ageState

    private val _nameState = MutableLiveData<String>()
    val nameState: MutableLiveData<String> = _nameState

    init {
        getAge("Michael")
    }

    fun getAge(name: String) {
        viewModelScope.launch {
            val response: AgifyResponse = repository.getAgeOfNameFromNetwork(name)
            _ageState.value = response.age ?: 0
            _nameState.value = response.name ?: "Michael"
        }
    }
}