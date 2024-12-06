package com.example.studyplannernew

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyplannernew.ui.theme.StudyPlannerNewTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudyPlannerNewTheme {
                BrandDisplay()
            }
        }
    }

}

@Composable
fun BrandDisplay() {
    val context = LocalContext.current as Activity

    DisposableEffect(Unit) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
//            onLoginClick(if (UserDetails.getLoginStatus(context)) 1 else 2)
            context.startActivity(Intent(context, SignInActivity::class.java))
            context.finish()
        }
        onDispose { job.cancel() }
    }

    BrandDisplayScreen()
}

@Composable
fun BrandDisplayScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.crimson_red)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Welcome to",
                color = colorResource(id = R.color.soft_peach),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 18.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Mahesh Study Buddy",
                color = colorResource(id = R.color.soft_peach),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 18.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Image(
                painter = painterResource(id = R.drawable.icon_studyplan),
                contentDescription = "Mahesh Study Buddy",
            )

            Spacer(modifier = Modifier.weight(1f))


        }
    }

}


@Preview(showBackground = true)
@Composable
fun BrandDisplayScreenPreview() {
    BrandDisplayScreen()
}