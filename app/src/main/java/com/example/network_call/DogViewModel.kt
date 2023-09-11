package com.example.network_call

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {

    val result = MutableLiveData<DogImg>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        isLoading.value = false
    }

    fun getImage() {

        isLoading.value = true

        viewModelScope.launch(IO) {
            val response = DogRepository.getImage()
            if (response?.isSuccessful == true) {
                isLoading.postValue(false)
                result.postValue(response.body())
            } else {
                Log.e("NETWORK ERROR", "Network call not achieved")
            }
        }
    }
}