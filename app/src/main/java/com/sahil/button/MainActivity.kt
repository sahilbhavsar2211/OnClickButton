package com.sahil.button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sahil.button.ui.theme.ButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonTheme {
                Greeting()
            }
        }
    }
}
@Composable
fun Greeting() {
    var expandedWidth by remember { mutableStateOf(50.dp)}
    var expandedHeight by remember { mutableStateOf(50.dp)}

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally,
    ) {
        Button(onClick = {
            if ((expandedWidth <= screenWidth) || (expandedHeight <= screenHeight)){
                expandedWidth += 50.dp
                expandedHeight += 50.dp
            }else{
                expandedWidth = 100.dp
                expandedHeight = 100.dp
            }
                         },
            modifier= Modifier
                .height(expandedHeight)
                .width(expandedWidth)
        )
        {
            Text(text = "Button")
        }
        Text("{$expandedWidth $expandedHeight}")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ButtonTheme {
        Greeting()
    }
}