package com.example.travelsupport.module.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.travelsupport.R
import com.example.travelsupport.ui.theme.Kanit_Light
import com.example.travelsupport.ui.theme.LightBlue
import com.example.travelsupport.ui.theme.White1


// BỎ
@Composable
fun MainScreen() {

    val selectedItem = rememberSaveable { mutableStateOf(0) }

    Column(verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .zIndex(1f)) {
        Row(
            modifier = Modifier
                .fillMaxWidth() // Đặt chiều rộng của hàng bằng chiều rộng của màn hình
        ) {
            // Thanh ngang 1
            Box(
                modifier = Modifier
                    .weight(1f)// Chia đều chiều rộng cho ba thanh
                    .padding(start = 20.dp, end = 20.dp)
                    .height(4.dp)
                    .clip(RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp))
                    .background(if (selectedItem.value == 0) LightBlue else Color.Transparent),
            )
//             Thanh ngang 2
            Box(
                modifier = Modifier
                    .weight(1f) // Chia đều chiều rộng cho ba thanh
                    .padding(start = 20.dp, end = 20.dp)
                    .height(4.dp)
                    .clip(RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp))
                    .background(if (selectedItem.value == 1) LightBlue else Color.Transparent),
            )

            // Thanh ngang 3
            Box(
                modifier = Modifier
                    .weight(1f) // Chia đều chiều rộng cho ba thanh
                    .padding(start = 20.dp, end = 20.dp)
                    .height(4.dp)
                    .clip(RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp))
                    .background(if (selectedItem.value == 2) LightBlue else Color.Transparent),
            )
            Box(
                modifier = Modifier
                    .weight(1f) // Chia đều chiều rộng cho ba thanh
                    .padding(start = 20.dp, end = 20.dp)
                    .height(4.dp)
                    .clip(RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp))
                    .background(if (selectedItem.value == 3) LightBlue else Color.Transparent),
            )
        }
        BottomNavigation(
            modifier = Modifier
                .height(55.dp)
                .clip(RoundedCornerShape(20.dp)),
            backgroundColor = LightBlue,
            elevation = BottomNavigationDefaults.Elevation
        ) {
            BottomNavigationItem(
                selected = selectedItem.value == 0,
                onClick = { selectedItem.value = 0 },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = null,
                        modifier = Modifier.size(23.dp),
                        //khi chọn sẽ về màu mặc định, k chọn thì xám
                        colorFilter = if(selectedItem.value==0) null else ColorFilter.tint(color = Color.Gray),
                    )
                },
                label = {
                    Text(text = "Khám phá",
                        fontSize = 12.sp,
                        fontFamily = Kanit_Light,
                        color = if(selectedItem.value==0) Color.Black else Color.Gray)
                })
            BottomNavigationItem(
                selected = selectedItem.value == 1,
                onClick = { selectedItem.value = 1 },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.lover),
                        contentDescription = null,
                        modifier = Modifier.size(23.dp),
                        //khi chọn sẽ về màu mặc định, k chọn thì xám
                        colorFilter = if(selectedItem.value==1) null else ColorFilter.tint(color = Color.Gray)
                    )
                },
                label = {
                    Text(text = "Yêu thích",
                        fontSize = 12.sp,
                        fontFamily = Kanit_Light,
                        color = if(selectedItem.value==1) Color.Black else Color.Gray)
                })
            BottomNavigationItem(
                selected = selectedItem.value == 2,
                onClick = { selectedItem.value = 2 },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.pen),
                        contentDescription = null,
                        modifier = Modifier.size(23.dp),
                        //khi chọn sẽ về màu mặc định, k chọn thì xám
                        colorFilter = if(selectedItem.value==2) null else ColorFilter.tint(color = Color.Gray)
                    )
                },
                label = {
                    Text(text = "Ghi chú",
                        fontSize = 12.sp,
                        fontFamily = Kanit_Light,
                        color = if(selectedItem.value==2) Color.Black else Color.Gray)
                })
            BottomNavigationItem(
                selected = selectedItem.value == 3,
                onClick = { selectedItem.value = 3 },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = null,
                        modifier = Modifier.size(23.dp),
                        //khi chọn sẽ về màu mặc định, k chọn thì xám
                        colorFilter = if(selectedItem.value==3) null else ColorFilter.tint(color = Color.Gray)
                    )
                },
                label = {
                    Text(text = "Tài khoản",
                        fontSize = 12.sp,
                        fontFamily = Kanit_Light,
                        color = if(selectedItem.value==3) Color.Black else Color.Gray)
                })
        }
    }
    when (selectedItem.value){
        0 -> HomeScreen()
        1 -> FavoriteScreen()
        2 -> PlanScreen()
        3 -> AccountScreenNotLogin()
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewBar() {
    MainScreen()
}