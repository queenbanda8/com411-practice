package com.example.finale

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.finale.ui.screens.HomeScreen
import com.example.finale.ui.screens.OutputScreen
import com.example.finale.ui.theme.FinaleTheme
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinaleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ){
                    AppNavigation()
                }

            }
        }
    }
}

@Composable
fun AppNavigation (){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_Screen"){

       composable ("home_screen"){
           HomeScreen(
               onNavigateToDisplay = {textToSend ->
                   val encodedText = URLEncoder.encode(textToSend, StandardCharsets.UTF_8.toString())
                   navController.navigate("home_screen/$encodedText")
               }
           )
       }

        composable(
            route = "home_screen/{textArg}",
            arguments = listOf(navArgument("textArg") {type = NavType.StringType})
        ){ backStackEntry ->
            val encodedText = backStackEntry.arguments?.getString("textArg") ?: ""
            val decodedText = URLDecoder.decode(encodedText, StandardCharsets.UTF_8.toString())

            OutputScreen(
                receivedText = decodedText,
                onBackClick = {navController.popBackStack()}
            )

        }
    }



}

