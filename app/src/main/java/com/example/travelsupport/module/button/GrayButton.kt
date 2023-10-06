package com.example.travelsupport.module.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travelsupport.R
import com.example.travelsupport.ui.theme.Kanit_Light
import com.example.travelsupport.ui.theme.LightBlue
import com.example.travelsupport.ui.theme.White1

@Composable
fun GrayButton(
    text: String,
    textColor: Color,
    icon: @Composable () -> Unit, // Tham số cho biểu tượng từ ảnh PNG
    modifier: Modifier = Modifier,
    fontFamily: FontFamily? = null,
    onclick: ()->Unit
) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(Color.White),
        shape = RoundedCornerShape(20),
        modifier = modifier
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(8.dp)
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon() // Hiển thị biểu tượng từ tham số
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                color = textColor,
                fontFamily = fontFamily,)
        }
    }
}

@Preview
@Composable
fun GrayButtonPreview(){
    GrayButton(
        text = "gray button",
        textColor = Color.Black,
        icon = {
            Image(
                painter = painterResource(id = R.drawable.favorite), // Thay đổi bằng tên biểu tượng tương ứng từ tài nguyên
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        },
        fontFamily = Kanit_Light,
        onclick = {}
    )
}
