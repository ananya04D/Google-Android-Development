package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    val result = remember { mutableStateOf(1) }

    val imageResource = when (result.value) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    // Ensure the Column takes up the full screen
    Column(
        modifier = Modifier
            .fillMaxSize() // Makes the Column fill the screen
            .padding(16.dp), // Optional padding for spacing
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Center content vertically
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.value.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result.value = (1..6).random() }) {
            Text(stringResource(R.string.roll))
        }
    }
}
