package com.ojijo.ojijolawmate.ui.screens.lawyerdetail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ojijo.ojijolawmate.ui.screens.lawyer.sampleLawyers

@Composable
fun LawyerDetailScreen(navController: NavController, lawyerName: String) {
    // Find the lawyer by name from the sample data
    val lawyer = sampleLawyers.find { it.name == lawyerName }

    if (lawyer != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Lawyer Details", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Name: ${lawyer.name}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Specialization: ${lawyer.specialization}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Phone: ${lawyer.phone}", style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text("Back")
            }
        }
    }
}