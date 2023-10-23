package com.example.ailandmarkrecognition.model


import android.util.Log
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
    val locationDetail: LiveData<TripAdvisorLocationDetailResponse> get() = _locationDetail

    fun getLocationDetail(locationId: Int, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = apiService.getLocationDetails(locationId, apiKey)
                _locationDetail.value = response
            } catch (e: Exception) {
                // Xử lý lỗi tại đây
            }
        }
        Log.d("getlocationdetail","ok")
    }
}
