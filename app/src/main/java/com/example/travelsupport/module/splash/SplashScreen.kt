package com.example.travelsupport.module.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.travelsupport.R
import com.example.travelsupport.module.screen.MainScreen
import kotlinx.coroutines.delay

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen"){
        composable("splash_screen"){
            SplashScreen(navController = navController)
        }
        composable("main_screen"){
            MainScreen()
        }
    }
}

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember{ Animatable(0f) }
    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 0.8f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
            })
        )
        delay(2000L)
        navController.navigate("main_screen")
    }
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Image(painter = painterResource(id = R.drawable.bgsplash2),
            contentDescription = null,
            modifier = Modifier.alpha(1f).scale(1.5f))
        Image(painter = painterResource(id = R.drawable.adventurer1), contentDescription = null, modifier = Modifier.scale(scale.value))
    }
}

@Composable
fun BoxTest() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = R.drawable.bgsplash2),
            contentDescription = null,
            modifier = Modifier.alpha(1f).scale(scale=1.5f))
        Image(painter = painterResource(id = R.drawable.adventurer1), contentDescription = null, modifier = Modifier)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SplashScreenPreview() {
    BoxTest()
}