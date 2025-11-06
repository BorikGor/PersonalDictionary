// app/src/main/java/com/example/personaldictionary/widget/DailyWordWidgetReceiver.kt
package com.example.personaldictionary.widget

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

/**
 * widget receiver
 * ---------------
 * Purpose:
 *   Binds the widget class to the Android AppWidget framework.
 *
 * Methods used:
 *   - glanceAppWidget: returns the widget instance.
 *
 * Variables created:
 *   - none
 */
class DailyWordWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = DailyWordWidget()
}