package com.example.petcat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.petcat.ui.theme.PetCatTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetCatTheme {
                PetCatApp()
            }
        }
    }
}

@Composable
fun PetCatApp() {

    var curr by remember { mutableStateOf(1) }
    var petCount by remember { mutableStateOf(0) }

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color(0xFFBB86FC)),
            color = MaterialTheme.colors.background
        ) {
            when (curr) {
                1 -> {
                    CatContainer(
                        textResId = R.string.tap_to_pet,
                        drawResId = R.drawable.cat_awake,
                        descriptionResId = R.string.awake_cat,
                        onImageClick = {
                            curr = 2
                            petCount = (2..5).random()
                        }
                    )
                }
                2 -> {
                    CatContainer(
                        textResId = R.string.tap_to_sleep,
                        drawResId = R.drawable.cat_touch,
                        descriptionResId = R.string.petting_cat,
                        onImageClick = {
                            petCount--
                            if (petCount == 0) {
                                curr = 3
                            }
                        }
                    )
                }

                3 -> {
                    CatContainer(
                        textResId = R.string.tap_awake,
                        drawResId = R.drawable.cat_asleep,
                        descriptionResId = R.string.asleep_cat,
                        onImageClick = {
                            curr = 1
                        }
                    )
                }
            }
        }
    }

@Composable
fun CatContainer(
    textResId: Int,
    drawResId: Int,
    descriptionResId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(Color(0xFF03DAC5))
            ) {
                Image(
                    painter = painterResource(drawResId),
                    contentDescription = stringResource(descriptionResId),
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.button_image_width))
                        .height(dimensionResource(R.dimen.button_image_height))
                        .padding(dimensionResource(R.dimen.button_interior_padding))
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))
            Text(
                text = stringResource(textResId),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PetCatTheme {
        PetCatApp()
    }
}