package com.example.isrcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.isrcalculator.ui.theme.ISRCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            Vista(titulo = "ISR Calculator")
        }
    }
}

@Composable
fun ISRCalculator(){
    Vista(titulo = "ISR Calculator")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Vista(titulo:String){
    var texto by remember { mutableStateOf("") }
    var isr by remember { mutableStateOf("") }
    var sueldoTotal by remember { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.leonardo_phoenix_create_an_image_with_a_dark_and_ominous_backg_3),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.Center)

        Text("ISR Calculator",
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            style = TextStyle(
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
        )

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly){
//----------------------------------------------------------------------------------------------
            OutlinedTextField(
                value = texto,
                onValueChange = {texto = it},
                label = { Text("Introduce tu sueldo mensual",
                    style = TextStyle(
                        Color.Gray,
                        fontStyle = FontStyle.Italic,
                        fontSize = 14.sp
                    )
                ) },
                placeholder = { Text("Introduce tu sueldo mensual") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = outlinedTextFieldColors(
                    unfocusedBorderColor = Color.LightGray
                )
            )
        }
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            ElevatedButton(onClick = { /*Calcular(texto)*/ },
                colors = ButtonDefaults.buttonColors(
                    Color.Blue,
                    contentColor = Color.White
                )
            ) {
                Text("Calcular", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp))
            }
            Spacer(modifier = Modifier.padding(10.dp))
            ElevatedButton(onClick = {" "},
                colors = ButtonDefaults.buttonColors(
                    Color.Red,
                    contentColor = Color.White
                )) {
                Text("Borrar", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp))
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly){
            OutlinedTextField(
                readOnly = true,
                value = isr,
                onValueChange = {isr= it},
                label = { Text("Retención de ISR",
                                style = TextStyle(
                                    Color.Red,
                                    fontSize = 15.sp
                                )
                )},
//                placeholder = { Text("Retención de ISR")},
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Red,
                    focusedBorderColor = Color.Red
                )
                )
        }
        //Spacer(modifier = Modifier.padding(10.dp))
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly){
            OutlinedTextField(
                readOnly = true,
                value = sueldoTotal,
                onValueChange = {sueldoTotal=it},
                label = { Text("Sueldo Neto",
                                style = TextStyle(
                                    Color.Green,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                )},
//                placeholder = {Text("Sueldo neto")},
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Green,
                    focusedBorderColor = Color.Green
                )
            )
        }
        Row (modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 150.dp),
            horizontalArrangement = Arrangement.Center){
            Text("By AletsMarts, ITL©",
                style = TextStyle(
                    Color.Gray,
                    fontSize = 10.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic
                ),
            )
        }

    }
}

fun Calcular(texto: String, onResultado: (String) -> Unit) {
    if (texto.isNotBlank()) {
        val numeroInt = texto.toIntOrNull() ?: 0
        val resultado = numeroInt * 7
        onResultado("El resultado es: ${resultado.toDouble().toString()}")
    } else {
        // Mostrar un mensaje de error
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ISRCalculatorTheme {
        Vista("ISR Calculator")
    }
}