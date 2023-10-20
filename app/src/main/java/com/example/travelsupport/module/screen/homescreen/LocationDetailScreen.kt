package com.example.travelsupport.module.screen.homescreen

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.travelsupport.module.screen.homescreen.apiservice.Info
import com.example.travelsupport.module.screen.homescreen.apiservice.LocationDetailResponse
import com.example.travelsupport.module.screen.homescreen.locationmodel.LocationDetailViewModel
import com.example.travelsupport.module.screen.homescreen.locationmodel.SelectedLocationModel

@Composable

fun LocationDetailScreen( navHostController: NavHostController, selectedLocationModel: SelectedLocationModel) {
    Text(selectedLocationModel.selectedLocationId.value.toString())

}

//locationDetailViewModel.locationDetails.value?.let { detail ->
//    Text(text = detail.name)
//    Text(text = detail.phone)
//}
//phone:String,navHostController: NavHostController, locationDetailViewModel: LocationDetailViewModel, selectedLocationModel: SelectedLocationModel