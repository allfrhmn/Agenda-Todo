package id.ac.unpas.ppm.agenda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import id.ac.unpas.ppm.agenda.ui.screens.TodoScreen
import id.ac.unpas.ppm.agenda.ui.theme.AgendaTodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgendaTodoTheme {
                // A surface container using the 'background' color from the theme
                TodoScreen()
            }
        }
    }
}