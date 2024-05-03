package com.example.salesapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.example.salesapplication.ui.theme.SalesApplicationTheme

class ChairsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyChairs()

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyChairs(){
    Column(
        modifier = Modifier
            .fillMaxSize()) {

        val mContext = LocalContext.current

        //top up bar
        TopAppBar(title = { Text(text = "", color = Color.Black) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.White),
            navigationIcon = {
                IconButton(onClick = {
                    mContext.startActivity(Intent(mContext, MainActivity::class.java))
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow back",
                        tint = Color.Black
                    )
                }
            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "cart",
                        tint = Color.Black
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "menu",
                        tint = Color.Black
                    )
                }


            }
        )
        //end of top up bar
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                Text(text = "Chairs",
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.width(20.dp))

                Text(text = "Tables",
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.width(20.dp))

                Text(text = "Sofa",
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "Beds",
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.width(20.dp))

            }
            Row {
                Text(
                    text = "120 Products",
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                   Row {
                       Text(
                           text = "Popular",
                           fontSize = 20.sp,
                           fontFamily = FontFamily.Serif,
                           fontWeight = FontWeight.Bold,
                       )
                       IconButton(onClick = {
                           mContext.startActivity(Intent(mContext, LeadActivity::class.java))
                       }) {
                           Icon(
                               imageVector = Icons.Default.KeyboardArrowDown,
                               contentDescription = "Arrowdown",
                               tint = Color.Black
                           )
                       }
                   }
                }
            }

            }


            Spacer(modifier = Modifier.height(10.dp))

            //row 1
            Row {
                //column1
                Column {
                    Card(
                        modifier = Modifier
                            .height(100.dp)
                            .width(160.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.chair3),
                                contentDescription = "picture",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds
                            )

                        }


                    }
                    Text(
                        text = "Amos Chair ",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.ExtraBold,

                        )
                    Text(
                        text = "A chair With great comfort",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,

                        )
                    Text(
                        text = "that is worth every penny",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,

                        )
                    Spacer(modifier = Modifier.height(10.dp))

                    Row {
                        Text(
                            text = "KSH:7000.00",
                            fontFamily = FontFamily.Serif,
                            fontSize = 15.sp
                        )
                        Box(Modifier.padding(start = 50.dp))  {
                            IconButton(onClick = {
                                mContext.startActivity(Intent(mContext, LeadActivity::class.java))
                            }) {
                                Icon(
                                    imageVector = Icons.Default.ShoppingCart,
                                    contentDescription = "ShoppingCart",
                                    tint = Color.Black
                                )
                            }
                        }
                    }
                }
                //end of Column1
                Spacer(modifier = Modifier.width(20.dp))

                //column1
                Column {
                    Card(
                        modifier = Modifier
                            .height(100.dp)
                            .width(160.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.chair4),
                                contentDescription = "picture",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds
                            )

                        }


                    }
                    Text(
                        text = "KewChair ",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.ExtraBold,

                        )
                    Text(
                        text = "A chair With great comfort",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,

                        )
                    Text(
                        text = "that is worth every penny",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,

                        )
                    Spacer(modifier = Modifier.height(10.dp))

                    Row {
                        Text(
                            text = "KSH:10000.00",
                            fontFamily = FontFamily.Serif,
                            fontSize = 15.sp
                        )
                        Box(Modifier.padding(start = 50.dp))  {
                            IconButton(onClick = {
                                mContext.startActivity(Intent(mContext, LeadActivity::class.java))
                            }) {
                                Icon(
                                    imageVector = Icons.Default.ShoppingCart,
                                    contentDescription = "ShoppingCart",
                                    tint = Color.Black
                                )
                            }
                        }
                    }
                }
                //end of Column1
            }
            //end row
            //row 1
            Row {
                //column1
                Column {
                    Card(
                        modifier = Modifier
                            .height(100.dp)
                            .width(160.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.chair5),
                                contentDescription = "picture",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds
                            )

                        }


                    }
                    Text(
                        text = "Buro Chair ",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.ExtraBold,

                        )
                    Text(
                        text = "A chair With great comfort",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,

                        )
                    Text(
                        text = "that is worth every penny",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,

                        )
                    Spacer(modifier = Modifier.height(10.dp))

                    Row {
                        Text(
                            text = "KSH:8000.00",
                            fontFamily = FontFamily.Serif,
                            fontSize = 15.sp
                        )
                        Box(Modifier.padding(start = 50.dp))  {
                            IconButton(onClick = {
                                mContext.startActivity(Intent(mContext, LeadActivity::class.java))
                            }) {
                                Icon(
                                    imageVector = Icons.Default.ShoppingCart,
                                    contentDescription = "ShoppingCart",
                                    tint = Color.Black
                                )
                            }
                        }
                    }
                }
                //end of Column1
                Spacer(modifier = Modifier.width(10.dp))

                //column1
                Column {
                    Card(
                        modifier = Modifier
                            .height(100.dp)
                            .width(160.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.chair6),
                                contentDescription = "picture",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds
                            )

                        }


                    }
                    Text(
                        text = "Tinar Chair ",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.ExtraBold,

                        )
                    Text(
                        text = "A chair With great comfort",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,

                        )
                    Text(
                        text = "that is worth every penny",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,

                        )
                    Spacer(modifier = Modifier.height(10.dp))

                    Row {
                        Text(
                            text = "KSH:15000.00",
                            fontFamily = FontFamily.Serif,
                            fontSize = 15.sp
                        )
                        Box(Modifier.padding(start = 50.dp))  {
                            IconButton(onClick = {
                                mContext.startActivity(Intent(mContext, LeadActivity::class.java))
                            }) {
                                Icon(
                                    imageVector = Icons.Default.ShoppingCart,
                                    contentDescription = "ShoppingCart",
                                    tint = Color.Black
                                )
                            }
                        }
                    }
                }
                //end of Column1
            }
            //end row
            Spacer(modifier = Modifier.height(20.dp))
            //row 1
            Row {
                //column1
                Column {
                    Card(
                        modifier = Modifier
                            .height(100.dp)
                            .width(160.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.chair2),
                                contentDescription = "picture",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds
                            )

                        }


                    }
                    Text(
                        text = "Kronar Chair ",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.ExtraBold,

                        )
                    Text(
                        text = "A chair With great comfort",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,

                        )
                    Text(
                        text = "that is worth every penny",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,

                        )
                    Spacer(modifier = Modifier.height(10.dp))

                    Row {
                        Text(
                            text = "KSH:13000.00",
                            fontFamily = FontFamily.Serif,
                            fontSize = 15.sp
                        )
                        Box(Modifier.padding(start = 50.dp))  {
                            IconButton(onClick = {
                                mContext.startActivity(Intent(mContext, LeadActivity::class.java))
                            }) {
                                Icon(
                                    imageVector = Icons.Default.ShoppingCart,
                                    contentDescription = "ShoppingCart",
                                    tint = Color.Black
                                )
                            }
                        }
                    }
                }
                //end of Column1
                Spacer(modifier = Modifier.width(10.dp))

                //column1
                Column {
                    Card(
                        modifier = Modifier
                            .height(100.dp)
                            .width(160.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.chair1),
                                contentDescription = "picture",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds
                            )

                        }


                    }
                    Text(
                        text = "Granor Chair ",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.ExtraBold,

                        )
                    Text(
                        text = "A chair With great comfort",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,

                        )
                    Text(
                        text = "that is worth every penny",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,

                        )
                    Spacer(modifier = Modifier.height(10.dp))

                    Row {
                        Text(
                            text = "KSH:18000.00",
                            fontFamily = FontFamily.Serif,
                            fontSize = 15.sp
                        )
                        Box(Modifier.padding(start = 50.dp))  {
                            IconButton(onClick = {
                                mContext.startActivity(Intent(mContext, LeadActivity::class.java))
                            }) {
                                Icon(
                                    imageVector = Icons.Default.ShoppingCart,
                                    contentDescription = "ShoppingCart",
                                    tint = Color.Black
                                )
                            }
                        }
                    }
                }
                //end of Column1
            }
            //end row





        }
    }




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChairsPreview(){
    MyChairs()
}
