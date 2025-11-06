// app/src/main/java/com/example/personaldictionary/MainActivity.kt
package com.example.personaldictionary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

/**
 * main activity
 * -------------
 * Purpose:
 *   Hosts a very simple Compose screen with a title.
 *
 * Methods used:
 *   - setContent: sets Compose UI content.
 *
 * Variables created:
 *   - none
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A minimal Material3 surface with a title text.
            Surface(color = MaterialTheme.colorScheme.background) {
                Text(text = "Personal Dictionary")
            }
        }
    }
}