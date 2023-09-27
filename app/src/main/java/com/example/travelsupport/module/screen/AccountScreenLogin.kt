package com.example.travelsupport.module.screen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.travelsupport.R
import com.example.travelsupport.ui.theme.H1Bold
import com.example.travelsupport.ui.theme.TitleBold2
import com.example.travelsupport.ui.theme.TitleLight2
import com.example.travelsupport.ui.theme.TitleSemiBold2

@Composable
fun AccountScreenLogin() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .zIndex(1f)) {
                    Text(text = "Tài khoản",
                        style = H1Bold,
                        modifier = Modifier
                            .padding(20.dp,20.dp,0.dp,0.dp),)
                    Image(painter = painterResource(id = R.drawable.userimg),
                        contentDescription = "User image",
                        Modifier
                            .padding(top = 20.dp, start = 130.dp)
                            .size(60.dp))
                }
                Image(painter = painterResource(id = R.drawable.bluebgacc),
                    contentDescription = "Banner background",
                    modifier = Modifier
                        .zIndex(0f)
                        .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp)),
                    contentScale = ContentScale.Crop)
                Text(text = "Name", style = TitleSemiBold2, fontSize = 20.sp,modifier = Modifier.padding(start = 300.dp, top = 80.dp))
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.Transparent),
                contentAlignment = Alignment.Center) {
                Column(modifier = Modifier.padding(horizontal = 15.dp)) {
                    OutlinedButton(onClick = {}, modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 30.dp),
                        border = BorderStroke(3.dp, Color.Black)
                    ) {
                        Text(text = "Đăng xuất", style = TitleSemiBold2, color = Color.Black)
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AccountLoginPreview(){
    AccountScreenLogin()
}