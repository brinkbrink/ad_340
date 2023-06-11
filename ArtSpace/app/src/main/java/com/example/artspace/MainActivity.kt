package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                    ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {

    var curr by remember { mutableStateOf(1) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (curr) {
            1 -> {
                ArtSpaceLayout(
                    textResId = R.string.apple2,
                    drawResId = R.drawable.apple2,
                    descriptionResId = R.string.apple2,
                    onNextButtonClick = { curr = 2 },
                    onPrevButtonClick = { curr = 1 },
                )
            }
            2 -> {
                ArtSpaceLayout(
                    textResId = R.string.apple3,
                    drawResId = R.drawable.apple3,
                    descriptionResId = R.string.apple3,
                    onNextButtonClick = { curr = 3 },
                    onPrevButtonClick = { curr = 1 },
                )
            }
            3 -> {
                ArtSpaceLayout(
                    textResId = R.string.apple4,
                    drawResId = R.drawable.apple4,
                    descriptionResId = R.string.apple4,
                    onNextButtonClick = { curr = 4 },
                    onPrevButtonClick = { curr = 2 },
                )
            }
            4 -> {
                ArtSpaceLayout(
                    textResId = R.string.apple5,
                    drawResId = R.drawable.apple5,
                    descriptionResId = R.string.apple5,
                    onNextButtonClick = { curr = 5 },
                    onPrevButtonClick = { curr = 3 },
                )
            }
            5 -> {
                ArtSpaceLayout(
                    textResId = R.string.apple6,
                    drawResId = R.drawable.apple6,
                    descriptionResId = R.string.apple6,
                    onNextButtonClick = { curr = 6 },
                    onPrevButtonClick = { curr = 4 },
                )
            }
            6 -> {
                ArtSpaceLayout(
                    textResId = R.string.apple7,
                    drawResId = R.drawable.apple7,
                    descriptionResId = R.string.apple7,
                    onNextButtonClick = { curr = 7 },
                    onPrevButtonClick = { curr = 5 },
                )
            }
            7 -> {
                ArtSpaceLayout(
                    textResId = R.string.apple8,
                    drawResId = R.drawable.apple8,
                    descriptionResId = R.string.apple8,
                    onNextButtonClick = { curr = 8 },
                    onPrevButtonClick = { curr = 6 },
                )
            }
            8 -> {
                ArtSpaceLayout(
                    textResId = R.string.apple9,
                    drawResId = R.drawable.apple9,
                    descriptionResId = R.string.apple9,
                    onNextButtonClick = { curr = 1 },
                    onPrevButtonClick = { curr = 7 },
                )
            }
        }
    }
}


    @Composable
    fun ArtSpaceLayout(
                    textResId: Int,
                    drawResId: Int,
                    descriptionResId: Int,
                    onNextButtonClick: () -> Unit,
                    onPrevButtonClick: () -> Unit,
                    modifier: Modifier = Modifier
    ) {
    Column(
        modifier = Modifier
            .padding(40.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = stringResource(R.string.title),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
        Image(
            painter = painterResource(drawResId),
            contentDescription = stringResource(descriptionResId),
            modifier = Modifier
                .width(dimensionResource(R.dimen.image_width))
                .height(dimensionResource(R.dimen.image_height))
        )
        Text(
            text = stringResource(textResId),
            fontSize = 24.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_text))
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))
        Row(
            modifier = Modifier
        ){
            Button(
                onClick = onPrevButtonClick,
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(Color(0xFF6e0315)),
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.button_interior_padding))
            )
            {Text(text = "Prev")}
            Button(
                onClick = onNextButtonClick,
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(Color(0xFF6e0315)),
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.button_interior_padding))
            )
            {Text(text = "Next")}
        }

    }

}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}