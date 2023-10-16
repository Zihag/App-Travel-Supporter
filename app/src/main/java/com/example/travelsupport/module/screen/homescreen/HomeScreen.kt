package com.example.travelsupport.module.screen.homescreen

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.travelsupport.module.list.CustomListView1
import com.example.travelsupport.module.list.CustomListView2
import com.example.travelsupport.module.list.CustomListView3
import com.example.travelsupport.R
import com.example.travelsupport.module.button.GrayButton
import com.example.travelsupport.module.screen.navigation.BottomBarScaffold
import com.example.travelsupport.ui.theme.Kanit_Bold
import com.example.travelsupport.ui.theme.LightBlue
import com.example.travelsupport.ui.theme.TitleBold1
import com.example.travelsupport.ui.theme.TitleLight2



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navHostController: NavHostController){
Scaffold (
    bottomBar ={
        BottomBarScaffold(navHostController)
    }
){
    paddingValues ->
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(paddingValues)
    ) {
        Box(modifier = Modifier.background(LightBlue)) {
            Column {
                Text(text = "Bạn sắp\nđến đâu?",
                    modifier = Modifier
                        .padding(20.dp,20.dp,0.dp,0.dp),
                    fontSize = 35.sp,
                    fontFamily = Kanit_Bold,
                    lineHeight = 30.sp)
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth(),) {
                    GrayButton(
                        text = "Địa điểm",
                        textColor = Color.Black,
                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.destination), // Thay đổi bằng tên biểu tượng tương ứng từ tài nguyên
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                        },
                        modifier = Modifier
                            .padding(20.dp, 35.dp, 0.dp, 10.dp)
                            .size(165.dp, 70.dp),
                        fontFamily = Kanit_Bold,
                        onclick = {
                            navHostController.navigate("location_search_screen")
                        }
                    )
                    GrayButton(
                        text = "Khách sạn",
                        textColor = Color.Black,
                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.hotel), // Thay đổi bằng tên biểu tượng tương ứng từ tài nguyên
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                        },
                        modifier = Modifier
                            .padding(0.dp, 35.dp, 20.dp, 10.dp)
                            .size(165.dp, 70.dp),
                        fontFamily = Kanit_Bold,
                        onclick = {
                            //Home sang search

                        }
                    )
                }
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()){
                    GrayButton(
                        text = "Nhà hàng",
                        textColor = Color.Black,
                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.cutlery), // Thay đổi bằng tên biểu tượng tương ứng từ tài nguyên
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                        },
                        modifier = Modifier
                            .padding(20.dp, 10.dp, 0.dp, 18.dp)
                            .size(165.dp, 70.dp),
                        fontFamily = Kanit_Bold,
                        onclick = {
                            navHostController.navigate("restaurant_search_screen")

                        }
                    )
                    GrayButton(
                        text = "Khám phá",
                        textColor = Color.Black,
                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.explore), // Thay đổi bằng tên biểu tượng tương ứng từ tài nguyên
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                        },
                        modifier = Modifier
                            .padding(0.dp, 10.dp, 20.dp, 18.dp)
                            .size(165.dp, 70.dp),
                        fontFamily = Kanit_Bold,
                        onclick = {}
                    )
                }
            }
        }

        Text(text = "Bạn có thể thích những nội dung này",
            modifier = Modifier
                .padding(20.dp,10.dp,20.dp,0.dp),
            style = TitleBold1
        )
        Text(text = "Các địa điểm nổi tiếng tại Hà Nội, thủ đô nghìn năm văn hiến",
            modifier = Modifier
                .padding(20.dp,7.dp,20.dp,0.dp),
            style = TitleLight2
        )
        CustomListView1(LocalContext.current)
        Text(text = "Ghé thăm thủ phủ cà phê Buôn Ma Thuột",
            modifier = Modifier
                .padding(20.dp,7.dp,20.dp,0.dp),
            style = TitleBold1
        )
        Text(text = "Cảnh quan hùng vĩ, cà phê bạt ngàn và những thác nước cuồn cuộn",
            modifier = Modifier
                .padding(20.dp,7.dp,20.dp,0.dp),
            style = TitleLight2
        )
        CustomListView3(LocalContext.current)
        Text(text = "Ghé thăm đô thị lớn, náo nhiệt và năng động",
            modifier = Modifier
                .padding(20.dp,7.dp,20.dp,0.dp),
            style = TitleBold1
        )
        Text(text ="Lập kế hoạch cho hành trình khám phá Sài Gòn",
            modifier = Modifier
                .padding(20.dp,7.dp,20.dp,0.dp),
            style = TitleLight2
        )
        CustomListView2(LocalContext.current)
        Text(text = "Khám phá tinh hoa ẩm thực các quốc gia",
            modifier = Modifier
                .padding(20.dp,7.dp,20.dp,0.dp),
            style = TitleBold1
        )
    }
}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview1() {

}