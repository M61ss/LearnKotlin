package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTutorialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeApp()
                }
            }
        }
    }
}

@Composable
fun ComposeApp() {
    HomePage(
        painter = painterResource(id = R.drawable.bg_compose_background),
        title = stringResource(id = R.string.jetpack_compose_tutorial),
        firstParagraph = stringResource(id = R.string.first_paragraph),
        secondParagraph = stringResource(id = R.string.second_paragraph)
    )
}

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    painter: Painter,
    title: String,
    firstParagraph: String,
    secondParagraph: String
) {
    Column(modifier = modifier) {
        Image(
            painter = painter,
            contentDescription = null
        )
        Text(
            text = title,
            modifier = modifier
                .padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = firstParagraph,
            modifier = modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                ),
            textAlign = TextAlign.Justify
        )
        Text(
            text = secondParagraph,
            modifier = modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorialTheme {
        ComposeApp()
    }
}