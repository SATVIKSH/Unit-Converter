package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.TextStyle


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainApp(Modifier.background(Color.Blue))
                }
            }
        }
    }


@Composable
fun MainApp(modifier: Modifier=Modifier) {
    var userInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
    Text(text = "UNIT CONVERTER",fontSize=35.sp,fontWeight= Bold)
        Spacer(Modifier.height(30.dp))
        
        OutlinedTextField(value =userInput , onValueChange = {userInput=it},placeholder={Text(text="ENTER INPUT VALUE")})
        Spacer(Modifier.height(30.dp))
        Text(text="CURRENCY CONVERTER", fontWeight = Bold)
      Row(horizontalArrangement =Arrangement.spacedBy(15.dp) ) {

          Button(onClick = { result = INRTOUSD(userInput) }) {
              Text(text = "INR TO USD")
          }
          Button(onClick = { result = USDTOINR(userInput) }) {
              Text(text = "USD TO INR")
          }
      }

        Spacer(Modifier.height(30.dp))
        Text(text="DISTANCE CONVERTER", fontWeight = Bold)
        Row(horizontalArrangement =Arrangement.spacedBy(15.dp) ) {

            Button(onClick = { result = Kmtom(userInput) }) {
                Text(text = "Km To m")
            }
            Button(onClick = { result = mtoKm(userInput) }) {
                Text(text = "USD TO INR")
            }
        }
        Spacer(Modifier.height(30.dp))
        Text(text="TEMPERATURE CONVERTER", fontWeight = Bold)
        Row(horizontalArrangement =Arrangement.spacedBy(15.dp) ) {

            Button(onClick = { result = CTOK(userInput) }) {
                Text(text = "Celcius to Kelvin")
            }
            Button(onClick = { result = KTOC(userInput) }) {
                Text(text = "Kelvin to Celcius")
            }
        }
        Spacer(Modifier.height(30.dp))
        Text(text = "RESULT \n $result",fontWeight= Bold,fontSize=20.sp)
    }
}
fun INRTOUSD(userInput:String):String {
    return (
        userInput.toFloat() * 0.012
            )   .toString()

}
fun USDTOINR(userInput: String):String{
    return(
            userInput.toFloat() * 82.42
            ).toString()
}
fun Kmtom(userInput:String):String {
    return (
            userInput.toFloat() * 1000
            )   .toString()

}
fun mtoKm(userInput: String):String{
    return(
            userInput.toFloat() * 0.001
            ).toString()
}
fun CTOK(userInput:String):String {
    return (
            userInput.toFloat() + 273
            )   .toString()

}
fun KTOC(userInput: String):String{
    return(
            userInput.toFloat() -273
            ).toString()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

        MainApp()

}