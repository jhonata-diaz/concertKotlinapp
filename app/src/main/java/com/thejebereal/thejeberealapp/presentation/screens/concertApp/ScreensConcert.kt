package com.thejebereal.thejeberealapp.presentation.screens.concertApp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

fun formatDate(dateString: String): String {
    // Suponiendo que la fecha está en formato "YYYY-MM-DD" como en el ejemplo 2024-09-10
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val outputFormat = SimpleDateFormat("d 'de' MMMM 'de' yyyy", Locale("es", "ES"))
    val date = inputFormat.parse(dateString)
    return outputFormat.format(date)
}

// Funciones de extensión para formatear fecha
fun String.formatMonth(): String {
    val sdf = SimpleDateFormat("MMMM", Locale.getDefault())
    val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(this)
    return sdf.format(date ?: "").replaceFirstChar { it.uppercase() }
}

fun String.formatDay(): String {
    val sdf = SimpleDateFormat("d", Locale.getDefault())
    val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(this)
    return sdf.format(date ?: "")
}

fun String.formatDayOfWeek(): String {
    val sdf = SimpleDateFormat("EEEE", Locale.getDefault())
    val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(this)
    val fullDayOfWeek = sdf.format(date ?: "").replaceFirstChar { it.uppercase() }
    return fullDayOfWeek.take(4) // Tomar solo las primeras 4 letras
}

/*
@Composable
fun ConcertsRow(concerts: List<Concert>, navController: NavHostController) {
    if (concerts.isEmpty()) {
        Text(
            text = "No hay conciertos disponibles",
            modifier = Modifier.padding(vertical = 8.dp)
        )
    } else {
        LazyRow(
            modifier = Modifier.height(220.dp)
        ) {
            items(concerts) { concert ->
                ConcertItem(concert) { concertId ->
                    // Navegar a la pantalla de detalles del concierto
                    navController.navigate("concert_detail/$concertId")
                }
            }
        }
    }
}
*/




