package com.example.lab4.layouts

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab4.R

@Composable
fun Frontend(modifier: Modifier = Modifier) {
    // Contenedor principal que llena el tamaño disponible y tiene un borde verde
    Box(
        modifier = modifier
            .fillMaxSize()
            .border(8.dp, Color.Green) // Intente modificar con MaterialTheme.colorScheme.primary pero el color nunca cambió
            .padding(20.dp)
    ) {
        // Columna principal que llena el tamaño disponible y tiene padding vertical
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 16.dp)
        ) {
            // Añade un espacio vacío que ocupa el 10% del tamaño de la columna
            Spacer(modifier = Modifier.weight(0.1f))

            // Contenedor para la imagen, ocupando el 80% del tamaño de la columna
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .paint(
                        painter = painterResource(id = R.drawable.logo1),
                        contentScale = ContentScale.Fit,
                        alpha = 0.50f
                    )
            ) {
                // Columna interna que distribuye su contenido con espacio entre los elementos
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    // Texto centrado y en negrita para el nombre de la universidad
                    Text(
                        text = "Universidad Del Valle de Guatemala",
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineLarge,
                        textAlign = TextAlign.Center
                    )
                    // Texto centrado para el nombre del curso
                    Text(
                        text = "Programacion de plataformas moviles",
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Center
                    )
                    // Fila para los integrantes del curso
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Texto centrado y en negrita para el título "Integrantes"
                        Text(
                            text = "Integrantes",
                            modifier = Modifier
                                .weight(0.50f)
                                .align(Alignment.CenterVertically),
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.headlineSmall,
                            textAlign = TextAlign.Center
                        )
                        // Texto centrado con los nombres de los integrantes
                        Text(
                            text = "Javier Lopez \nJune Watanabe \nDaniela Ramirez",
                            modifier = Modifier
                                .weight(0.50f)
                                .align(Alignment.CenterVertically),
                            textAlign = TextAlign.Center
                        )
                    }
                    // Fila para el nombre del catedrático
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Texto centrado y en negrita para el título "Catedratico"
                        Text(
                            text = "Catedratico",
                            modifier = Modifier
                                .weight(0.50f)
                                .align(Alignment.CenterVertically),
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.headlineSmall,
                            textAlign = TextAlign.Center
                        )
                        // Texto centrado con el nombre del catedrático
                        Text(
                            text = "Juan Carlos Durini",
                            modifier = Modifier
                                .weight(0.50f)
                                .align(Alignment.CenterVertically),
                            textAlign = TextAlign.Center
                        )
                    }
                    // Texto centrado con el nombre y número de carné del estudiante
                    Text(
                        text = "Javier Lopez \n23415",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
            // Añade un espacio vacío que ocupa el 10% del tamaño de la columna
            Spacer(modifier = Modifier.weight(0.1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FrontendPreview() {
    Frontend()
}
