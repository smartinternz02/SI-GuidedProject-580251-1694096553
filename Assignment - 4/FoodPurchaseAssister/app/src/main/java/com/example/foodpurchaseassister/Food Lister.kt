package com.example.foodpurchaseassister

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Food(navController: NavController) {
    var temp: List<food> = foods[selected] ?: listOf()
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Image(painter = painterResource(id = R.drawable.pattern), contentDescription = null, modifier = Modifier
            .fillMaxSize()
            .alpha(0.5f), contentScale = ContentScale.Crop)
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Foods", modifier = Modifier.padding(16.dp), fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold, fontSize = 64.sp, color = Color.White)
        Spacer(modifier = Modifier.padding(16.dp))
        LazyColumn {
            items(temp) { it -> eachcard_food(navController, food = it)}
        }
    }
}

data class food(val title: String, val poster: Int, val price: Int)

val foods = mapOf<String, List<food>> (
    "Spice Fusion Restaurant" to listOf(
        food("Pizza", R.drawable.pizza, 135),
        food("Biryani", R.drawable.biryani, 245),
        food("Pepsi", R.drawable.pepsi, 20),
        food("Sprite", R.drawable.sprite, 20),
        food("KFC", R.drawable.kfc, 185)
    ),
    "The Hungry Traveler Cafe" to listOf(
        food("Coffee", R.drawable.coffee, 65),
        food("Sprite", R.drawable.sprite, 20),
        food("Burgur", R.drawable.burgur, 89),
        food("Pop Corn", R.drawable.pop_corn, 40),
        food("Ice Cream", R.drawable.ice_cream, 30)
    ),
    "Seafood Sensations Grill" to listOf(
        food("Fish Fry", R.drawable.fish_fry, 70),
        food("Pepsi", R.drawable.pepsi, 20),
        food("Biryani", R.drawable.biryani, 134),
        food("Dosa", R.drawable.dosa, 35),
        food("Chapathi", R.drawable.roti, 45)
    ),
    "Taste of Italy Trattoria" to listOf(
        food("Pizza", R.drawable.pizza, 175),
        food("KFC", R.drawable.kfc, 215),
        food("Burgur", R.drawable.burgur, 120),
        food("Pepsi", R.drawable.pepsi, 20),
        food("Sprite", R.drawable.sprite, 20),
        food("Fish Fry", R.drawable.fish_fry, 130)
    ),
    "Veggie Delights Garden Eatery" to listOf(
        food("Coffee", R.drawable.coffee, 30),
        food("Roti", R.drawable.roti, 25),
        food("Dosa", R.drawable.dosa, 15),
        food("Pizza", R.drawable.pizza, 89),
        food("Burgur", R.drawable.burgur, 76),
        food("Pop Corn", R.drawable.pop_corn, 45),
        food("Chapathi", R.drawable.roti, 25)
    )
)

@Composable
fun eachcard_food(navController: NavController, food: food) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .clickable { purchase = food; navController.navigate("purchase") }, elevation = 4.dp, backgroundColor = Color.Gray) {
        Column {
            Image(
                painter = painterResource(id = food.poster),
                contentDescription = food.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    food.title,
                    modifier = Modifier.padding(2.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(start = 64.dp, end = 64.dp))
                Text(
                    "₹" + food.price,
                    modifier = Modifier.padding(2.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

var purchase: food = food("", 0, 0)