package com.ojijo.ojijolawmate.ui.screens.courtinfo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ojijo.ojijolawmate.navigation.Routes

// --- Data Model ---
data class Court(
    val name: String,
    val location: String,
    val contact: String
)

// --- Dummy Data ---
val sampleCourts = listOf(
    Court("Supreme Court of Kenya", "Nairobi", "+254 20 2221221"),
    Court("Court of Appeal – Nairobi", "Nairobi", "+254 20 2221221"),
    Court("High Court – Milimani Law Courts", "Nairobi", "+254 730 181000"),
    Court("High Court – Mombasa", "Mombasa", "+254 41 2315140"),
    Court("High Court – Kisumu", "Kisumu", "+254 57 2021211"),
    Court("High Court – Eldoret", "Eldoret", "+254 53 2063310"),
    Court("High Court – Nakuru", "Nakuru", "+254 51 2211381"),
    Court("High Court – Kisii", "Kisii", "+254 58 2030140"),
    Court("High Court – Nyeri", "Nyeri", "+254 61 2032521"),
    Court("High Court – Machakos", "Machakos", "+254 44 22215"),
    Court("High Court – Meru", "Meru", "+254 64 31362"),
    Court("High Court – Kakamega", "Kakamega", "+254 56 2030361"),
    Court("High Court – Bungoma", "Bungoma", "+254 55 2030140"),
    Court("High Court – Embu", "Embu", "+254 68 22314"),
    Court("High Court – Kericho", "Kericho", "+254 52 2021211"),
    Court("High Court – Kitale", "Kitale", "+254 54 2051211"),
    Court("High Court – Garissa", "Garissa", "+254 46 2102100"),
    Court("High Court – Malindi", "Malindi", "+254 42 2130140"),
    Court("High Court – Thika", "Thika", "+254 67 22314"),
    Court("High Court – Voi", "Voi", "+254 43 2030140"),
    Court("High Court – Busia", "Busia", "+254 55 2030140"),
    Court("High Court – Kajiado", "Kajiado", "+254 45 2030140"),
    Court("Employment and Labour Relations Court – Nairobi", "Nairobi", "+254 20 2221221"),
    Court("Environment and Land Court – Nairobi", "Nairobi", "+254 20 2221221"),
    Court("Small Claims Court – Nairobi", "Nairobi", "+254 720 967726"),
    Court("Small Claims Court – Kajiado", "Kajiado", "+254 720 967726"),
    Court("High Court – Narok", "Narok", "+254 50 22215"),
    Court("High Court – Nanyuki", "Nanyuki", "+254 62 2031320"),
    Court("High Court – Lodwar", "Lodwar", "+254 55 2030140"),
    Court("High Court – Kapenguria", "Kapenguria", "+254 55 2030140"),
    Court("High Court – Migori", "Migori", "+254 59 2030140"),
    Court("High Court – Homa Bay", "Homa Bay", "+254 59 2030140"),
    Court("High Court – Bomet", "Bomet", "+254 52 2021211"),
    Court("High Court – Isiolo", "Isiolo", "+254 64 2030140"),
    Court("High Court – Marsabit", "Marsabit", "+254 69 2030140"),
    Court("High Court – Wajir", "Wajir", "+254 46 2102100"),
    Court("High Court – Mandera", "Mandera", "+254 46 2102100"),
    Court("High Court – Nyamira", "Nyamira", "+254 58 2030140"),
    Court("High Court – Siaya", "Siaya", "+254 57 2021211"),
    Court("High Court – Tana River", "Hola", "+254 46 2102100"),
    Court("High Court – Lamu", "Lamu", "+254 42 2130140"),
    Court("Magistrates Court – Ruiru", "Ruiru", "+254 67 22314"),
    Court("Magistrates Court – Limuru", "Limuru", "+254 67 22314"),
    Court("Magistrates Court – Kitengela", "Kitengela", "+254 45 2030140"),
    Court("Magistrates Court – Kangema", "Kangema", "+254 60 2030140"),
    Court("Magistrates Court – Garsen", "Garsen", "+254 46 2102100")
)


// --- UI Composables ---
@Composable
fun CourtInfoScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(sampleCourts) { court ->
            CourtCard(court, navController)
        }
    }
}

@Composable
fun CourtCard(court: Court, navController: NavController) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = court.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "Location: ${court.location}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Contact: ${court.contact}", style = MaterialTheme.typography.bodySmall)

            // Add button to navigate to another screen, e.g., CourtDetailScreen
            Button(
                onClick = {
                    // Navigate to CourtDetailScreen, passing court details
                    navController.navigate("${Routes.CourtDetailScreen}/${court.name}")
                },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("View Details")
            }
        }
    }
}
