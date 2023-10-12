package com.example.travelsupport.module.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.travelsupport.module.screen.navigation.BottomBarScaffold
import com.example.travelsupport.module.screen.navigation.Navigation
import com.example.travelsupport.module.screen.navigation.Screens
import com.example.travelsupport.module.screen.navigation.listofNavItem
import com.example.travelsupport.module.splash.SplashScreen
import com.example.travelsupport.ui.theme.LightBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen(navHostController: NavHostController) {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = { BottomBarScaffold(navHostController) }
        ) {paddingValues->
            Column (modifier = Modifier.padding(paddingValues)){
                Navigation(navHostController)
            }
        }
//
//    Scaffold(
//        bottomBar = {
//            NavigationBar(modifier = Modifier
//                .height(70.dp)
//                .clip(RoundedCornerShape(20.dp)),
//                containerColor = LightBlue) {
//                val navBackStackEntry by navController.currentBackStackEntryAsState()
//                val currentDestination = navBackStackEntry?.destination
//
//                listofNavItem.forEach { navItem ->
//                    NavigationBarItem(
//                        selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
//                        onClick = {
//                            navController.navigate(navItem.route){
//                                popUpTo(navController.graph.findStartDestination().id){
//                                    saveState = true
//                                }
//                                launchSingleTop = true
//                                restoreState = true
//                            }
//                        },
//                        icon = {
//                            Icon(imageVector = navItem.icon, contentDescription = null)
//                        },
//                        label = {
//                            Text(text = navItem.label)
//                        }
//                    )
//                }
//            }
//        }
//    )
//    { paddingValues ->
//        NavHost(navController = navController,
//            startDestination = Screens.HomeScreen.name,
//            modifier = Modifier
//                .padding(paddingValues)
//        ){
//            composable(route = Screens.HomeScreen.name){
//                HomeScreen(navController)
//            }
//            composable(route = Screens.FavoriteScreen.name){
//                FavoriteScreen()
//            }
//            composable(route = Screens.PlanScreen.name){
//                PlanScreen()
//            }
//            composable(route = Screens.AccountScreen.name){
//                AccountScreenNotLogin()
//            }
//        }
//
//    }
}

