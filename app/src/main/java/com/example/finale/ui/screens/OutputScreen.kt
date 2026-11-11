package com.example.finale.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finale.ui.theme.DimGray
import com.example.finale.ui.theme.DuskBlue
import com.example.finale.ui.theme.GhostWhite
import androidx.compose.ui.graphics.*

@Composable
fun OutputScreen(
    receivedText: String,
    onBackClick: () -> Unit
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = GhostWhite)

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(50.dp)
                .background(color = DimGray)

        ) {


        }

        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .fillMaxWidth()
                .size(60.dp)
                .background(color = DuskBlue)
                .padding(horizontal = 6.dp)
        ){
            Button(onClick = onBackClick){
                Text(
                    text = "Go back",
                    color = Color.White
                )
            }
        }

        Text(
            text = receivedText,
            style = MaterialTheme.typography.headlineMedium

        )
    }

}

@Preview
@Composable
fun OutputScreenPreview(){
    OutputScreen(
        receivedText = "You Asked ?",
        onBackClick = {}
    )
}