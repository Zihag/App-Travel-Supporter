package com.example.travelsupport.module.screen.homescreen.locationmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travelsupport.module.screen.homescreen.apiservice.TripadvisorApiService
import com.example.travelsupport.module.screen.homescreen.apiservice.diadiem
import kotlinx.coroutines.delay


import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LocationViewModel : ViewModel() {
    private val apiService = Retrofit.Builder()
        .baseUrl("https://api.content.tripadvisor.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TripadvisorApiService::class.java)

    private val _locations = mutableStateOf<List<diadiem>>(emptyList())
    val locations: State<List<diadiem>> get() = _locations
    val loading = mutableStateOf(false)

    fun searchLocations(apiKey: String, searchQuery: String,address: String?, ngonngu: String) {
        viewModelScope.launch {
            loading.value = true
            delay(2000)
            try {
                val response = apiService.searchLocations(apiKey, searchQuery, address, ngonngu)
                _locations.value = response.data
            } catch (e: Exception) {
                // Xử lý lỗi
            }
            loading.value = false
        }
        Log.d("searchLocation", "Tìm danh sách địa điểm")
    }
}
//category:String?,phone:String?,address:String?,latLong:String?,radius:Number?,radiusUnit:String?,
//category,phone,address,latLong,radius,radiusUnit,