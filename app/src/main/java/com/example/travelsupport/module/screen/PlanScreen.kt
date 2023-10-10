package com.example.travelsupport.module.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.travelsupport.module.screen.navigation.BottomBarScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanScreen(navHostController: NavHostController) {
    Scaffold (
        bottomBar = {
            BottomBarScaffold(navHostController)
        }
    ){
        paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome to the Plan Screen!", fontSize = 24.sp)
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PlanPreview(){
//    PlanScreen()
}