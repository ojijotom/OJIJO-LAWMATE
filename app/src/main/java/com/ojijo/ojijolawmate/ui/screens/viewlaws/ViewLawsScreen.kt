package com.ojijo.ojijolawmate.ui.screens.viewlaws

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ojijo.ojijolawmate.navigation.Routes

data class Law(
    val section: String,
    val title: String,
    val description: String
)

val sampleLaws = listOf(
    Law("Section 302", "Punishment for Murder", "Whoever commits murder shall be punished with death or imprisonment for life and shall also be liable to fine."),
    Law("Section 376", "Punishment for Rape", "Whoever commits rape shall be punished with rigorous imprisonment for a term not less than 10 years."),
    Law("Section 420", "Cheating and Dishonestly Inducing Delivery of Property", "Cheating and dishonestly inducing delivery of property shall be punished with imprisonment up to 7 years and fine."),
    Law("Section 498A", "Cruelty by Husband or Relatives", "Husband or relative of husband of a woman subjecting her to cruelty shall be punished with imprisonment up to 3 years and fine.")
)

@Composable
fun ViewLawsScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(sampleLaws) { law ->
            LawCard(law) {
                navController.navigate("${Routes.LawDetailScreen}/${law.section}")
            }
        }
    }
}

@Composable
fun LawCard(law: Law, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = law.section, style = MaterialTheme.typography.titleMedium)
            Text(text = law.title, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = law.description, style = MaterialTheme.typography.bodySmall)
        }
    }
}
