package com.example.studyplannernew

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AddTaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AddTask()
        }
    }
}

@Composable
fun AddTask() {
    var subjectName by remember { mutableStateOf("") }
    var details by remember { mutableStateOf("") }
    var deadLine by remember { mutableStateOf("") }

    val context = LocalContext.current as Activity

    Column(
        modifier = Modifier.fillMaxSize()
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
                        context.finish()
                    }
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Add Task",
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {


        Text(
            text = "Subject",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(start = 6.dp, top = 12.dp)
        )

        OutlinedTextField(
            value = subjectName,
            onValueChange = { subjectName = it },
            label = { Text("Enter Subject") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp)
        )

        Text(
            text = "Details",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(start = 6.dp, top = 12.dp)
        )

        OutlinedTextField(
            value = details,
            onValueChange = { details = it },
            label = { Text("Enter Details") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp)
        )

        Text(
            text = "DeadLine",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(start = 6.dp, top = 12.dp)
        )

        OutlinedTextField(
            value = deadLine,
            onValueChange = { deadLine = it },
            label = { Text("Enter DeadLine") },

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp)
        )

        Spacer(modifier = Modifier.height(84.dp))

        Button(
            onClick = {

            },
            modifier = Modifier
                .width(120.dp)
                .height(50.dp)
                .align(Alignment.CenterHorizontally),

            shape = RoundedCornerShape(
                topEnd = 16.dp, // Adjust radius as needed
                bottomEnd = 16.dp,
                topStart = 16.dp,
                bottomStart = 16.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.crimson_red), // Adjust color as needed
                contentColor = Color.White
            ),
        )
        {
            Text("Add Task")
        }

    }

    }

}

@Preview(showBackground = true)
@Composable
fun AddTaskPreview() {
    AddTask()
}