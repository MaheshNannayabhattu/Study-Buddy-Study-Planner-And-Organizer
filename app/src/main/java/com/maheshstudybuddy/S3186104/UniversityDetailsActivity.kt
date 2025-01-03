package com.maheshstudybuddy.S3186104

import android.os.Bundle
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class UniversityDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

@Composable
fun UniversityDetails(){

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .padding(vertical = 6.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "Back Arrow",
                modifier = Modifier
                    .width(36.dp)
                    .height(36.dp)
                    .clickable {}
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Places Details",
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
        }
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(id = R.drawable.icon_studyplan),
            contentDescription = "Image",
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = "University Name",
            color = Color.Black,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 12.dp, top = 8.dp)

        )

        Text(
            text = "Description",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 12.dp, top = 8.dp)
        )

        Text(
            text = "Description",
            color = Color.Black,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 12.dp, top = 4.dp)
        )

        Text(
            text = "Admissions Opening Date",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 12.dp, top = 8.dp)
        )
        Text(
            text = "12-05-2025",
            color = Color.Black,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 12.dp, top = 4.dp)
        )

    }

}

@Preview(showBackground = true)
@Composable
fun UniversityDetailsPreview() {
    UniversityDetails()
}