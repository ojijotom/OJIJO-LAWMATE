package com.ojijo.ojijolawmate.ui.screens.lawyerdetail

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ojijo.ojijolawmate.ui.screens.lawyer.sampleLawyers

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LawyerDetailScreen(navController: NavController, lawyerName: String) {
    val lawyer = sampleLawyers.find { it.name == lawyerName }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lawyer Profile") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        if (lawyer != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(6.dp),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(text = lawyer.name, style = MaterialTheme.typography.headlineSmall)
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(text = "Specialization:", style = MaterialTheme.typography.labelLarge)
                        Text(text = lawyer.specialization, style = MaterialTheme.typography.bodyLarge)
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(text = "Phone:", style = MaterialTheme.typography.labelLarge)
                        Text(text = lawyer.phone, style = MaterialTheme.typography.bodyLarge)
                    }
                }

                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(0.5f)
                ) {
                    Text("Back")
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("Lawyer not found", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
