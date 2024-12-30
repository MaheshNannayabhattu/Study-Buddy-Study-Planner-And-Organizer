package com.maheshS3186104.studybuddy

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UpcomingDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UpcomingDetailsScreen()
//            ModuleSelection()
        }
    }
}


@Composable
fun UpcomingDetailsScreen() {

    val context = LocalContext.current as Activity

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.soft_peach)),
    )
    {


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
                text = "Activity Details",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = Color.White,

                )

        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .background(color = colorResource(id = R.color.soft_peach))
        )
        {
            Text(text = "Activity Details : ")
            Spacer(modifier = Modifier.width(12.dp))

            Text(text = SelectModule.module.moduleTitle)
        }


        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        )
        {
            Text(text = "Module Leader : ")
            Spacer(modifier = Modifier.width(12.dp))

            Text(text = SelectModule.module.moduleLeader)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        )
        {
            Text(text = "Module Code : ")
            Spacer(modifier = Modifier.width(12.dp))

            Text(text = SelectModule.module.moduleCode)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .background(color = colorResource(id = R.color.soft_peach))
        )
        {
            Text(text = "Submission Dates : ")
            Spacer(modifier = Modifier.width(12.dp))

            Text(text = SelectModule.module.moduleSubmissionDate)
        }

    }
}

@Composable
fun ModuleSelection() {
    val module = getModuleData()
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.purple_200))
                .padding(vertical = 6.dp, horizontal = 16.dp),
            // Space between elements in the row
            verticalAlignment = Alignment.CenterVertically, // Align vertically to center
        ) {
            Image(painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "Back",
                modifier = Modifier
                    .clickable {
                        (context as Activity).finish()
                    }
                    .padding(start = 4.dp) // Optional spacing // Optional spacin
            )
            Spacer(modifier = Modifier.width(16.dp))


            Text(
                text = "Details List",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.purple_200)
            )
        }
    }
}

fun getModuleData(): List<ModuleData> {
    return listOf(
        ModuleData(
            moduleTitle = "Object-Oriented Development",

            moduleLeader = "Asher Rashid",
            moduleCode = "CIS4083-N",
            moduleSubmissionDate = "Staggerred across period from 11th October 2024 to 8th January 2025"
        ),
        ModuleData(
            moduleTitle = "Big Data and Business Intelligence",

            moduleLeader = "Dr Annalisa Occhipinti",
            moduleCode = "CIS4008-N",
            moduleSubmissionmethod = "On;ine(Blackboard)"
        ),
        ModuleData(
            moduleTitle = "Artificial Intelligence Foundations",

            moduleLeader = "Dr Alessandro Di Stefano",
            moduleCode = "CIS4049-N",
            assignmenttitle = "AI Solution",
            deadlinedate = "07/01/2025",
            deadlinetime = "5:00 pm",
        )

    )
}


@Preview(showBackground = true)
@Composable
fun SeePreview() {
    //  HDetails()
    //  TaskCard(name = "Object-Oriented Development", due = "Task 5", dueDate = "04/04/2024, 05:29", imageRes = R.drawable.list)
    UpcomingDetailsScreen()
}