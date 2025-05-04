package com.ojijo.ojijolawmate.ui.screens.courtinfo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ojijo.ojijolawmate.navigation.Routes

data class Court(
    val name: String,
    val location: String,
    val contact: String
)

val sampleCourts = listOf(
    Court("Supreme Court of Kenya", "Nairobi", "+254 20 2221221"),
    Court("Court of Appeal – Nairobi", "Nairobi", "+254 20 2221221"),
    Court("High Court – Milimani Law Courts", "Nairobi", "+254 730 181001"),
    Court("High Court – Mombasa", "Mombasa", "+254 41 2315141"),
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
    // Add other courts here...
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourtInfoScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Kenyan Courts", fontWeight = FontWeight.Bold) }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(sampleCourts) { court ->
                CourtCard(court = court, navController = navController)
            }
        }
    }
}

@Composable
fun CourtCard(court: Court, navController: NavController) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = court.name,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "📍 Location: ${court.location}",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "📞 Contact: ${court.contact}",
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 13.sp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    navController.navigate("${Routes.CourtDetailScreen}/${court.name}")
                },
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.small
            ) {
                Text("View Details")
            }
        }
    }
}
