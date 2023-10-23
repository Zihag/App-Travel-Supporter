package com.example.travelsupport.module.screen.homescreen.locationmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SelectedLocationModel: ViewModel() {
    private val _selectedLocationId = mutableStateOf<String?>(null)
    val selectedLocationId: State<String?> get() = _selectedLocationId

    fun setSelectedLocationId(id: String) {
        _selectedLocationId.value = id

        Log.d("save id", "Lưu Id địa điểm được chọn: " + selectedLocationId.value)

    }
}