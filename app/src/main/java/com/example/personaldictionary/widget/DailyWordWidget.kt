// app/src/main/java/com/example/personaldictionary/widget/DailyWordWidget.kt
package com.example.personaldictionary.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.ActionParameters
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.background
import androidx.glance.color.ColorProvider
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
//import androidx.glance.unit.dp
import androidx.compose.ui.unit.dp

/**
 * daily word widget
 * -----------------
 * Purpose:
 *   Provides a simple Glance UI and wires a tap action to RefreshAction.
 *
 * Methods used:
 *   - provideGlance(): entry point; calls provideContent{}.
 *   - GlanceModifier.clickable(): attaches actionRunCallback<RefreshAction>().
 *
 * Variables created:
 *   - none
 */
class DailyWordWidget : GlanceAppWidget() {

    /**
     * provideGlance(...)
     * -------------------
     * Purpose:
     *   Provide the composable content to the Glance host.
     *
     * Methods used:
     *   - provideContent { Content() }
     *
     * Variables created:
     *   - none
     */
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent { Content() }
    }

    /**
     * Content()
     * ---------
     * Purpose:
     *   Column with three text lines. Uses ColorProvider for day/night.
     *
     * Methods used:
     *   - Column(), Text(), padding(), fillMaxSize(), background()
     *   - GlanceModifier.clickable(actionRunCallback<RefreshAction>())
     *
     * Variables created:
     *   - none
     */
    @Composable
    private fun Content() {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .padding(12.dp)
                // Day/night background color via ColorProvider (color.*)
                .background(
                    ColorProvider(day = Color.White, night = Color(0xFF1C1C1E))
                )
                .clickable(actionRunCallback<RefreshAction>())
        ) {
            Text(
                text = "Word of the day",
                // TextStyle color expects ColorProvider, not Color
                style = TextStyle(
                    color = ColorProvider(day = Color.Black, night = Color.White)
                )
            )
            Text(
                text = "hello — привет",
                style = TextStyle(
                    color = ColorProvider(day = Color.Black, night = Color.White)
                )
            )
            Text(
                text = "(tap to refresh)",
                style = TextStyle(
                    color = ColorProvider(day = Color.Gray, night = Color.LightGray)
                )
            )
        }
    }
}

/**
 * refresh action
 * --------------
 * Purpose:
 *   Placeholder ActionCallback invoked by widget tap.
 *
 * Methods used:
 *   - onAction(): will update state and trigger re-render.
 *
 * Variables created:
 *   - none
 */
class RefreshAction : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        // TODO: update state and re-render:
        // updateAppWidgetState(context, glanceId) { prefs -> ... }
        // DailyWordWidget().update(context, glanceId)
    }
}