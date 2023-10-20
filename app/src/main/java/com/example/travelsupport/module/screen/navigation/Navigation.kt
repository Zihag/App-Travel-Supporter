package com.example.travelsupport.module.screen.navigation

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.travelsupport.module.screen.AccountScreenNotLogin
import com.example.travelsupport.module.screen.FavoriteScreen
import com.example.travelsupport.module.screen.homescreen.HomeScreen
import com.example.travelsupport.module.screen.PlanScreen
import com.example.travelsupport.module.screen.homescreen.ExploreScreen
import com.example.travelsupport.module.screen.homescreen.HotelSearchScreen
import com.example.travelsupport.module.screen.homescreen.LocationDetailScreen
import com.example.travelsupport.module.screen.homescreen.LocationSearchScreen
import com.example.travelsupport.module.screen.homescreen.locationmodel.LocationViewModel
import com.example.travelsupport.module.screen.homescreen.RestaurantSearchScreen
import com.example.travelsupport.module.screen.homescreen.apiservice.Info
import com.example.travelsupport.module.screen.homescreen.apiservice.LocationDetailResponse
import com.example.travelsupport.module.screen.homescreen.explorebuilding.CameraPreview
import com.example.travelsupport.module.screen.homescreen.explorebuilding.Classification
import com.example.travelsupport.module.screen.homescreen.explorebuilding.LandmarkImageAnalyzer
import com.example.travelsupport.module.screen.homescreen.explorebuilding.TfLiteLandmarkClassifier
import com.example.travelsupport.module.screen.homescreen.locationmodel.LocationDetailViewModel
import com.example.travelsupport.module.screen.homescreen.locationmodel.SelectedLocationModel
import com.example.travelsupport.module.splash.SplashScreen

@Composable
fun Navigation(navController: NavHostController) {
    val locationDetailViewModel = LocationDetailViewModel()
    NavHost(navController = navController,
        startDestination = "splash_screen",
        ){
        composable(route = Screens.HomeScreen.name){
            HomeScreen(navController)
        }
        composable(route = Screens.FavoriteScreen.name){
            FavoriteScreen(navController)
        }
        composable(route = Screens.PlanScreen.name){
            PlanScreen(navController)
        }
        composable(route = Screens.AccountScreen.name){
            AccountScreenNotLogin(navController)
        }
        composable("splash_screen"){
            SplashScreen(navController)
        }
        composable("restaurant_search_screen"){
            RestaurantSearchScreen(navController, LocationViewModel())
        }
        composable("location_search_screen"){
            LocationSearchScreen(navController, LocationViewModel())
        }
        composable("hotel_search_screen"){
            HotelSearchScreen(navController, LocationViewModel())
        }
        composable("location_detail_screen"){
            LocationDetailScreen(navController , SelectedLocationModel())
            }
        composable("explore_screen"){

        }
        }
}