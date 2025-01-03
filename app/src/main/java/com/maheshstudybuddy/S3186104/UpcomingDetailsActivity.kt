package com.maheshstudybuddy.S3186104

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

class UpcomingDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UpcomingDetailsScreen()
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
                        context.finish()
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


@Preview(showBackground = true)
@Composable
fun UpcomingDetailsScreenPreview() {
    UpcomingDetailsScreen()
}