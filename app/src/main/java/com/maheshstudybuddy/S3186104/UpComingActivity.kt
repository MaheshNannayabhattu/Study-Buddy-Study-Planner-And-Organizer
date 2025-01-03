package com.maheshstudybuddy.S3186104

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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class UpComingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskListScreen()
        }

    }
}


@Composable
fun TaskCard(
    moduleData: ModuleData
) {
    val context = LocalContext.current as Activity
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                SelectModule.module = moduleData
                val intent = Intent(context, UpcomingDetailsActivity::class.java)
                context.startActivity(intent)
            }
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(80.dp)
            ) {
                Image(
                    painter = painterResource(id = moduleData.imageRes),
                    contentDescription = "Task Image",
                    modifier = Modifier
                        .size(60.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = moduleData.title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {

                Text(
                    text = moduleData.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(4.dp))


                Text(
                    text = moduleData.due,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                )

                Spacer(modifier = Modifier.height(4.dp))


                Text(
                    text = moduleData.dueDate,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                )
            }
        }
    }
}


@Composable
fun TaskListScreen() {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
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
                text = "Activities",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = Color.White,

                )

        }

        val module1 = ModuleData()
        module1.moduleTitle = "Object-Oriented Development"
        module1.moduleLeader = "Asher Rashid"
        module1.moduleCode = "CIS4083-N"
        module1.moduleSubmissionDate =
            "Staggerred across period from 11th October 2024 to 8th January 2025"
        module1.name = "Object-Oriented Development"
        module1.due = "Task 5"
        module1.title = "29 Nov 2024"
        module1.dueDate = "14/12/2024, 05:29"
        module1.imageRes = R.drawable.list

        TaskCard(module1)

        val module2 = ModuleData()
        module2.moduleTitle = "Big Data and Business Intelligence"
        module2.moduleLeader = "Dr Annalisa Occhipinti"
        module2.moduleCode = "CIS4008-N"
        module2.moduleSubmissionmethod = "Online(Blackboard)"
        module2.name = "Big Data and Business Intelligence"
        module2.due = "Task 5"
        module2.title = "16 Sep 2024"
        module2.dueDate = "07/01/2025, 21:30"
        module2.assignmenttitle = "Business Intelligence Solution and Report"
        module2.deadlinedate = "07/01/2025"
        module2.imageRes = R.drawable.list

        TaskCard(module2)
        val module3 = ModuleData()
        module3.moduleTitle = "Artificial Intelligence Foundations"
        module3.moduleLeader = "Dr Alessandro Di Stefano"
        module3.moduleCode = "CIS4049-N"
        module3.assignmenttitle = "AI Solution"
        module3.deadlinedate = "07/01/2025"
        module3.deadlinetime = "5:00pm"
        module3.name = "Artificial Intelligence Foundations"
        module3.due = "Task 5"
        module3.title = "22 Sep 2024"
        module3.dueDate = "08/01/2025, 05:29"
        module3.imageRes = R.drawable.list
        TaskCard(module3)

    }
}


@Preview(showBackground = true)
@Composable
fun TaskListScreenPreview() {
    TaskListScreen()
}