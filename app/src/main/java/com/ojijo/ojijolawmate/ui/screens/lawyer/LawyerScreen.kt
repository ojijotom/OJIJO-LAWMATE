package com.ojijo.ojijolawmate.ui.screens.lawyer


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ojijo.ojijolawmate.navigation.Routes

// --- Data Model ---
data class Lawyer(
    val name: String,
    val specialization: String,
    val phone: String
)

// --- Sample Data (truncated for brevity, use your full list) ---
val sampleLawyers = listOf(
    Lawyer("Nelson Havi", "Constitutional Law", "0700123456"),
    Lawyer("Martha Karua", "Human Rights Law", "0722123456"),
    Lawyer("Ojijo Pascal", "Criminal Law", "0798000000"),
    Lawyer("Ahmednasir Abdullahi", "Commercial Law", "0718123456"),
    Lawyer("Paul Muite", "Criminal Law", "0721123456"),
    Lawyer("James Orengo", "Land and Property Law", "0733123456"),
    Lawyer("Philip Murgor", "Public Law", "0745123456"),
    Lawyer("Fred Ngatia", "Litigation", "0711123456"),
    Lawyer("Wanjiru Karanja", "Family Law", "0799123456"),
    Lawyer("Mutula Kilonzo Jr.", "Environmental Law", "0755123456"),
    Lawyer("Julie Soweto", "Election Law", "0777123456"),
    Lawyer("Donald Kipkorir", "Corporate Law", "0731123456"),
    Lawyer("Njeri Mwangi", "Tax Law", "0788123456"),
    Lawyer("Danstan Omari", "Criminal & Civil Law", "0799123480"),
    Lawyer("Caroline Mutoko", "Media & Communications Law", "0740123456"),
    Lawyer("John Khaminwa", "Civil Rights Law", "0714123456"),
    Lawyer("Peter Wanyama", "Administrative Law", "0724123456"),
    Lawyer("Rita Njoki", "Immigration Law", "0791123456"),
    Lawyer("Eric Theuri", "Legal Compliance", "0780123456"),
    Lawyer("Lilian Omondi", "Insurance Law", "0770123456"),
    Lawyer("Patrick Lumumba", "Constitutional & Governance Law", "0729123456"),
    Lawyer("George Oraro", "Commercial & Corporate Law", "0722123456"),
    Lawyer("Githu Muigai", "International & Constitutional Law", "0734123456"),
    Lawyer("Fred Ojiambo", "Corporate & Commercial Law", "0735123456"),
    Lawyer("Judy Thongori", "Family & Gender-Based Violence Law", "0743123456"),
    Lawyer("Katwa Kigen", "Litigation & Dispute Resolution", "0746123456"),
    Lawyer("Steve Ogolla", "Corporate & Commercial Law", "0736123456"),
    Lawyer("Peter Kaluma", "Constitutional & Human Rights Law", "0737123456"),
    Lawyer("Dr. John Khaminwa", "Civil Rights Law", "0738123456"),
    Lawyer("Edward Oonge", "Commercial Law", "0739123456"),
    Lawyer("Taib Ali Taib", "Commercial Law", "0741123456"),
    Lawyer("Tom Macharia", "Corporate Law", "0742123456"),
    Lawyer("Elizabeth Kagotho", "Family Law", "0751123456"),
    Lawyer("Kipkoech Ngetich", "Criminal Law", "0752123456"),
    Lawyer("Judy Wangui", "Civil Litigation", "0753123456"),
    Lawyer("Joyce Miguda Majiwa", "Family Law", "0754123456"),
    Lawyer("Samuel Kipkoech", "Commercial Law", "0755123456"),
    Lawyer("David Ongonda", "Litigation", "0756123456"),
    Lawyer("Charles Mwongela", "Criminal Law", "0757123456"),
    Lawyer("Anthony Oluoch", "Human Rights Law", "0758123456"),
    Lawyer("Peter Munge", "Corporate Law", "0759123456"),
    Lawyer("Muthomi Thiankolu", "Commercial & Corporate Law", "0760123456"),
    Lawyer("Colbert Ojiambo", "Litigation", "0761123456"),
    Lawyer("Collette Akwana", "Corporate Law", "0762123456"),
    Lawyer("Cosma Wetende", "Corporate Law", "0763123456"),
    Lawyer("Cyprian Wekesa", "Litigation", "0764123456"),
    Lawyer("Danson Mugo", "Litigation", "0765123456"),
    Lawyer("Danstan Omari Mogaka", "Criminal & Civil Law", "0766123456"),
    Lawyer("David Otieno", "Commercial Law", "0767123456"),
    Lawyer("Davis C. Sang", "Litigation", "0768123456"),
    Lawyer("DBM Mosota", "Corporate Law", "0769123456"),
    Lawyer("Deborah Bubi", "Litigation", "0770123456"),
    Lawyer("Desmond Odhiambo", "Corporate Law", "0771123456"),
    Lawyer("Diana Ogula", "Corporate Law", "0772123456"),
    Lawyer("Muthomi Thionkulu", "Commercial Law", "0773123456"),
    Lawyer("Duncan Okatch", "Litigation", "0774123456"),
    Lawyer("Edward Omotii", "Corporate Law", "0775123456"),
    // ... (rest of the lawyers)
)

// --- UI Composables ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LawyerScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }

    val filteredLawyers = sampleLawyers.filter {
        it.name.contains(searchQuery, ignoreCase = true) ||
                it.specialization.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Find a Lawyer", style = MaterialTheme.typography.headlineSmall) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search by name or specialization") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(filteredLawyers) { lawyer ->
                    LawyerCard(lawyer = lawyer, navController = navController)
                }
            }
        }
    }
}

@Composable
fun LawyerCard(lawyer: Lawyer, navController: NavController) {
    Card(
        onClick = {
            navController.navigate(
                Routes.LawyerDetailScreen.replace("{lawyerName}", lawyer.name)
            )
        },
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(6.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = lawyer.name,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Specialization: ${lawyer.specialization}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Contact: ${lawyer.phone}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
