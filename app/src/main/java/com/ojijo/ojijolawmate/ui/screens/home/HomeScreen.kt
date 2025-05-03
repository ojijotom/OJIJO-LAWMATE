package com.ojijo.ojijolawmate.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ojijo.ojijolawmate.navigation.Routes

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to LawMate", modifier = Modifier.padding(bottom = 16.dp))

        Button(onClick = { navController.navigate(Routes.ViewLawsScreen) }) {
            Text("View IPC Laws")
        }

        Button(onClick = { navController.navigate(Routes.SearchLawsScreen) }) {
            Text("Search Law")
        }

        Button(onClick = { navController.navigate(Routes.LawyerScreen) }) {
            Text("Find Lawyer")
        }



        Button(onClick = { navController.navigate(Routes.CourtInfoScreen) }) {
            Text("Court Info")
        }
    }
}
