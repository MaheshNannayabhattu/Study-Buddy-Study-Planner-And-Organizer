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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maheshS3186104.studybuddy.modalClass.TaskStorage

data class StudySchedule(
    val day: String,
    val subjectName: String,
    val topic: String,
    val startTime: String,
    val endTime: String
)

@Composable
fun StudyScheduleScreen() {
    val context = LocalContext.current

    val daysOfWeek =
        listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    var selectedDay by remember { mutableStateOf(daysOfWeek[0]) }

    val filteredPlan = TaskStorage.getSchedule(context, selectedDay)

    var isPopupVisible by remember { mutableStateOf(false) }

    var subjectName by remember { mutableStateOf("") }
    var topic by remember { mutableStateOf("") }
    var startTime by remember { mutableStateOf("") }
    var endTime by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.crimson_red))
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

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Daily Schedule",
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
        }


        Column(
            modifier = Modifier
        ) {

            // Chips for filtering categories
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                items(daysOfWeek.size) { index ->
                    Chip(
                        isSelected = selectedDay == daysOfWeek[index],
                        text = daysOfWeek[index],
                        onClick = { selectedDay = daysOfWeek[index] }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (filteredPlan.isNotEmpty()) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 12.dp)
            ) {

                items(filteredPlan.size) { index ->
                    ItemStudySchedule(filteredPlan[index])
                    Spacer(modifier = Modifier.height(6.dp))
                }
            }
        } else {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "No Schedule Added",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        // Add Button
//        Button(onClick = { isPopupVisible = true }) {
//            Text(text = "Add Schedule")
//        }

        Column(
            modifier = Modifier
                .clickable { isPopupVisible = true }
                .fillMaxWidth()
                .padding(vertical = 6.dp, horizontal = 16.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(
                    color = colorResource(id = R.color.crimson_red)
                )
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Add Schedule",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = Color.White
            )
        }

        if (isPopupVisible) {
            AlertDialog(
                onDismissRequest = { isPopupVisible = false },
                title = { Text(text = "Add Study Schedule") },
                text = {
                    Column(modifier = Modifier.padding(8.dp)) {
                        // Input fields
                        TextField(
                            value = subjectName,
                            onValueChange = { subjectName = it },
                            label = { Text("Subject Name") }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = topic,
                            onValueChange = { topic = it },
                            label = { Text("Topic") }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = startTime,
                            onValueChange = { startTime = it },
                            label = { Text("Start Time") }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = endTime,
                            onValueChange = { endTime = it },
                            label = { Text("End Time") }
                        )
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            val stu = StudySchedule(
                                day = selectedDay,
                                subjectName = subjectName,
                                topic = topic,
                                startTime = startTime,
                                endTime = endTime
                            )

                            TaskStorage.saveSchedule(context, stu, selectedDay)

                            isPopupVisible = false
                            subjectName = ""
                            topic = ""
                            startTime = ""
                            endTime = ""
                        }
                    ) {
                        Text(text = "Save")
                    }
                },
                dismissButton = {
                    Button(onClick = { isPopupVisible = false }) {
                        Text(text = "Cancel")
                    }
                }
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun StudyScheduleScreenPreview() {
    StudyScheduleScreen()
}

class StudyScheduleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyScheduleScreen()
        }
    }
}


@Composable
fun ItemStudySchedule(studySchedule: StudySchedule) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    )
    {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        {
            Row {
                Text(
                    text = "Subject : ",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 6.dp, top = 12.dp)

                )

                Text(
                    text = studySchedule.subjectName,
                    color = Color.Black,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 6.dp, top = 12.dp)
                )
            }

            Row {

                Text(
                    text = "Topic : ",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 6.dp, top = 12.dp)

                )

                Text(
                    text = studySchedule.topic,
                    color = Color.Black,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 6.dp, top = 12.dp)
                )
            }

            Row {
                Text(
                    text = "Start Time : ",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 6.dp, top = 12.dp)

                )

                Text(
                    text = studySchedule.startTime,
                    color = Color.Black,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 6.dp, top = 12.dp)
                )
            }


            Row {

                Text(
                    text = "End Time : ",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 6.dp, top = 12.dp)
                )

                Text(
                    text = studySchedule.endTime,
                    color = Color.Black,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 6.dp, top = 12.dp)
                )
            }

        }
    }

}






