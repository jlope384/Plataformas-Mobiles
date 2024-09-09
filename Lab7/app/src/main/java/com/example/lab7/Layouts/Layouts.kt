package com.example.lab7.Layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.ejercicioslabs.ejercicios.agosto19.Notification
import com.uvg.ejercicioslabs.ejercicios.agosto19.NotificationType
import com.uvg.ejercicioslabs.ejercicios.agosto19.generateFakeNotifications
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralDesign(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notificaciones") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                navigationIcon = {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Menu")
                }
            )
        },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                FilterSection()
            }
        }
    )
}

@Composable
fun Design(
    modifier: Modifier = Modifier,
    chips: List<String>,
    selectedChipIndex: Int,
    onChipSelected: (Int) -> Unit,
    notifications: List<Notification>
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text("Tipos de Notificaciones", style = MaterialTheme.typography.titleMedium)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                chips.forEachIndexed { index, chipText ->
                    FilterChip(
                        selected = selectedChipIndex == index,
                        onClick = { onChipSelected(index) },
                        label = {
                            Text(
                                chipText,
                                color = if (selectedChipIndex == index)
                                    MaterialTheme.colorScheme.primary
                                else
                                    MaterialTheme.colorScheme.onSurface
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(containerColor = MaterialTheme.colorScheme.surface),
                        leadingIcon = if (selectedChipIndex == index) {
                            {
                                Icon(
                                    imageVector = Icons.Filled.Done,
                                    contentDescription = "Done icon",
                                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                                )
                            }
                        } else {
                            null
                        }
                    )
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.inverseSurface, RoundedCornerShape(16.dp))
                    .padding(0.dp, 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(notifications.size) { index ->
                    NotificationItem(notifications[index])
                }
            }
        }
    }
}

@Composable
fun NotificationItem(notification: Notification) {
    val ColorGeneral = MaterialTheme.colorScheme.primary
    val ColorPost = MaterialTheme.colorScheme.secondary
    val ColorMensaje = MaterialTheme.colorScheme.tertiary
    val ColorLike = MaterialTheme.colorScheme.onPrimary
    val dateFormat = SimpleDateFormat("dd MMM. h:mm a", Locale.getDefault())

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val backgroundColor = when (notification.type) {
            NotificationType.GENERAL -> ColorGeneral
            NotificationType.NEW_POST -> ColorPost
            NotificationType.NEW_MESSAGE -> ColorMensaje
            NotificationType.NEW_LIKE -> ColorLike
        }

        val iconResId = when (notification.type) {
            NotificationType.GENERAL -> com.example.lab7.R.drawable.ic_notification
            NotificationType.NEW_POST -> com.example.lab7.R.drawable.ic_post
            NotificationType.NEW_MESSAGE -> com.example.lab7.R.drawable.ic_chat
            NotificationType.NEW_LIKE -> com.example.lab7.R.drawable.ic_like
        }

        Box(
            modifier = Modifier
                .size(64.dp)
                .padding(6.dp)
                .background(color = backgroundColor, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize() // El icono ocupará tod el espacio disponible dentro de la Box
                    .padding(12.dp) // Espacio opcional para que el icono no toque los bordes
            )
        }

        Spacer(modifier = Modifier.size(8.dp))

        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(0.97f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(notification.title, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                Text(dateFormat.format(notification.sendAt), style = MaterialTheme.typography.bodySmall)
            }
            Text(notification.body, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun FilterSection() {
    val notifications = generateFakeNotifications()
    val chips = listOf("General", "Post", "Mensaje", "Like")
    var selectedChipIndex by remember { mutableIntStateOf(-1) }

    Design(
        chips = chips,
        selectedChipIndex = selectedChipIndex,
        onChipSelected = { index ->
            selectedChipIndex = if (index == selectedChipIndex) -1 else index
        },
        notifications = when (selectedChipIndex) {
            0 -> notifications.filter { it.type == NotificationType.GENERAL }
            1 -> notifications.filter { it.type == NotificationType.NEW_POST }
            2 -> notifications.filter { it.type == NotificationType.NEW_MESSAGE }
            3 -> notifications.filter { it.type == NotificationType.NEW_LIKE }
            else -> notifications
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PantallaPreview() {
    val notifications = generateFakeNotifications()
    val chips = listOf("General", "Post", "Mensaje", "Like")
    val selectedChipIndex = 0

    Design(
        chips = chips,
        selectedChipIndex = selectedChipIndex,
        onChipSelected = {},
        notifications = notifications
    )
}
