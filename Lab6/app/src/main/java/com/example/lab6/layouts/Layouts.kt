package com.example.lab6.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AdvancedCounter() {
    // Variables de estado
    var count by remember { mutableIntStateOf(0) }
    var totalIncrements by remember { mutableIntStateOf(0) }
    var totalDecrements by remember { mutableIntStateOf(0) }
    var maxValue by remember { mutableIntStateOf(count) }
    var minValue by remember { mutableIntStateOf(count) }
    var totalChanges by remember { mutableIntStateOf(0) }
    var history by remember { mutableStateOf(listOf<Int>()) }

    // Función para actualizar estadísticas y contador
    fun updateStatistics(newCount: Int) {
        if (newCount > count) totalIncrements++
            else totalDecrements++
        maxValue = maxOf(maxValue, newCount)
        minValue = minOf(minValue, newCount)
        totalChanges++
        history = history + newCount
        count = newCount
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        // Título
        Text("Javier Lopez", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(16.dp))

        // Contador
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(MaterialTheme.colorScheme.tertiary, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { updateStatistics(count - 1) }) {
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Decrement")
                }
            }

            Text(
                text = "$count",
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(horizontal = 32.dp)
            )

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(MaterialTheme.colorScheme.tertiary, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { updateStatistics(count + 1) }) {
                    Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Increment")
                }
            }
        }

        // Estadísticas
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Total incrementos: $totalIncrements", style = MaterialTheme.typography.bodyLarge)
            Text("Total decrementos: $totalDecrements", style = MaterialTheme.typography.bodyLarge)
            Text("Valor máximo: $maxValue", style = MaterialTheme.typography.bodyLarge)
            Text("Valor mínimo: $minValue", style = MaterialTheme.typography.bodyLarge)
            Text("Total cambios: $totalChanges", style = MaterialTheme.typography.bodyLarge)
        }

        // Historial
        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            items(history.size) { index ->
                // La comparación ahora se hace para todos los elementos
                val color = if (index == 0) {
                    if (history[index] > 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                } else {
                    if (history[index] > history[index - 1]) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .background(color, shape = RoundedCornerShape(4.dp))
                        .size(50.dp)
                ) {
                    Text(text = "${history[index]}")
                }
            }
        }

        // Botón de Reiniciar
        Button(
            onClick = {
                count = 0
                totalIncrements = 0
                totalDecrements = 0
                maxValue = 0
                minValue = 0
                totalChanges = 0
                history = listOf()
            },
            modifier = Modifier.fillMaxWidth().padding(top = 450.dp)
        ) {
            Text("Reiniciar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AdvancedCounter()
}
