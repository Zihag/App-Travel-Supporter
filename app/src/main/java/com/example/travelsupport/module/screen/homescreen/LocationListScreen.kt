package com.example.travelsupport.module.screen.homescreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.travelsupport.R
import com.example.travelsupport.module.button.HeartButton
import com.example.travelsupport.module.screen.homescreen.apiservice.Info
import com.example.travelsupport.module.screen.homescreen.apiservice.diadiem
import com.example.travelsupport.module.screen.homescreen.locationmodel.SelectedLocationModel
import com.example.travelsupport.ui.theme.Kanit_Light
import com.example.travelsupport.ui.theme.Kanit_SemiBold
import com.example.travelsupport.ui.theme.LightBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationList(locations: List<diadiem>, navHostController:NavHostController) {


    LazyColumn (modifier = Modifier.fillMaxSize()
        .background(LightBlue)){
        items(locations) { it ->
            if (it.address_obj?.city != null){
                Card(onClick = { navHostController.navigate("location_detail_screen/${it.location_id}") },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .shadow(
                            elevation = 10.dp,
                            shape = RoundedCornerShape(8.dp)
                        ),
                    colors = CardDefaults.cardColors(Color.White)) {
                    Column(modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .padding(10.dp)
                                .clip(RoundedCornerShape(10.dp))
                        ) {
                            // Hình ảnh
                            Image(
                                painter = painterResource(R.drawable.hanoi1),
                                contentDescription = "img",
                                modifier = Modifier
                                    .fillMaxSize(),
                                contentScale = ContentScale.FillWidth,
                            )
                            Column {
                                Spacer(modifier = Modifier.height(15.dp))
                                Row (modifier = Modifier
                                    .fillMaxWidth()
                                    .height(30.dp)){
                                    Spacer(modifier = Modifier.width(270.dp))
                                    HeartButton(
                                        onClick = {}, modifier = Modifier){
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(10.dp,7.dp)
                        ) {
                            it.name?.let { it1 -> Text(text = it1,
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontFamily = Kanit_SemiBold,
                                fontSize = 13.sp)}


                            Row {
                                Image(painter = painterResource(id = R.drawable.placeholder),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(15.dp))
                                Text(text = "${it.address_obj.city}",
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontFamily = Kanit_Light,
                                    fontSize = 13.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,)

                                if(it.address_obj.state != null){
                                    Text(text = ", ",
                                        color = Color.Black,
                                        textAlign = TextAlign.Center,
                                        fontFamily = Kanit_Light,
                                        fontSize = 13.sp,)
                                    Text(text = "${it.address_obj.state}",
                                        color = Color.Black,
                                        textAlign = TextAlign.Center,
                                        fontFamily = Kanit_Light,
                                        fontSize = 13.sp,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,) }

                                if(it.address_obj.country != null){
                                    Text(text = ", ",
                                        color = Color.Black,
                                        textAlign = TextAlign.Center,
                                        fontFamily = Kanit_Light,
                                        fontSize = 13.sp,)
                                    Text(text = "${it.address_obj.country}",
                                        color = Color.Black,
                                        textAlign = TextAlign.Center,
                                        fontFamily = Kanit_Light,
                                        fontSize = 13.sp,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,) }

                                 }
                        }

                    }
                }
            }
            Log.d("LocationList", "Location List")

                            }
                        }
                    }

