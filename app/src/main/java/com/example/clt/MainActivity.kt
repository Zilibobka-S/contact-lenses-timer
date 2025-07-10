@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.clt

import androidx.datastore.preferences.core.*

import android.content.Context
import android.graphics.Color.parseColor
import android.os.Bundle
import android.preference.PreferenceDataStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.clt.ui.theme.ContactLensesTimerTheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.prefs.Preferences
import android.R.attr.value
import androidx.compose.runtime.LaunchedEffect

val Context.dataStore by preferencesDataStore(name = "settings")
val DSTATE_KEY = intPreferencesKey("dstate")
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
                        Entrance(context = LocalContext.current)
                        Greeting()

                    }
                }
            }
        }
    }
}

//этот код это [CENSORED] очень интересное чтиво, мои соболезнования читающему

@Composable
fun Greeting() {
    var state = 0
    var bla by remember { mutableStateOf("жопа") }
    Button(
        onClick = {
            if (state == 0) {
                state = state + 1
                bla = "bladota"
            } else {
                bla = "блядота"
                state = 0
            }
        },
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
@Composable
fun Entrance(context: Context) {
    val scope = rememberCoroutineScope()
    var dstate by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        val prefs = context.dataStore.data.first()
        dstate = prefs[DSTATE_KEY] ?: 0
    }


    if (dstate == 0){
        AlertDialog( onDismissRequest = {},
            title = { Text(text = "Warning! You will see this dialog once!")},
            text = { Text("This app is provided  \'as is\' without any warranties or guarantees. The developer does not take any responsibility for vision or eye health issues, or any other medical conditions related to the use of this app. This application is intended only as a personal reminder tool and does not replace professional medical advice. Please consult with an eye care professional before making any decisions regarding your contact lenses. Use this app at your own risk. The developer is also not liable for any bugs or malfunctions in the application.") },
            confirmButton = {
                Button(onClick = { scope.launch {
                    saveDState(context, 1)}; dstate = 1
                }){ Text("Ok")}

            }
        )



    }
}

val String.blues
    get() = Color(parseColor(this))

suspend fun saveDState(context: Context, value: Int){
    context.dataStore.edit {it[DSTATE_KEY] = value}
}
