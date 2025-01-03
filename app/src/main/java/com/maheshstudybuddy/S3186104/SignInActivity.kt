package com.maheshstudybuddy.S3186104

import android.app.Activity
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
import com.maheshstudybuddy.S3186104.modalClass.StudyPlannerUserData


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
            Column(
                modifier = Modifier
                    .width(300.dp)
                    .background(Color.White)
            )
            {

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Enter Email") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
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
                            imageVector = Icons.Default.Lock,
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

                            val firebaseDatabase = FirebaseDatabase.getInstance()
                            val databaseReference = firebaseDatabase.getReference("Users")
                                .child(email.replace(".", ","))

                            databaseReference.get().addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val userData =
                                        task.result?.getValue(StudyPlannerUserData::class.java)
                                    if (userData != null) {
                                        if (userData.password == password) {
                                            Toast.makeText(
                                                context,
                                                "Login successful",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                            StudyPlannerUserDetails.saveStudyPlannerUserLoginStatus(
                                                context,
                                                true
                                            )
                                            StudyPlannerUserDetails.saveStudentEmail(context, email)
                                            takeToHome(context)

                                        } else {
                                            Toast.makeText(
                                                context,
                                                "Invalid Password",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    } else {
                                        Toast.makeText(
                                            context,
                                            "No user data found",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                } else {
                                    Toast.makeText(
                                        context,
                                        "Something went wrong",
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
                topEnd = 16.dp,
                bottomEnd = 16.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFB0BEC5),
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


fun takeToHome(context: Activity) {
    context.startActivity(Intent(context, StudentHomeActivity::class.java))
    context.finish()
}