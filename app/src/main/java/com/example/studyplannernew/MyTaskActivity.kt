package com.example.studyplannernew

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyplannernew.modalClass.TODOData
import com.example.studyplannernew.modalClass.TaskData

class MyTaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTaskActivityScreen()
        }
    }
}

@Composable
fun MyTaskActivityScreen() {
    val todoTask = TODOData.getStudentTasks()

    val context = LocalContext.current as Activity

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(id = R.color.crimson_red)
                )
                .padding(vertical = 6.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "TODO Task List",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 12.dp)
        ) {

            items(todoTask.size) { index ->
                ItemAddTask(todoTask[index])
                Spacer(modifier = Modifier.height(6.dp))
            }
        }

        Column(
            modifier = Modifier
                .clickable {
                    context.startActivity(Intent(context, AddTaskActivity::class.java))
                }
                .fillMaxWidth()
                .padding(vertical = 6.dp, horizontal = 16.dp)
                .background(
                    color = colorResource(id = R.color.crimson_red)
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Add Task",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = Color.White
            )
        }


    }
}

@Composable
fun ItemAddTask(taskData: TaskData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    )
    {
        Column()
        {
            Text(
                text = "Subject",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 6.dp, top = 12.dp)

            )

            Text(
                text = taskData.subject,
                color = Color.Black,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 6.dp, top = 4.dp)
            )

            Text(
                text = "Details",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 6.dp, top = 12.dp)

            )

            Text(
                text = taskData.description,
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 6.dp, top = 4.dp)
            )


            Row {

                Text(
                    text = "DeadLine :",
                    color = Color.Red,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 6.dp, top = 12.dp)

                )

                Text(
                    text = taskData.deadlineToComplete,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 6.dp, top = 12.dp)
                )
            }

            Spacer(modifier = Modifier.height(4.dp))


        }
    }

}

@Preview(showBackground = true)
@Composable
fun ItemAddTaskPreview() {
    MyTaskActivityScreen()
}