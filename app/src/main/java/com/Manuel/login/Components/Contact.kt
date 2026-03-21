package com.Manuel.login.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.Manuel.login.R

@Composable
fun contact(
    name: String,
    phone: String,
    modifier: Modifier = Modifier
){
    Row() {
        Image(
            painter = painterResource(id = R.drawable.login_background),
            contentDescription = "Foto de contacto",
            modifier = Modifier.size(60.dp)
        )

        Spacer(modifier= Modifier.width(16.dp))

        Column() {

            Text(
                text = name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black

            )

            Text(
                text = phone,
                fontSize = 18.sp

            )

        }
    }
}