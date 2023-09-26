package com.example.travelsupport.module.list

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelsupport.ListPlace
import com.example.travelsupport.R
import com.example.travelsupport.module.button.HeartButton
import com.example.travelsupport.ui.theme.Kanit_Light
import com.example.travelsupport.ui.theme.Kanit_SemiBold
import com.example.travelsupport.ui.theme.LightBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomListView3(context: Context){
    lateinit var placeList: List<ListPlace>
    placeList = ArrayList<ListPlace>()

    placeList = placeList + ListPlace("Địa điểm 1", "Buon Ma Thuot, Vietnam" , R.drawable.bmt1)
    placeList = placeList + ListPlace("Địa điểm 2","Buon Ma Thuot, Vietnam" , R.drawable.bmt2)
    placeList = placeList + ListPlace("Địa điểm 3","Buon Ma Thuot, Vietnam" , R.drawable.bmt3)
    placeList = placeList + ListPlace("Địa điểm 4","Buon Ma Thuot, Vietnam" , R.drawable.bmt4)
    placeList = placeList + ListPlace("Địa điểm 5","Buon Ma Thuot, Vietnam" , R.drawable.bmt5)

    LazyRow(){
        itemsIndexed(placeList){index, item ->
            val isFirstCard = index == 0
            Card(
                onClick = {
                    Toast.makeText(
                        context,
                        placeList[index].placeName + "selected..",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                modifier = Modifier
                    .padding(if (isFirstCard) 20.dp else 8.dp, 8.dp, 8.dp, 8.dp)
                    .width(220.dp)
                    .height(300.dp)
                    .shadow(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(8.dp)
                    ),
                colors = CardDefaults.cardColors(Color.White)

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Box(
                            modifier = Modifier
                                .width(200.dp)
                                .height(200.dp)
                                .padding(top = 10.dp)
                                .clip(RoundedCornerShape(10.dp))
                        ) {
                            // Hình ảnh
                            Image(
                                painter = painterResource(id = placeList[index].placeImage),
                                contentDescription = "img",
                                modifier = Modifier
                                    .fillMaxSize(),
                                contentScale = ContentScale.Crop,
                            )
                            Column {
                                Spacer(modifier = Modifier.height(15.dp))
                                Row (modifier = Modifier
                                    .fillMaxWidth()
                                    .height(30.dp)){
                                    Spacer(modifier = Modifier.width(155.dp))
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
                            Text(text = placeList[index].placeName,
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontFamily = Kanit_SemiBold,
                                fontSize = 13.sp)
                            Row {
                                Image(painter = painterResource(id = R.drawable.placeholder),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(15.dp))
                                Text(text = placeList[index].placeLocate,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontFamily = Kanit_Light,
                                    fontSize = 13.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,)
                            }
                        }
                    }
                }
            }
        }
    }

}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListPlacePreview3() {
    CustomListView3(LocalContext.current)
}