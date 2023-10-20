package com.example.travelsupport.module.screen.homescreen.locationmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travelsupport.module.screen.homescreen.apiservice.Info

import com.example.travelsupport.module.screen.homescreen.apiservice.LocationDetailResponse
import com.example.travelsupport.module.screen.homescreen.apiservice.TripadvisorApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LocationDetailViewModel : ViewModel() {
    private val apiService = Retrofit.Builder()
        .baseUrl("https://api.content.tripadvisor.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TripadvisorApiService::class.java)

    private val _locationDetails = mutableStateOf<Info?>(null)
    val locationDetails: State<Info?> get()= _locationDetails

    fun getLocationDetails( selectedLocationModel: SelectedLocationModel, apikey: String){
        viewModelScope.launch {
            try {
                val response = selectedLocationModel.selectedLocationId.value?.let {
                    apiService.getLocationDetails(
                        it.toInt(), apikey)
                }
                if (response != null) {
                    _locationDetails.value = response.info
                }
            } catch (e: Exception){
                //
            }
            Log.d("getlocationDetail", "Lấy thông tin chi tiết của địa điểm"+selectedLocationModel.selectedLocationId.value)

        }
        selectedLocationModel.selectedLocationId.value?.let { it1 -> Log.d("truyền id qua LocationDetailViewModel: ", "truyền id qua LocationDetailViewModel: "+it1) }
    }
}