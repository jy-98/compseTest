package com.example.compsetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compsetest.ui.theme.CompseTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompseTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
//                    Greeting(getString(R.string.happy_birthday_text),getString(R.string.signature_text))
//                    Greeting()
                    Nice()
                }
            }
        }
    }
}

@Composable
fun Nice() {
    val niceImage = painterResource(id = R.drawable.ic_task_completed)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(painter = niceImage, contentDescription = null)
        Text(
            text = "All tasks completed",
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = Bold
        )
        Text(text = "Nice work!", fontSize = 16.sp)


    }
}

@Composable
fun MyText(
    message: String,
    fontSize: TextUnit,
    all: Dp = 0.dp,
    start: Dp = 0.dp,
    top: Dp = 0.dp,
    end: Dp = 0.dp,
    bottom: Dp = 0.dp,
    Justify: Boolean
) {

    Text(
        text = message,
        modifier =
        if (all.value > 0) {
            Modifier
                .fillMaxWidth()
                .padding(all)
                .wrapContentWidth(Alignment.CenterHorizontally)
        } else {
            Modifier
                .fillMaxWidth()
                .padding(start, top, end, bottom)
                .wrapContentWidth(Alignment.CenterHorizontally)
        },

        fontSize = fontSize,
        textAlign = if (Justify) TextAlign.Justify else TextAlign.Start

    )
}

@Composable
fun Greeting() {
    val image = painterResource(id = R.drawable.post_2)

    Surface(color = Color.White) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            MyText(
                "jetpack Compose tutorial",
                fontSize = 14.sp,
                all = 16.dp,
                Justify = false
            )
            MyText(
                "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
                fontSize = 14.sp,
                start = 16.dp,
                end = 16.dp,
                Justify = false
            )
            MyText(
                "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
                fontSize = 14.sp,
                all = 16.dp,
                Justify = true
            )


        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    CompseTestTheme {
        Greeting()
    }
}