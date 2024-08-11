package com.example.lab5.layouts

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab5.R
import com.example.lab5.ui.theme.Lab5Theme

@Composable
fun Vista() {
    // Obteniendo el contexto actual
    val context = LocalContext.current

    // Superficie principal que cubre toda la pantalla
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFFF6F6) // Fondo gris claro para toda la pantalla
    ) {
        Column {
            // Caja vacía que actúa como un espaciador
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp))

            // Fila que contiene el encabezado con la notificación de actualización
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFFE4FBFB)) // Fondo celeste para la barra superior
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween, // Distribuye los elementos a lo largo de la fila
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.weight(0.3f)) // Espaciador antes del logo

                        // Imagen del logo
                        Image(
                            painter = painterResource(id = R.drawable.ic_reload), // Reemplaza con el ID de tu logo
                            contentDescription = "Logo",
                            modifier = Modifier
                                .size(24.dp) // Tamaño del logo
                                .weight(1.2f)
                        )

                        // Texto que indica que hay una actualización disponible
                        Text(
                            text = "Actualización disponible",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.weight(8f) // Peso para ajustar el espacio ocupado por el texto
                        )

                        // Botón de descargar
                        TextButton(
                            onClick = {
                                // Inicia una actividad que abre una URL en un navegador
                                val intent = Intent(Intent.ACTION_VIEW).apply {
                                    data = Uri.parse("https://play.google.com/store/apps/details?id=com.riotgames.league.wildrift&pcampaignid=web_share")
                                }
                                context.startActivity(intent)
                            },
                            modifier = Modifier.weight(3f) // Peso para ajustar el espacio ocupado por el botón
                        ) {
                            Text("Descargar")
                        }
                    }
                }
            }
        }

        // Columna principal que contiene el contenido de la pantalla
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp) // Padding interno para separar el contenido del borde de la pantalla
        ) {
            // Sección superior con la hora, actualización disponible y botón de descarga
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp))

            // Fila que muestra la fecha y el botón de terminar jornada
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp) // Ajusta el padding según lo necesites
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        // Texto que muestra el día de la semana
                        Text(
                            text = "Domingo",
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Bold
                        )
                        // Texto que muestra la fecha
                        Text(
                            text = "5 de mayo",
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp)) // Añadir un pequeño espaciado si es necesario

                    // Botón para terminar la jornada
                    TextButton(
                        onClick = { /* Acción del botón */ },
                        shape = RoundedCornerShape(16.dp), // Bordes redondeados
                        border = BorderStroke(1.dp, color = Color.Black)
                    ) {
                        Text(
                            text = "Terminar jornada",
                            color = Color(0xFF6200EA) // Color morado para el texto
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp)) // Espaciador entre secciones

            // Sección con el nombre, dirección y horario del lugar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White) // Fondo blanco para la sección interna
            ) {
                // Fila para posicionar el ícono de ubicación en la esquina superior derecha
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.Top
                ) {
                    // Ícono de ubicación que abre una aplicación de mapas
                    IconButton(onClick = {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("geo:0,0?q=3A Calle 990, Cdad. de Guatemala 01010")
                        )
                        context.startActivity(intent)
                    }) {
                        Icon(
                            imageVector = Icons.Default.LocationOn, // Ícono de localización predeterminado
                            contentDescription = null,
                            tint = Color(0xFF6200EA) // Color del ícono, ajusta según lo necesites
                        )
                    }
                }

                // Contenido principal debajo del ícono
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    // Nombre del lugar
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "La Taza",
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Dirección del lugar
                    Text(
                        text = "3 calle 9-90 zona 10, Guatemala City",
                        style = MaterialTheme.typography.bodyMedium,
                    )

                    // Horario de atención
                    Text(
                        text = "7:00AM 10:00PM",
                        style = MaterialTheme.typography.bodySmall,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Fila para los botones de iniciar y ver detalles
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Botón de iniciar
                        Button(
                            onClick = {
                                // Muestra un mensaje de toast con el nombre del usuario
                                Toast.makeText(context, "Javier Alejandro López del Cid", Toast.LENGTH_LONG).show()
                            },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFA8000)) // Color naranja para el botón
                        ) {
                            Text("Iniciar")
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        // Botón de ver detalles
                        TextButton(
                            onClick = {
                                // Muestra un mensaje de toast con los detalles de las bebidas y el costo
                                Toast.makeText(context, "Bebidas: Cafe\nCosto: QQ", Toast.LENGTH_LONG).show()
                            },
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Detalles",
                                color = Color(0xFFFA8000) // Color naranja para el texto del botón
                            )
                        }
                    }
                }
            }
        }
    }
}

// Función para previsualizar el diseño en el editor de Android Studio
@Preview(showBackground = true)
@Composable
private fun VistaPreview() {
    Lab5Theme {
        Vista()
    }
}
