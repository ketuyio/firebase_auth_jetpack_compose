package com.example.salesapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.salesapplication.ui.theme.Bluish
import com.example.salesapplication.ui.theme.SalesApplicationTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ShowActivity2 : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPicture2()

            val mContext = LocalContext.current
            val coroutine = rememberCoroutineScope()
            coroutine.launch {
                delay(3000)
                mContext.startActivity(Intent(mContext,ShowActivity3::class.java))
            }

        }
    }
}

@Composable
fun MyPicture2(){
    Column(modifier = Modifier
        .background(Bluish)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        val mContext = LocalContext.current
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center) {
            Image(painter = painterResource(id = R.drawable.sales5),
                contentDescription = "Nairobi exchange",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(350.dp),
                contentScale = ContentScale.Crop)
        }
        Text(text = "Add to Your Cart",
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.ExtraBold,)

        Text(
            text = "Android is an app platform with refined user interface that eases compatablity with functions that makes day to day life easy to humanity.",
            textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            mContext.startActivity(Intent(mContext,ShowActivity3::class.java))
        },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Red),
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp)

                .fillMaxWidth()

        ) {
            Text(text = "Next")
        }



    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Picture2Preview(){
    MyPicture2()
}