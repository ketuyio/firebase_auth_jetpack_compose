package com.example.salesapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.salesapplication.ui.theme.SalesApplicationTheme
import com.example.salesapplication.ui.theme.Yellowish

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFurniture()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyFurniture(){
    Column(modifier = Modifier
        .background(Color.LightGray)
        .fillMaxSize()){

        val mContext = LocalContext.current

        //top up bar
        TopAppBar(title = { Text(text = "", color = Color.Black) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.LightGray),

            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "shoppingcart",
                        tint = Color.Black)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = Color.Black)
                }

            }
        )
        //end of top up bar
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            Text(text = "Featured",
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                )
            Spacer(modifier = Modifier.width(20.dp))

            Text(text = "New",
                modifier = Modifier.clickable {
                    mContext.startActivity(Intent(mContext,ChairsActivity::class.java))
                 },
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.width(20.dp))

            Text(text = "Collection",
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.width(20.dp))

        }
        //end of row

        Card(modifier = Modifier
            .padding(start = 10.dp)
            .width(370.dp)
            .height(200.dp)) {
            Row {
                Column {
                    Text(text = "The Classic",
                        fontSize = 25.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = Yellowish)
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(text = "Classic appearance  ",
                        fontSize = 20.sp)
                    Text(text = " with a splash color",
                        fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    
                    IconButton(onClick = { /*TODO*/ })

                     {
                        Icon(imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Arrowforward",
                            tint = Color.Black)
                    }

                }
                Box(modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                    contentAlignment = Alignment.Center) {
                    Image(painter = painterResource(id = R.drawable.chair6),
                        contentDescription ="picture",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop)

                }
            }
        }
        //end of card
        Spacer(modifier = Modifier.height(20.dp))
       Row {
           Text(text = "Best sellers",
               fontSize = 25.sp,
               fontFamily = FontFamily.Serif,
               fontWeight = FontWeight.Bold,
           )
           Box(modifier = Modifier.fillMaxWidth(),
               contentAlignment = Alignment.CenterEnd) {
               Button(onClick = {
                   mContext.startActivity(Intent(mContext,LeadActivity::class.java))
               },
                   shape = RoundedCornerShape(5.dp),
                   colors = ButtonDefaults.buttonColors(Color.LightGray),
                   modifier = Modifier
                       .padding(start = 30.dp, end = 5.dp)) {
                   Text(text = "View All",
                       color = Yellowish)

               }
       }

        }

        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            //card one

            Card(
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.table4),
                            contentDescription = "picture",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                    }
                }

            }
            //end of card
            Spacer(modifier = Modifier.width(10.dp))
            //card two

            Card(
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.chair5),
                            contentDescription = "picture",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                    }
                }

            }
            //end of card
            Spacer(modifier = Modifier.width(10.dp))
            //card three

            Card(
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.chair),
                            contentDescription = "picture",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                    }
                }

            }
            //end of card
            Spacer(modifier = Modifier.width(10.dp))
            //card four

            Card(
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.chair1),
                            contentDescription = "picture",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                    }
                }

            }
            //end of card
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(text = "Best sellers",
                fontSize = 25.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
            )
            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd) {
                Button(onClick = {
                    mContext.startActivity(Intent(mContext,LeadActivity::class.java))
                },
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(Color.LightGray),
                    modifier = Modifier
                        .padding(start = 30.dp, end = 5.dp)) {
                    Text(text = "View All",
                        color = Yellowish)

                }
            }

        }
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            //card one

            Card(
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.table2),
                            contentDescription = "picture",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                    }
                }

            }
            //end of card
            Spacer(modifier = Modifier.width(10.dp))
            //card two

            Card(
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.chair3),
                            contentDescription = "picture",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                    }
                }

            }
            //end of card
            Spacer(modifier = Modifier.width(10.dp))
            //card three

            Card(
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.table),
                            contentDescription = "picture",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                    }
                }

            }
            //end of card
            Spacer(modifier = Modifier.width(10.dp))
            //card four

            Card(
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.table7),
                            contentDescription = "picture",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                    }
                }

            }
            //end of card
        }




    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FurniturePreview() {
    MyFurniture()
}