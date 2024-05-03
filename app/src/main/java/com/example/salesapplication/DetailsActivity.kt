package com.example.salesapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.salesapplication.ui.theme.Bluish
import com.google.firebase.firestore.FirebaseFirestore

class DetailsActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var employeeList = mutableStateListOf<employees?>()
            var db: FirebaseFirestore = FirebaseFirestore.getInstance()
            db.collection("Employees").get()
                .addOnSuccessListener { queryDocumentSnapshots ->
                    if (!queryDocumentSnapshots.isEmpty) {
                        val list = queryDocumentSnapshots.documents
                        for (d in list) {
                            val c: employees? = d.toObject(employees::class.java)
                            employeeList.add(c)

                        }
                    } else {
                        Toast.makeText(this@DetailsActivity, "No data found in Database", Toast.LENGTH_SHORT).show()
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(this@DetailsActivity, "Fail to get the data.", Toast.LENGTH_SHORT).show()
                }
            FirebaseUI(LocalContext.current, employeeList)
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun FirebaseUI(context: Context, employeeList: SnapshotStateList<employees?>) {
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //TopAppBar -displays information and actions relating to the current screen and is placed at the top of the screen.
        TopAppBar(
            title = { Text(text = "Employees Registered", fontSize = 15.sp)},
            colors = TopAppBarDefaults.mediumTopAppBarColors(Bluish),
            navigationIcon = {
                IconButton(onClick = { context.startActivity(Intent(context,InsertActivity::class.java))}) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "arrowback")
                }
            }
        )

        LazyColumn {
            itemsIndexed(employeeList) { index, item ->
                Card(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Column(modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                    ) {
                        Spacer(modifier = Modifier.width(5.dp))


                        Row {

                            Text(text = "Employee Name :", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                            employeeList[index]?.employeeName?.let {
                                Text(
                                    text = it,
                                    modifier = Modifier.padding(4.dp),
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold

                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(5.dp))

                        Row {

                            Text(text = "Course Duration :", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                            employeeList[index]?.employeeAge?.let {
                                Text(
                                    text = it,
                                    modifier = Modifier.padding(4.dp),
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 15.sp

                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(5.dp))

                        Row {

                            Text(text = "Course Description :", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                            employeeList[index]?.employeeQualification?.let {
                                Text(
                                    text = it,
                                    modifier = Modifier.padding(4.dp),
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 15.sp
                                )
                            }
                        }
                    }
                }
            }

        }
    }
}
@Preview(showBackground = true)
@Composable
fun EmployeeDetailsPreview() {


}