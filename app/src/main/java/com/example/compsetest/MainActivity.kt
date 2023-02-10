package com.example.compsetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
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
                    Greeting(getString(R.string.happy_birthday_text),getString(R.string.signature_text))
                }
            }
        }
    }
}

@Composable
fun Greeting(message : String, form: String) {
    val image = painterResource(id = R.drawable.androidparty)

    Column {
        Surface(color = Color.Magenta) {
           Box {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
               Column {
                   Text(
                       text = "Hello $message!",
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(start = 16.dp, top = 16.dp)
                           .wrapContentWidth(Alignment.CenterHorizontally),
                       fontSize = 36.sp,
                   )
                   Text(
                       text = "$form",
                       modifier = Modifier
                           .padding(end = 16.dp, start = 16.dp)
                           .fillMaxWidth()
                           .wrapContentWidth(Alignment.CenterHorizontally),
                       fontSize = 16.sp
                   )
               }

            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    CompseTestTheme {
        Greeting("Android","-JIA")
    }
}