package com.example.composedapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedapp.ui.theme.ComposedAppTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposedAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingImage(getString(R.string.happy_birthday_text), getString(R.string.signature_text))
                }
            }
        }
    }

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.Center,) {
        Text(
            text = message,
            fontStyle = FontStyle.Italic,
            fontSize = 100.sp,
            lineHeight = 102.sp,
            color = Color.Blue,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

    @Composable
    fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
        val image = painterResource(R.drawable.androidparty)
        Box {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = 0.5F
            )
            GreetingText(
                message = message,
                from = from,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            )
        }
    }



    @Preview(showBackground = true)
    @Composable
    fun BirthdayCardPreview() {
        ComposedAppTheme {
            GreetingImage(message = "Happy Birthday Brink!", from = "From Tigre")
        }
    }
}