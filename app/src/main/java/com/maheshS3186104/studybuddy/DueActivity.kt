package com.maheshS3186104.studybuddy

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class DueActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DueActivityScreen()
        }
    }
}

@Composable
fun DueActivityScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(id = R.color.crimson_red)
                )
                .padding(vertical = 6.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "Back Arrow",
                modifier = Modifier
                    .width(36.dp)
                    .height(36.dp)
                    .clickable {
                        (context as Activity).finish()
                    }
            )
            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Due Dates",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = Color.White,

                )

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            Text(
                text = "16 December 2024",
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 12.dp, top = 8.dp)
            )

            val dueData1 = DueData()

            dueData1.taskName = "Task 5"
            dueData1.dueDate = "14/12/2024, 05:29"
            dueData1.taskDetails = "CIS4083-N-BE1-2024; Object-Oriented_Development"

            DueItem(dueData = dueData1)
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "7 January 2025",
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 12.dp, top = 8.dp)
            )

            val dueData2 = DueData()

            dueData2.taskName ="ICA Submission Link - Please upload one PDF file (both Sections 1 and 2 of the report) and the PowerBI file"
            dueData2.dueDate = "07/01/2025, 21:30"
            dueData2.taskDetails = "CI54008-N-BE1-2024: Big Data_and Business intelligence"

            DueItem(dueData = dueData2)
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "8 January 2025",
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 12.dp, top = 8.dp)
            )

            val dueData3 = DueData()

            dueData3.taskName = "ICA Submission_Link"
            dueData3.dueDate = "08/01 /2025, 05:29"
            dueData3.taskDetails = "CIS4049-N-BF1-2024: Artificial Intelligence Foundations"

            DueItem(dueData = dueData3)
            Spacer(modifier = Modifier.height(8.dp))

            val dueData4 = DueData()

            dueData4.taskName = "ICA Report submission"
            dueData4.dueDate = "08/01/2025, 05:29"
            dueData4.taskDetails = "CIS4049-N-BF1-2024: Artificial Intelligence Foundations"

            DueItem(dueData = dueData4)
            Spacer(modifier = Modifier.height(8.dp))

            val dueData5 = DueData()

            dueData5.taskName = "Task 6"
            dueData5.dueDate = "08/01/2025, 16:18"
            dueData5.taskDetails = "CIS4083-NBE1-2024: Object-Oriented Development"

            DueItem(dueData = dueData5)
            Spacer(modifier = Modifier.height(8.dp))

        }

    }
}

@Composable
fun DueItem(dueData: DueData) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.list), // Replace with your image resource
                    contentDescription = "Task Image",
                    modifier = Modifier
                        .size(36.dp), // Optional: Circular image
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {

                    Text(
                        text = dueData.taskName,
                        color = Color.Black,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 12.dp, top = 8.dp)
                    )

                    Text(
                        text = "Due Date : ${dueData.dueDate}",
                        color = Color.Black,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 12.dp, top = 8.dp)
                    )

                }
            }

            Text(
                text = dueData.taskDetails,
                color = Color.Blue,
                fontSize = 14.sp,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier.padding(start = 12.dp, top = 8.dp)
            )

        }
    }
}

data class DueData(
    var imageRes: Int = 0,
    var taskName: String = "",
    var dueDate: String = "",
    var taskDetails: String = "",
)