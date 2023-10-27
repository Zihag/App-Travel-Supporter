package com.example.ailandmarkrecognition.model


import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travelsupport.module.screen.homescreen.apiservice.TripAdvisorApi
import com.example.travelsupport.module.screen.homescreen.apiservice.TripAdvisorLocationDetailResponse
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LocationDetailViewModel : ViewModel() {
    private val apiService = Retrofit.Builder()
        .baseUrl("https://api.content.tripadvisor.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TripAdvisorApi::class.java)

    private val _locationDetail = MutableLiveData<TripAdvisorLocationDetailResponse>()
    val loading = mutableStateOf(false)

    val locationDetail: LiveData<TripAdvisorLocationDetailResponse> get() = _locationDetail

    fun getLocationDetail(locationId: Int, apiKey: String) {
        viewModelScope.launch {
            loading.value = true

            try {
                val response = apiService.getLocationDetails(locationId, apiKey)
                _locationDetail.value = response
            } catch (e: Exception) {
                // Xử lý lỗi tại đây
            }
            loading.value = false

        }
        Log.d("getlocationdetail","ok")
    }
}
