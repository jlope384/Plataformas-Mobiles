package com.example.lab7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.lab7.ui.theme.Lab7Theme
import com.example.lab7.Layouts.GeneralDesign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab7Theme {
                // Llama a la función GeneralDesign para configurar el contenido de la actividad
                GeneralDesign()
            }
        }
    }
}
