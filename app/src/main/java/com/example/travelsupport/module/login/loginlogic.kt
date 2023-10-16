//package com.example.signinsignup
//
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.compose.setContent
//import androidx.activity.result.IntentSenderRequest
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.width
//import androidx.compose.material3.Button
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.compose.collectAsStateWithLifecycle
//import androidx.lifecycle.lifecycleScope
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.signinsignup.ui.theme.SignInSignUpTheme
//import com.example.travelsupport.module.screen.AccountScreenLogin
//import com.example.travelsupport.module.screen.AccountScreenNotLogin
//import com.google.android.gms.auth.api.identity.Identity
//import kotlinx.coroutines.launch
//
//class LoginActivity : ComponentActivity() {
//
//    private val googleAuthUIClient by lazy {
//        GoogleAuthUIClient(
//            context = applicationContext,
//            oneTapClient = Identity.getSignInClient(applicationContext)
//        )
//    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            val navController = rememberNavController()
//            NavHost(navController = navController, startDestination = "sign_in"){
//                composable("sign_in"){
//                    val viewModel = viewModel<SignInViewModel>()
//                    val state by viewModel.state.collectAsStateWithLifecycle()
//
//                    LaunchedEffect(key1 = Unit){
//                        if(googleAuthUIClient.getSignInUser()!=null){
//                            navController.navigate("profile")
//                        }
//                    }
//
//                    val launcher = rememberLauncherForActivityResult(
//                        contract = ActivityResultContracts.StartIntentSenderForResult(),
//                        onResult = {result ->
//                            if(result.resultCode == RESULT_OK){
//                                lifecycleScope.launch {
//                                    val signInResult = googleAuthUIClient.signInWithIntent(
//                                        intent = result.data?: return@launch
//                                    )
//                                    viewModel.onSignInResult(signInResult)
//                                }
//                            }
//                        }
//                    )
//
//                    LaunchedEffect(key1 = state.isSignInSuccessful ){
//                        if(state.isSignInSuccessful){
//                            Toast.makeText(
//                                applicationContext,
//                                "Sign in successful",
//                                Toast.LENGTH_LONG
//                            ).show()
//
//                            navController.navigate("profile")
//                            viewModel.resetState()
//                        }
//                    }
//
//                    AccountScreenNotLogin(
//                        state = state,
//                        onSignInClick = {
//                            lifecycleScope.launch {
//                                val signInIntentSender = googleAuthUIClient.signIn()
//                                launcher.launch(
//                                    IntentSenderRequest.Builder(
//                                        signInIntentSender?:return@launch
//                                    ).build()
//                                )
//                            }
//                        }
//                    )
//                }
//                composable("profile"){
//                    AccountScreenLogin(userData = googleAuthUIClient.getSignInUser(),
//                        onSignOut = {
//                            lifecycleScope.launch {
//                                googleAuthUIClient.signOut()
//                                Toast.makeText(
//                                    applicationContext,
//                                    "Signed out",
//                                    Toast.LENGTH_LONG
//                                ).show()
//
//                                navController.popBackStack()
//                            }
//                        }
//                    )
//                }
//            }
//        }
//    }
//}
//
//
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//
//}