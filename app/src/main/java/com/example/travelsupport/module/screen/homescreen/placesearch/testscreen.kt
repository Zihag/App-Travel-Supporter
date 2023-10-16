package com.example.travelsupport.module.screen.homescreen.placesearch

import android.util.Log
import android.widget.Toast
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelsupport.R
import com.example.travelsupport.module.button.HeartButton
import com.example.travelsupport.ui.theme.Kanit_Light
import com.example.travelsupport.ui.theme.Kanit_SemiBold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Test() {

    Card(
        onClick = {

        },
        modifier = Modifier
            .padding(
                8.dp,
                8.dp,
                8.dp,
                8.dp
            ) //canh lề cho card đầu tiên không bị cắt khi cuôn
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
            ) {
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
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(30.dp)
                        ) {
                            Spacer(modifier = Modifier.width(250.dp))
                            HeartButton(
                                onClick = {}, modifier = Modifier
                            ) {
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
                        .padding(10.dp, 7.dp)
                ) {
                    Text(
                        text = "basddsadsd",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontFamily = Kanit_SemiBold,
                        fontSize = 13.sp
                    )
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.placeholder),
                            contentDescription = null,
                            modifier = Modifier
                                .size(15.dp)
                        )
                        Text(
                            text = "aladssadsadsa",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontFamily = Kanit_Light,
                            fontSize = 13.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PrevTest() {
    Test()
}

//                    Text(text = "Pho Co Ha Noi", modifier = Modifier.padding(16.dp),
//        color = Color.Black,
//        textAlign = TextAlign.Center,
//        fontFamily = Kanit_SemiBold,
//        fontSize = 13.sp)}
//Text(text = "Ha Noi", modifier = Modifier.padding(16.dp),
//color = Color.Black,
//textAlign = TextAlign.Center,
//fontFamily = Kanit_Light,
//fontSize = 13.sp,
//maxLines = 1,
//overflow = TextOverflow.Ellipsis,)
