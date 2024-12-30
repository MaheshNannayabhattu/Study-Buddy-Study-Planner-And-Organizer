package com.maheshS3186104.studybuddy

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class ModulesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyCardLayout()
        }
    }
}


@Composable
fun MyCardLayout() {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

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
                text = "Modules",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = Color.White,

                )

        }


        val module1 = ModuleData(
            imageRes = R.drawable.ic_m1,
            moduleTitle = "Artificial Intelligence Foundations",
            data = "You learn specialist skills in artificial intelligence, opening the door to a range of careers. You develop strong theoretical and technical knowledge and skills including a thorough grounding in data analytics and specialist skills in artificial intelligence, which will provide the directly transferable skills for a career in the field of AI.\n" +
                    "You explore state-of-the-art technologies, concepts and theories, supported by a thriving active research community. You develop specialist knowledge and experience in the development of intelligent systems.\n" +
                    "\n" +
                    "Topics include machine learning, AI Programming, research and statistical methods and data analytics. The distinctive nature of the award is the close integration with our AI and Machine Learning research groups coupled with the opportunity for an internship."
        )
        val module2 = ModuleData(
            imageRes = R.drawable.ic_m2,
            moduleTitle = "Big Data and Business Intelligence",
            data = "You develop your ability to design and implement database, big data and analytics applications to meet business needs. A case study is used to follow the system development lifecycle. You develop a plausible application from inception to implementation for a real-world scenario.\n" +
                    "\n" +
                    "You investigate the issues and technologies associated with implementing and supporting large scale databases and the services that are needed to maintain and access a repository of data. Investigations are undertaken in a number of areas including big data, data warehouses, integrating legacy data, data management and approaches that support the modelling and visualisation of data for a range of use views."
        )
        val module3 = ModuleData(
            imageRes = R.drawable.ic_m3,
            moduleTitle = "Object-Oriented Development",
            data = "The school has a proven record of successful research, consultancy and enterprise projects in the field of computer science, giving our staff the relevant real-world case studies to draw upon in their teaching. Having worked in the sector, many of our academic staff have forged strong working relationships with colleagues in industry.\n" +
                    "The programming strand gives you the expertise and transferable skills in event-driven programming, patterns, design, development and deployment using industry-standard tools. The AI strand investigates computer models, simulations and techniques for observing and predicting behaviours in large-scale systems. The project management module underpins the practical and theoretical skills with techniques for strategic management of projects so that you are prepared for the full project life cycle. The individual computer science project and Advanced Practice (Internship) module provides you with the opportunity to apply both your practical and theoretical skills in your chosen specialism and to gain real-world experience in industry or research. There are three routes you can choose from to gain an MSc Computer Science"
        )
        val module4 = ModuleData(
            imageRes = R.drawable.ic_m4,
            moduleTitle = "Data Visualisation",
            data = "This innovative data science course equips you with the specialist skills and knowledge to make an immediate and meaningful contribution to a range of industry environments.\n" +
                    "\n" +
                    "You are taught by expert staff from our machine intelligence research group, ensuring that you have access to the very latest thinking from the field of data science. You have the opportunity to contribute to live research and to progress from postgraduate study to post doctorate research.\n" +
                    "\n" +
                    "The School has a proven record of successful research, consultancy and enterprise projects with industry in the field of data science, which means that staff have relevant real-world case studies to draw upon for teaching materials.\n" +
                    "\n" +
                    "There are three routes you can choose from to gain an MSc Data Science:\n" +
                    "\n" +
                    "full-time - 2 years with advanced practice (September and January start)\n" +
                    "full-time - 1 year (September start) or 16 months (January start)\n" +
                    "part-time - 2 years."
        )


        // Create each card explicitly
        MyImageCard(moduleData = module1)
        MyImageCard(moduleData = module2)
        MyImageCard(moduleData = module3)
        MyImageCard(moduleData = module4)
    }
}


@Composable
fun MyImageCard(moduleData: ModuleData) {
    val context = LocalContext.current as Activity
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 12.dp)
            .clickable {
                SelectModule.module = moduleData
                val intent = Intent(context, ModulesActivity2::class.java)
                context.startActivity(intent)
            }
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.primaryContainer),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = moduleData.imageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}


