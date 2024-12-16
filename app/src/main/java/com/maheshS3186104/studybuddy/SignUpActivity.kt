package com.maheshS3186104.studybuddy

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
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
import com.maheshS3186104.studybuddy.ui.theme.StudyPlannerNewTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudyPlannerNewTheme {
                RegisterScreen()
            }
        }
    }
}

@Composable
fun RegisterScreen() {
    var name by remember { mutableStateOf("") }
    var useremail by remember { mutableStateOf("") }
    var userpassword by remember { mutableStateOf("") }
    var confirmuserpassword by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }


    val context = LocalContext.current as Activity

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(1f))

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        Button(
            onClick = {
                context.startActivity(Intent(context, SignInActivity::class.java))
                context.finish()


            },
            modifier = Modifier
                .width(120.dp)
                .height(50.dp)
                .align(Alignment.End),
            shape = RoundedCornerShape(
                topStart = 16.dp, // Adjust radius as needed
                bottomStart = 16.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFB0BEC5), // Adjust color as needed
                contentColor = Color.Black
            )
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.weight(0.5f))


        // Login title
        Text(
            text = "Register",
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
                    .wrapContentHeight()

            )
            {

                // User Name TextField
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Enter FullName") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.AccountCircle, // Replace with desired icon
                            contentDescription = "Email Icon"
                        )
                    },
                    modifier = Modifier
                        .width(250.dp)
                        .padding(vertical = 0.dp)
                )

                Spacer(modifier = Modifier.height(6.dp))

                OutlinedTextField(
                    value = useremail,
                    onValueChange = { useremail = it },
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

                Spacer(modifier = Modifier.height(6.dp))

                OutlinedTextField(
                    value = userpassword,
                    onValueChange = { userpassword = it },
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

                Spacer(modifier = Modifier.height(6.dp))


                OutlinedTextField(
                    value = confirmuserpassword,
                    onValueChange = { confirmuserpassword = it },
                    label = { Text("Confirm Password") },
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
                painter = painterResource(id = R.drawable.baseline_arrow_circle_right_36),
                contentDescription = "Mahesh Study Buddy",
                modifier = Modifier.clickable {
                    when {
                        name.isBlank() -> {
                            errorMessage = "Please enter your full name."
                        }

                        useremail.isBlank() -> {
                            errorMessage = "Please enter your email."
                        }

                        userpassword.isBlank() -> {
                            errorMessage = "Please enter your password."
                        }

                        confirmuserpassword.isBlank() -> {
                            errorMessage = "Please confirm your password."
                        }

                        userpassword != confirmuserpassword -> {
                            errorMessage = "Passwords do not match"

                        }

                        else -> {
                            errorMessage = ""
                            val userData = StudyPlannerUserData(
                                fullName = name,
                                email = useremail,
                                password = userpassword,


                                )
                            saveStudyPlannerUserData(userData, context)
                        }
                    }

                }
            )

            Spacer(modifier = Modifier.weight(1f))

        }


        Spacer(modifier = Modifier.weight(1f))

    }
}

private fun saveStudyPlannerUserData(userData: StudyPlannerUserData, context: Activity) {
    val db = FirebaseDatabase.getInstance()
    val ref = db.getReference("Users")

    ref.child(userData.email.replace(".", ",")).setValue(userData)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(context, "Registration Successful", Toast.LENGTH_SHORT).show()
                takeToLogin(context)
            } else {
                Toast.makeText(
                    context,
                    "User Registration Failed: ${task.exception?.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        .addOnFailureListener { exception ->
            Toast.makeText(
                context,
                "User Registration Failed: ${exception.message}",
                Toast.LENGTH_SHORT
            ).show()
        }
}

fun takeToLogin(context: Activity) {
    context.startActivity(Intent(context, SignInActivity::class.java))
    context.finish()
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}