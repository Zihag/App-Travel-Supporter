package com.example.travelsupport.module.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travelsupport.R

@Composable
fun HeartButton(
    onClick: () -> Unit,
    modifier: Modifier,
    function: () -> Unit,
){
    var isYellow by remember { mutableStateOf(false) }

    val buttonColor = if (isYellow) Color.Yellow else Color.White
    IconButton(
        onClick = {
            isYellow = !isYellow
            onClick()
        },
        modifier = Modifier
            .size(30.dp)
            .border(
                1.dp,
                Color.Black,
                shape = CircleShape,
            )
            .background(buttonColor, CircleShape)) {
        Image(painter = painterResource(id = R.drawable.favorite), contentDescription =null,Modifier.size(18.dp))
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HeartButtonPreview() {
    HeartButton(onClick = {}, modifier = Modifier) {
    }
}