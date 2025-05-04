package com.ojijo.ojijolawmate.ui.screens.courtdetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ojijo.ojijolawmate.navigation.Routes

@Composable
fun CourtDetailScreen(courtName: String) {
    // Here, you can fetch the full details for the court using the courtName
    // For now, we will just display a dummy message based on court name

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top = 20.dp), // Padding from the top to give a clean look
        verticalArrangement = Arrangement.Top // Align to top for better content flow
    ) {
        // Title Section
        Text(
            text = "Court Details",
            style = MaterialTheme.typography.headlineLarge.copy(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(20.dp)) // Adds spacing between sections

        // Court Name Section
        Text(
            text = "Court Name: $courtName",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Medium
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Example of another detail (location, contact, etc.)
        Text(
            text = "Location: Some City, Some Country", // You can replace this with actual data
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f) // Dimmed color for secondary info
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Contact: (123) 456-7890", // Replace with actual contact details
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Optional: Add a button for actions like contacting the court
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            shape = MaterialTheme.shapes.medium // Rounded corners for the button
        ) {
            Text(
                text = "Contact Court",
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White)
            )
        }
    }
}

@Preview
@Composable
fun PreviewCourtDetailScreen() {
    CourtDetailScreen(courtName = "High Court of Nairobi")
}
