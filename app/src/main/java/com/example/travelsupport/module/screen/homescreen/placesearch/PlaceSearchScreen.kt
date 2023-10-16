package com.example.travelsupport.module.screen.homescreen.placesearch

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.travelsupport.ui.theme.navigationItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationSearchScreen(navHostController: NavHostController,locationViewModel: LocationViewModel) {
    var searchQuery by remember { mutableStateOf("") }
    val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        textColor = Color.Black, // Màu chữ
        cursorColor = Color.Blue, // Màu dấu nháy
        focusedBorderColor = Color.Blue, // Màu viền khi được focus
        unfocusedBorderColor = Color.Black, // Màu viền khi không được focus
        disabledTextColor = Color.Gray // Màu chữ khi TextField bị tắt
    )
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { value -> searchQuery = value },
            label = { Text("Bạn sắp đến đâu", style = navigationItem) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = textFieldColors

        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                locationViewModel.searchLocations("7904AD3CB20F4523B18C73F170779ED9", searchQuery, "vi")
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Tìm kiếm")
        }

        Spacer(modifier = Modifier.height(16.dp))

        locationViewModel.locations.value?.let { locations ->
            LocationList(locations)
        }
    }
    Log.d("SearchScreen", "LocationSearchScreen")
}