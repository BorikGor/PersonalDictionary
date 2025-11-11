package com.example.personaldictionary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * MainActivity
 * ------------
 * Purpose:
 *   Shows a minimal screen so the app isn't just a black screen.
 *
 * Methods used:
 *   - setContent(): sets Compose UI content.
 *
 * Variables created:
 *   - none
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppHome()
        }
    }
}

/**
 * AppHome()
 * ---------
 * Purpose:
 *   Minimal UI with a title and a hint about the widget.
 *
 * Methods used:
 *   - Column(), Text(), Button()
 *
 * Variables created:
 *   - none
 */
@Composable
fun AppHome() {
    MaterialTheme {
        Surface(Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Personal Dictionary",
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = "Add the Home Screen widget:\n" +
                            "Press and hold on Home → Widgets → Personal Dictionary."
                )
                // Place app navigation here later
            }
        }
    }
}
