package id.ac.unpas.ppm.agenda.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import id.ac.unpas.ppm.agenda.R

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentRoute = remember {
        mutableStateOf("")
    }

    Scaffold(floatingActionButton = {
        if (currentRoute.value == NavScreen.Home.route) {
            FloatingActionButton(onClick = { navController.navigate(NavScreen.Add.route) }) {
                Image(painterResource(id = R.drawable.baseline_add_24), contentDescription = "Add")
            }
        }

    }) { innerPadding ->
        NavHost(navController = navController, startDestination = NavScreen.Home.route) {
            composable(NavScreen.Home.route) {
                currentRoute.value = NavScreen.Home.route
                HomeScreen(navController = navController, modifier = Modifier.padding(innerPadding)) {
                    navController.navigate(NavScreen.List.route)
                }
            }
            composable(NavScreen.List.route) {
                currentRoute.value = NavScreen.List.route
                ListTodoScreen(modifier = Modifier.padding(innerPadding)) { id ->
                    navController.navigate("${NavScreen.Edit.route}/$id")
                }
            }
            composable(NavScreen.Add.route) {
                currentRoute.value = NavScreen.Add.route
                FormTodoScreen(modifier = Modifier.padding(innerPadding))
            }
            composable(NavScreen.Edit.routeWithArgument,
                arguments = listOf(navArgument(NavScreen.Edit.argument0) { type = NavType.StringType }))
            { backStackEntry ->
                val id = backStackEntry.arguments?.getString(NavScreen.Edit.argument0) ?: return@composable

                currentRoute.value = NavScreen.Edit.route
                FormTodoScreen(modifier = Modifier.padding(innerPadding), id = id)
            }
        }
    }
}