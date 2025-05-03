package com.ojijo.ojijolawmate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController // Import the correct type here
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ojijo.ojijolawmate.ui.screens.home.HomeScreen
import com.ojijo.ojijolawmate.ui.screens.lawyer.LawyerScreen
import com.ojijo.ojijolawmate.ui.screens.search.SearchScreen
import com.ojijo.ojijolawmate.ui.screens.viewlaws.ViewLawsScreen
import com.ojijo.ojijolawmate.ui.screens.courtinfo.CourtInfoScreen
import com.ojijo.ojijolawmate.ui.screens.lawdetail.LawDetailScreen
import com.ojijo.ojijolawmate.ui.screens.lawyerdetail.LawyerDetailScreen

@Composable
fun AppNavHost(navController: NavHostController) { // Change NavController to NavHostController here
    NavHost(navController = navController, startDestination = Routes.HomeScreen) {

        composable(Routes.HomeScreen) {
            HomeScreen(navController)
        }

        composable(Routes.ViewLawsScreen) {
            ViewLawsScreen(navController)
        }

        composable(Routes.SearchLawsScreen) {
            SearchScreen(navController)
        }

        composable(Routes.LawyerScreen) {
            LawyerScreen(navController)
        }

        composable(Routes.CourtInfoScreen) {
            CourtInfoScreen(navController)
        }

        // ✅ Lawyer Detail Screen Route
        composable(
            route = Routes.LawyerDetailScreen,
            arguments = listOf(navArgument("lawyerName") { type = NavType.StringType })
        ) { backStackEntry ->
            val lawyerName = backStackEntry.arguments?.getString("lawyerName") ?: ""
            LawyerDetailScreen(lawyerName = lawyerName, navController = navController)
        }

        // ✅ Law Detail Screen Route
        composable(
            route = Routes.LawDetailScreen,
            arguments = listOf(navArgument("section") { type = NavType.StringType })
        ) { backStackEntry ->
            val section = backStackEntry.arguments?.getString("section") ?: ""
            LawDetailScreen(section = section)
        }
    }
}
