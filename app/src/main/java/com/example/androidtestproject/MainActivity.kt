package com.example.androidtestproject

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.androidtestproject.ui.theme.AndroidTestProjectTheme
import com.ncorti.slidetoact.SlideToActView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lock_screen)

        val currentTime: TextView = findViewById(R.id.Time)
        val currentDate: TextView = findViewById(R.id.Date)
        val currentWeather: TextView = findViewById(R.id.Weather)
        val slider: SlideToActView = findViewById(R.id.slideToAct)

        currentDate.text = SimpleDateFormat("EEE, dd MMMM", Locale.getDefault()).format(Date())
        currentTime.text =
            SimpleDateFormat("HH:mm", Locale.getDefault()).format(Calendar.getInstance().time)


        slider.onSlideToActAnimationEventListener =
            object : SlideToActView.OnSlideToActAnimationEventListener {
                override fun onSlideCompleteAnimationEnded(view: SlideToActView) {
                    view.outerColor = ContextCompat.getColor(this@MainActivity, R.color.app_red)
                    view.innerColor = ContextCompat.getColor(this@MainActivity, R.color.white)
                    view.iconColor = ContextCompat.getColor(this@MainActivity, R.color.white)
                }

                override fun onSlideCompleteAnimationStarted(
                    view: SlideToActView,
                    threshold: Float
                ) {
                    view.outerColor = ContextCompat.getColor(this@MainActivity, R.color.app_red)
                    view.innerColor = ContextCompat.getColor(this@MainActivity, R.color.white)
                    view.iconColor = ContextCompat.getColor(this@MainActivity, R.color.black)
                }

                override fun onSlideResetAnimationEnded(view: SlideToActView) {
                }

                override fun onSlideResetAnimationStarted(view: SlideToActView) {
                }
            }
    }
}
