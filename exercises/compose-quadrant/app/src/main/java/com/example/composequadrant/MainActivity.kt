package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
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
    Quadrant(
        title1 = stringResource(R.string.text_composable),
        title2 = stringResource(R.string.image_composable),
        title3 = stringResource(R.string.row_composable),
        title4 = stringResource(R.string.column_composable),
        text1 = stringResource(R.string.text1),
        text2 = stringResource(R.string.text2),
        text3 = stringResource(R.string.text3),
        text4 = stringResource(R.string.text4)
    )
}

@Composable
private fun Quadrant(
    modifier: Modifier = Modifier,
    title1: String,
    title2: String,
    title3: String,
    title4: String,
    text1: String,
    text2: String,
    text3: String,
    text4: String
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(modifier = modifier.weight(50f)) {
            Block(
                title = title1,
                body = text1,
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(50f)
            )
            Block(
                title = title2,
                body = text2,
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(50f)
            )
        }
        Row(modifier = modifier.weight(50f)) {
            Block(
                title = title3,
                body = text3,
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(50f)
            )
            Block(
                title = title4,
                body = text4,
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(50f)
            )
        }
    }
}

@Composable
fun Block(
    modifier: Modifier = Modifier, 
    title: String, 
    body: String, 
    backgroundColor: Color
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        Title(title = title)
        Body(body = body)
    }
}

@Composable
fun Title(modifier: Modifier = Modifier, title: String) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun Body(modifier: Modifier = Modifier, body: String) {
    Text(
        text = body,
        textAlign = TextAlign.Justify
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        ComposeApp()
    }
}