package com.example.clt

import android.graphics.Color.parseColor
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clt.ui.theme.ContactLensesTimerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactLensesTimerTheme {
                Scaffold(
                    containerColor = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.Center
                    ) {

                        Greeting(


                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

        var bla by remember { mutableStateOf("жопа") }
        Button(
            onClick = { bla = "bladota" },

            content = {
                Text("негры")
            }
        )





    Surface (
        modifier = Modifier
            .width(500.dp),
            shape = RoundedCornerShape(14.dp),
        color = "#2159d1".blues
        )


    {
        Text(
            text = "поплачь, $bla",
            modifier = Modifier
                .padding(50.dp),

            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}

/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ContactLensesTimerTheme {
        Greeting("Anus")
    }
}
*/
val String.blues
    get() = Color(parseColor(this))



