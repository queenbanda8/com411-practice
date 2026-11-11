package com.example.finale.ui.screens

import android.view.Display
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finale.ui.theme.*
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.finale.R
import androidx.compose.runtime.*


@Composable
fun HomeScreen(
    onNavigateToDisplay: (String) -> Unit
){
    var textValue by remember { mutableStateOf("") }
    val isButtonEnabled = textValue.isNotBlank()
    val scroll = rememberScrollState()
    val scroll2 = rememberScrollState()
Column (
    modifier = Modifier
        .fillMaxSize()
        .background(color = GhostWhite)

){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(50.dp)
            .background(color = DimGray)

    ){

    }

    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth()
            .size(60.dp)
            .background(color = DuskBlue)
            .padding(horizontal = 6.dp)
    ){
        Text(
            text = "UniEventManager",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
    }

  Column(

      modifier = Modifier
          .fillMaxWidth()
          .padding( horizontal = 6.dp, vertical = 4.dp)
          .verticalScroll(scroll2)

  ){
        Text(
            text = "Popular Events",
            color = Color.Black,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

      Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp )
                .horizontalScroll(scroll)
      ){

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .size(280.dp, 280.dp)
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(16.dp))
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Lavender)


            ){
                Image(
                    painter = painterResource(id = R.drawable.image_1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()

                    )
                Text(
                    text = "16 July 2026",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                )
                Text(
                    text = "Project Presentation",
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }

            Column(
                modifier = Modifier
                    .size(280.dp, 280.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Lavender)
            ){
                Image(
                    painter = painterResource(id = R.drawable.image_2),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()

                )

                Text(
                    text = "18 July 2026",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                )
                Text(
                    text = "Tech Work shop",
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                )

            }

      }

  }
Column(
    modifier = Modifier
        .padding(horizontal = 6.dp, vertical = 12.dp)

){
    Text(
        text = "Past Events",
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        modifier = Modifier
            .padding(vertical = 10.dp)

    )

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .height(280.dp)
            .background(color = Lavender)


    ){
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
            )

        Text(
            text = "12 March 2026",
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(horizontal = 12.dp,  vertical = 6.dp)
        )

        Text(
            text = "Educational Trip",
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 6.dp)

        )
    }
}
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(bottom = 12.dp)
            .weight(1f)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .shadow(elevation = 2.dp, shape = RectangleShape)
                .background(color = GhostWhite)
                .padding(4.dp)
        ){

            OutlinedTextField(
                value = textValue,
                onValueChange = { textValue = it},
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp),
                singleLine = true
            )

            Button(
                onClick =  {
                    if (isButtonEnabled){
                        onNavigateToDisplay(textValue)
                    }
                },
                enabled = isButtonEnabled,

                ) {
                Text(
                    "Add"
                )
            }
        }

    }
    


}

}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(
        onNavigateToDisplay = {
            text ->
        }
    )
}

//@Composable
//fun HomeScreen(
//    onNavigateToDisplay: (String) -> Unit
//) {
//    var textValue by remember { mutableStateOf("") }
//    val isButtonEnabled = textValue.isNotBlank()
//    val horizontalScroll = rememberScrollState()
//    val verticalScroll = rememberScrollState()
//
//    // Root: NOT scrollable
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(GhostWhite)
//    ) {
//
//        // ---------- Scrollable area ----------
//        Column(
//            modifier = Modifier
//                .weight(1f)                 // takes all space above the bar
//                .verticalScroll(verticalScroll)
//        ) {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(50.dp)
//                    .background(DimGray)
//            )
//
//            Box(
//                contentAlignment = Alignment.CenterStart,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(60.dp)
//                    .background(DuskBlue)
//                    .padding(horizontal = 6.dp)
//            ) {
//                Text(
//                    text = "UniEventManager",
//                    color = Color.White,
//                    fontSize = 25.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 6.dp, vertical = 4.dp)
//            ) {
//                Text(
//                    text = "Popular Events",
//                    color = Color.Black,
//                    fontSize = 25.sp,
//                    fontWeight = FontWeight.Bold
//                )
//
//                Row(
//                    horizontalArrangement = Arrangement.spacedBy(16.dp),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 6.dp)
//                        .horizontalScroll(horizontalScroll)
//                ) {
//                    Column(
//                        horizontalAlignment = Alignment.Start,
//                        modifier = Modifier
//                            .size(280.dp, 280.dp)
//                            .shadow(5.dp, RoundedCornerShape(16.dp))
//                            .clip(RoundedCornerShape(16.dp))
//                            .background(Lavender)
//                    ) {
//                        Image(
//                            painter = painterResource(id = R.drawable.image_1),
//                            contentDescription = null,
//                            contentScale = ContentScale.Crop,
//                            modifier = Modifier.height(200.dp).fillMaxWidth()
//                        )
//                        Text(
//                            text = "16 July 2026",
//                            fontWeight = FontWeight.SemiBold,
//                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
//                        )
//                        Text(
//                            text = "Project Presentation",
//                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
//                        )
//                    }
//
//                    Column(
//                        modifier = Modifier
//                            .size(280.dp, 280.dp)
//                            .clip(RoundedCornerShape(16.dp))
//                            .background(Lavender)
//                    ) {
//                        Image(
//                            painter = painterResource(id = R.drawable.image_2),
//                            contentDescription = null,
//                            contentScale = ContentScale.Crop,
//                            modifier = Modifier.height(200.dp).fillMaxWidth()
//                        )
//                        Text(
//                            text = "18 July 2026",
//                            fontWeight = FontWeight.SemiBold,
//                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
//                        )
//                        Text(
//                            text = "Tech Work shop",
//                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
//                        )
//                    }
//                }
//            }
//
//            Column(
//                modifier = Modifier.padding(horizontal = 6.dp, vertical = 12.dp)
//            ) {
//                Text(
//                    text = "Past Events",
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 25.sp,
//                    modifier = Modifier.padding(vertical = 10.dp)
//                )
//
//                Column(
//                    horizontalAlignment = Alignment.Start,
//                    modifier = Modifier
//                        .shadow(2.dp, RoundedCornerShape(16.dp))
//                        .fillMaxWidth()
//                        .height(280.dp)
//                        .background(Lavender)
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.image_1),
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier.height(200.dp).fillMaxWidth()
//                    )
//                    Text(
//                        text = "12 March 2026",
//                        fontWeight = FontWeight.SemiBold,
//                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
//                    )
//                    Text(
//                        text = "Educational Trip",
//                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
//                    )
//                }
//            }
//        }
//
//        // ---------- Fixed bottom bar (outside the scroll) ----------
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            modifier = Modifier
//                .fillMaxWidth()
//                .shadow(2.dp, RectangleShape)
//                .background(GhostWhite)
//                .navigationBarsPadding()   // keeps it above the system nav bar
//                .imePadding()              // lifts it above the keyboard
//                .padding(8.dp)
//        ) {
//            OutlinedTextField(
//                value = textValue,
//                onValueChange = { textValue = it },
//                modifier = Modifier.weight(1f),
//                shape = RoundedCornerShape(16.dp),
//                singleLine = true
//            )
//
//            Button(
//                onClick = { if (isButtonEnabled) onNavigateToDisplay(textValue) },
//                enabled = isButtonEnabled
//            ) {
//                Text("Add")
//            }
//        }
//    }
//}