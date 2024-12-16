package com.maheshS3186104.studybuddy

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.database.FirebaseDatabase
import com.maheshS3186104.studybuddy.modalClass.StudyPlannerUserData


class SignInActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudyPlannerLoginScreen()
        }
    }

}


@Composable
fun StudyPlannerLoginScreen() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current as Activity

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(1f))
        // Login title
        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(bottom = 12.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.weight(0.2f))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(12.dp))
            // Column with Text Fields
            Column(
                modifier = Modifier
                    .width(300.dp)
                    .background(Color.White)
            )
            {

                // User Name TextField
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Enter Email") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email, // Replace with desired icon
                            contentDescription = "Email Icon"
                        )
                    },
                    modifier = Modifier
                        .width(250.dp)
                        .padding(vertical = 0.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Enter Password") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock, // Replace with desired icon
                            contentDescription = "Email Icon"
                        )
                    },
                    modifier = Modifier
                        .width(250.dp)
                        .padding(vertical = 0.dp)
                )


            }

            Spacer(modifier = Modifier.weight(1f))

            Image(
                modifier = Modifier.clickable {

                    when {
                        email.isEmpty() -> {
                            Toast.makeText(context, " Please Enter Email", Toast.LENGTH_SHORT)
                                .show()
                        }

                        password.isEmpty() -> {
                            Toast.makeText(context, " Please Enter Password", Toast.LENGTH_SHORT)
                                .show()
                        }

                        else -> {

                            val db = FirebaseDatabase.getInstance()
                            val sanitizedUid = email.replace(".", ",")
                            val ref = db.getReference("Users").child(sanitizedUid)

                            ref.get().addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val userData = task.result?.getValue(StudyPlannerUserData::class.java)
                                    if (userData != null) {
                                        if (userData.password == password) {
                                            Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                                            StudyPlannerUserDetails.saveStudyPlannerUserLoginStatus(context, true)
                                            StudyPlannerUserDetails.saveEmail(context, email)
                                            takeToHome(context)

                                        } else {
                                            Toast.makeText(context, "Invalid Password", Toast.LENGTH_SHORT).show()
                                        }
                                    } else {
                                        Toast.makeText(context, "No user data found", Toast.LENGTH_SHORT).show()
                                    }
                                } else {
                                    // Data retrieval failed
                                    Toast.makeText(
                                        context,
                                        "Failed to retrieve user data: ${task.exception?.message}",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }


                    }


                },
                painter = painterResource(id = R.drawable.baseline_arrow_circle_right_36),
                contentDescription = "Mahesh Study Buddy",
            )

            Spacer(modifier = Modifier.weight(1f))

        }
        Spacer(modifier = Modifier.height(64.dp))

        Button(
            onClick = {
                context.startActivity(Intent(context, SignUpActivity::class.java))
                context.finish()

            },
            modifier = Modifier
                .width(120.dp)
                .height(50.dp),
            shape = RoundedCornerShape(
                topEnd = 16.dp, // Adjust radius as needed
                bottomEnd = 16.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFB0BEC5), // Adjust color as needed
                contentColor = Color.Black
            )
        ) {
            Text("Register")
        }

        Spacer(modifier = Modifier.weight(1f))

    }


}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    StudyPlannerLoginScreen()
}


fun takeToHome(context: Activity)
{
    context.startActivity(Intent(context, StudentHomeActivity::class.java))
    context.finish()
}