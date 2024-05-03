package com.example.salesapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.salesapplication.ui.theme.Bluish
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class InsertActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            firebaseUI()

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun firebaseUI() {
    val context= LocalContext.current
    val employeeName = remember { mutableStateOf("") }
    val employeeAge = remember { mutableStateOf("") }
    val employeeQualification = remember { mutableStateOf("") }


    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Add Course",
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive
        )

        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(id = R.drawable.chair),
            contentDescription = "course",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = employeeName.value,
            onValueChange = { employeeName.value = it },
            placeholder = { Text(text = "Enter your course name") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = employeeAge.value,
            onValueChange = { employeeAge.value = it },
            placeholder = { Text(text = "Enter your course duration") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = employeeQualification.value,
            onValueChange = { employeeQualification.value = it },
            placeholder = { Text(text = "Enter your course description") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = {
                if (TextUtils.isEmpty(employeeName.value.toString())) {
                    Toast.makeText(context, "Please enter course name", Toast.LENGTH_SHORT)
                        .show()
                } else if (TextUtils.isEmpty(employeeAge.value.toString())) {
                    Toast.makeText(context, "Please enter course Duration", Toast.LENGTH_SHORT)
                        .show()
                } else if (TextUtils.isEmpty(employeeQualification.value.toString())) {
                    Toast.makeText(
                        context,
                        "Please enter course descritpion",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {
                    addDataToFirebase(
                        employeeName.value, employeeAge.value, employeeQualification.value, context
                    )
                }
            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(Bluish),
            shape = RoundedCornerShape(5.dp)
        ) {

            Text(text = "Add Data", modifier = Modifier.padding(8.dp))
        }

        Spacer(modifier = Modifier.height(5.dp))


        Text(
            text = "View Courses",
            color = Bluish,
            modifier = Modifier
                .clickable {
                    context.startActivity(Intent(context, DetailsActivity::class.java))
                }
                .padding(8.dp))
    }

}



fun addDataToFirebase(employeeName: String, employeeAge: String, employeeQuailification: String,
                      context: Context
) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val dbCourses: CollectionReference = db.collection("Employees")
    val courses = Course(employeeName, employeeQuailification, employeeAge)
    dbCourses.add(courses).addOnSuccessListener {
        Toast.makeText(context, "Your Employees has been added to Firebase Firestore", Toast.LENGTH_SHORT).show()

    }.addOnFailureListener { e ->
        Toast.makeText(context, "Fail to add Employee", Toast.LENGTH_SHORT).show()
    }

}

@Preview(showBackground = true)
@Composable
fun FirebaseUiPreview() {
    firebaseUI()
}