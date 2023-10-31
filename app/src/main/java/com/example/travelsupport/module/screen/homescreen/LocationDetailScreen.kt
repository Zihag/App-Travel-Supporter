package com.example.travelsupport.module.screen.homescreen

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ailandmarkrecognition.model.LocationDetailViewModel
import com.example.travelsupport.R
import com.example.travelsupport.module.button.GrayButton
import com.example.travelsupport.module.screen.CircularIndeterminateProgressBar
import com.example.travelsupport.module.screen.homescreen.locationmodel.SelectedLocationModel
import com.example.travelsupport.ui.theme.H1Bold
import com.example.travelsupport.ui.theme.Kanit_Light
import com.example.travelsupport.ui.theme.LightBlue
import com.example.travelsupport.ui.theme.TitleBold2
import com.example.travelsupport.ui.theme.TitleLight2

@Composable

fun LocationDetailScreen(
    navHostController: NavHostController,
    viewModel: LocationDetailViewModel,
    id: String?
) {
    Log.d("XXXX", id.toString())
//    var locationId by remember { mutableStateOf<Int?>(null) }
    val locationDetail by viewModel.locationDetail.observeAsState()
    var id1 = id?.toInt()
    val loading = viewModel.loading.value
    val context = LocalContext.current
    val longitude = locationDetail?.longitude
    val latitude = locationDetail?.latitude
    val locationName = locationDetail?.name
    val intentUri = Uri.parse("geo:$latitude,$longitude?q=$latitude,$longitude($locationName)")
    val mapIntent = Intent(Intent.ACTION_VIEW, intentUri)
    mapIntent.setPackage("com.google.android.apps.maps") // Chỉ mở Google Maps

    // Kiểm tra xem thiết bị của người dùng có ứng dụng Google Maps không
    val canOpenMap = mapIntent.resolveActivity(context.packageManager) != null

    viewModel.getLocationDetail(id1!!, "7904AD3CB20F4523B18C73F170779ED9")
    CircularIndeterminateProgressBar(isDisplayed = loading, modifier = Modifier.fillMaxSize().padding(top = 300.dp))
        locationDetail?.let {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(LightBlue)
                .verticalScroll(rememberScrollState())) {
                Image(painter = painterResource(id = R.drawable.hanoi2), contentDescription ="", modifier = Modifier
                    .clip(shape = RoundedCornerShape(20.dp))
                    .padding(5.dp))
                Text(it.name, style = H1Bold, modifier = Modifier.padding(horizontal = 5.dp))
                Spacer(modifier = Modifier.width(5.dp))
                it.description?.let { it1 -> Text(it1, style = TitleLight2, modifier = Modifier.padding(horizontal = 5.dp) ) }
                Spacer(modifier = Modifier.width(5.dp))
                Row (modifier = Modifier.padding(horizontal = 5.dp)){
                    Text(text = "Address: ", style = TitleBold2)
                    it.address_obj?.street1?.let { it1 -> Text(text = it1, style = TitleLight2) }
                    it.address_obj?.street2?.let { it1 -> Text(text =", "+ it1, style = TitleLight2) }

                }

                Spacer(modifier = Modifier.width(5.dp))
                Row (modifier = Modifier.padding(horizontal = 5.dp)){

                    it.address_obj?.city?.let { it1 ->
                        Text(text = "City: ", style = TitleBold2)
                        Text(text = it1, style = TitleLight2) }
                }
                Row (modifier = Modifier.padding(horizontal = 5.dp)){

                    it.address_obj?.country?.let { it1 ->
                        Text(text = "Country: ", style = TitleBold2)
                        Text(text = it1, style = TitleLight2) }
                }
                Spacer(modifier = Modifier.width(5.dp))
                Row (modifier = Modifier.padding(horizontal = 5.dp)){

                    it.email?.let { it1 ->
                        Text(text = "Email: ", style = TitleBold2)
                        Text(text = it1, style = TitleLight2) }
                }
                Spacer(modifier = Modifier.width(5.dp))
                Row (modifier = Modifier.padding(horizontal = 5.dp)){
                    it.phone?.let { it1 ->
                        Text(text = "Phone: ", style = TitleBold2)
                        Text(text = it1, style = TitleLight2) }
                }

                Spacer(modifier = Modifier.width(5.dp))
                Row (modifier = Modifier.padding(horizontal = 5.dp)){
                    it.website?.let { it1 ->
                        Text(text = "Website: ", style = TitleBold2)
                        Text(text = it1, style = TitleLight2) }
                }

                Spacer(modifier = Modifier.width(5.dp))
                Row (modifier = Modifier.padding(horizontal = 5.dp)){
                    it.hours?.weekday?.let { it1 ->
                        Text(text = "Opening hours: ")
                        Text(text = it1) }
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    GrayButton(text = "Chỉ đường",
                        textColor = Color.Black,
                        icon= {
                            Image(
                                painter = painterResource(id = R.drawable.direction),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                        },
                        fontFamily = Kanit_Light,
                        onclick = {context.startActivity(mapIntent)})
                }
            }

            // Hiển thị các thông tin khác tùy ý
        }
    }
//}@Composable
//
//fun LocationDetailScreen(
//    navHostController: NavHostController,
//    viewModel: LocationDetailViewModel,
//    id: String?
//) {
//    Log.d("XXXX",id.toString())
//    var locationId by remember { mutableStateOf<Int?>(null) }
//    val locationDetail by viewModel.locationDetail.observeAsState()
//    var id1= id?.toInt()
//    Column(
//        modifier = Modifier
//            .padding(16.dp)
//            .fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        TextField(
//            value = locationId?.toString() ?: "",
//            onValueChange = {
//                locationId = it.toIntOrNull()
//            },
//            label = { androidx.compose.material.Text("Enter Location ID") },
//            isError = locationId == null
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = {
//                locationId?.let {
//                    viewModel.getLocationDetail(id1!!, "7904AD3CB20F4523B18C73F170779ED9")
//                }
//            },
//            enabled = locationId != null
//        ) {
//            androidx.compose.material.Text("Get Location Details")
//        }
//
//        locationDetail?.let {
//            Spacer(modifier = Modifier.height(16.dp))
//            androidx.compose.material.Text("Location Name: ${it.name}")
//            // Hiển thị các thông tin khác tùy ý
//        }
//    }
//}

//locationDetailViewModel.locationDetails.value?.let { detail ->
//    Text(text = detail.name)
//    Text(text = detail.phone)
//}
//phone:String,navHostController: NavHostController, locationDetailViewModel: LocationDetailViewModel, selectedLocationModel: SelectedLocationModel