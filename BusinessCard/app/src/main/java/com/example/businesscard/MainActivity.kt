package com.example.businesscard

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
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CardImage(getString(R.string.full_name), getString(R.string.title), getString(R.string.phone), getString(R.string.email), getString(R.string.github))
                }
            }
        }
    }


@Composable
fun CardText(name: String, title: String, phone: String, email: String, gh: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column(modifier = modifier.padding(12.dp),
        verticalArrangement = Arrangement.Center,) {
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            text = name,
            fontSize = 70.sp,
            lineHeight = 100.sp,
            color = Color(0xFF025a66),
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(0.dp, 16.dp)
        )
        Text(
            text = title,
            color = Color(0xFF2d2d2d),
            fontStyle = FontStyle.Italic,
            fontSize = 32.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Image(
            painter = image,
            contentDescription = "android logo",
            alpha = 0.8F,
            modifier = Modifier
                .size(120.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(138.dp))
        Column(modifier = modifier.padding(0.dp),
            verticalArrangement = Arrangement.Center,) {
            Text(
                text = phone,
                fontSize = 26.sp,
                color = Color(0xFF2d2d2d),
                modifier = Modifier
                    .absolutePadding(8.dp, 4.dp, 8.dp, 4.dp)
                    .align(alignment = Alignment.End)
            )
            Text(
                text = email,
                fontSize = 26.sp,
                color = Color(0xFF2d2d2d),
                modifier = Modifier
                    .absolutePadding(8.dp, 4.dp, 8.dp, 4.dp)
                    .align(alignment = Alignment.End)
            )
            Text(
                text = gh,
                fontSize = 26.sp,
                color = Color(0xFF2d2d2d),
                modifier = Modifier
                    .absolutePadding(8.dp, 4.dp, 8.dp, 4.dp)
                    .align(alignment = Alignment.End)
            )
        }
    }
}

@Composable
fun CardImage(name: String, title: String, phone: String, email: String, gh: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.trees)
    Box {
        Image(
            painter = image,
            contentDescription = "evergreen trees in fog",
            contentScale = ContentScale.Crop,
            alpha = 0.6F
        )
        CardText(
            name = name,
            title = title,
            phone = phone,
            email = email,
            gh = gh,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    BusinessCardTheme {
        CardImage(getString(R.string.full_name), getString(R.string.title), getString(R.string.phone), getString(R.string.email), getString(R.string.github))
    }
}
}