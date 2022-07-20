package com.example.nikeshoesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nikeshoesapp.ui.theme.NikeShoesAppTheme
import com.example.nikeshoesapp.ui.theme.PoppinsFamily
import com.example.nikeshoesapp.ui.theme.TextColor

val newShoesList = listOf(
    Shoes(
        name = "Nile Air",
        price = 55.50,
        rating = 4.5,
        imageIndex = R.drawable.new_shoes1
    ),
    Shoes(
        name = "Nile Air",
        price = 55.50,
        rating = 4.5,
        imageIndex = R.drawable.new_shoes1
    ),
    Shoes(
        name = "Nile Air",
        price = 55.50,
        rating = 4.5,
        imageIndex = R.drawable.new_shoes1
    ),
    Shoes(
        name = "Nile Air",
        price = 55.50,
        rating = 4.5,
        imageIndex = R.drawable.new_shoes1
    ),
    Shoes(
        name = "Nile Air",
        price = 55.50,
        rating = 4.5,
        imageIndex = R.drawable.new_shoes1
    ),
    Shoes(
        name = "Nile Air",
        price = 55.50,
        rating = 4.5,
        imageIndex = R.drawable.new_shoes1
    ),
)

val shoesList = listOf(
    Shoes(
        name = "Air Max 270 G",
        price = 75.50,
        rating = 4.5,
        imageIndex = R.drawable.shoes1
    ),
    Shoes(
        name = "Air Max 270 G",
        price = 75.50,
        rating = 4.5,
        imageIndex = R.drawable.shoes1
    ),
    Shoes(
        name = "Air Max 270 G",
        price = 75.50,
        rating = 4.5,
        imageIndex = R.drawable.shoes1
    ), Shoes(
        name = "Air Max 270 G",
        price = 75.50,
        rating = 4.5,
        imageIndex = R.drawable.shoes1
    )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NikeShoesAppTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .padding(start = 24.dp),
                    contentColor = TextColor,
                ) {
                    HomeScreen()

                }
            }
        }
    }
}

/*Preview-------------------------------------------------------------------------------*/
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NikeShoesAppTheme {
        // A surface container using the 'background' color from the theme
        Scaffold(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(start = 24.dp),
            contentColor = TextColor
        ) {
            HomeScreen()

        }
    }
}

/*Home Screen-------------------------------------------------------------------------------*/

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()

    LaunchedEffect(Unit) { scrollState.animateScrollTo(10000) }
    Column(modifier = Modifier
        .fillMaxHeight()
        .verticalScroll(scrollState)) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(end = 24.dp)
        ) {
            Spacer(Modifier.height(14.dp))
            HomeAppBar()
            Spacer(Modifier.height(26.dp))
            SearchWidget()
            Spacer(Modifier.height(26.dp))
        }
        PopularGoods(shoes = shoesList)
        Spacer(Modifier.height(26.dp))
        NewGoods(shoes = newShoesList)
    }
}

@Composable
fun HomeAppBar() {
    Box {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(26.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_appbar_menu),
                contentDescription = "appbar menu",
                modifier = Modifier
                    .fillMaxHeight()
                    .width(30.dp)
                    .clickable { },
                colorFilter = ColorFilter.tint(TextColor)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_appbar_logo),
                contentDescription = "appbar icon",
                modifier = Modifier
                    .size(38.dp),
                colorFilter = ColorFilter.tint(TextColor)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_appbar_notify),
                contentDescription = "appbar notify",
                modifier = Modifier
                    .fillMaxHeight()
                    .width(30.dp)
                    .padding(vertical = 3.dp)
                    .clickable { },
                colorFilter = ColorFilter.tint(TextColor)
            )
        }
    }
}

@Composable
fun SearchWidget() {

    val textFieldState = remember { mutableStateOf(TextFieldValue("Search here...")) }

    Box {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(shape = AbsoluteRoundedCornerShape(10.dp), color = Color.White),
                value = textFieldState.value,
                onValueChange = { newText -> textFieldState.value = newText },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Color.White
                ),
                shape = AbsoluteRoundedCornerShape(10.dp),
                textStyle = TextStyle(fontFamily = PoppinsFamily, fontWeight = FontWeight.Normal)
            )
            Surface(
                shape = AbsoluteRoundedCornerShape(10.dp), color = Color.White
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(52.dp), contentAlignment = Alignment.Center
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_search_widget_filter),
                        contentDescription = "search filter",
                        modifier = Modifier
                            .width(41.dp)
                            .height(26.dp)
                            .clickable { },
                        colorFilter = ColorFilter.tint(TextColor)

                    )
                }
            }
        }
    }
}

@Composable
fun GoodsCard(shoes: Shoes) {
    Card(
        elevation = 3.dp, modifier = Modifier
            .width(250.dp)
            .height(300.dp)
            .padding(end = 14.dp),
        shape = AbsoluteRoundedCornerShape(10.dp)
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Top of the month",
                    modifier = Modifier.padding(start = 10.dp),
                    fontFamily = PoppinsFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_favorite_24),
                    contentDescription = "favorites",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .shadow(elevation = 14.dp, shape = CircleShape)
                        .clickable { }

                )
            }
            Text(
                text = shoes.name,
                modifier = Modifier.padding(start = 10.dp),
                fontFamily = PoppinsFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(224.dp),
                color = MaterialTheme.colors.secondary,
                shape = AbsoluteRoundedCornerShape(
                    topLeft = 80.dp,
                    topRight = 10.dp,
                    bottomRight = 10.dp,
                    bottomLeft = 10.dp
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = shoes.imageIndex),
                        contentDescription = "Good",
                        modifier = Modifier.size(width = 300.dp, height = 150.dp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "$${shoes.price}",
                            modifier = Modifier.padding(start = 10.dp),
                            fontFamily = PoppinsFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_add_circle_24),
                            contentDescription = "add good",
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .size(40.dp)
                                .clickable { },
                            colorFilter = ColorFilter.tint(TextColor)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PopularGoods(shoes: List<Shoes>) {
    Column(modifier = Modifier.background(MaterialTheme.colors.background)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 26.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Popular",
                fontFamily = PoppinsFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_more_horiz_24),
                contentDescription = "More",
                modifier = Modifier
                    .padding(end = 24.dp)
                    .clickable { },
                colorFilter = ColorFilter.tint(TextColor)
            )
        }
        LazyRow {
            items(shoes) { shoesItem ->
                GoodsCard(shoesItem)
            }
        }
    }
}

@Composable
fun NewGoods(shoes: List<Shoes>) {
    Surface(

        color = MaterialTheme.colors.onBackground,
        shape = AbsoluteRoundedCornerShape(10.dp)

    ) {
        Row {
            Column {
                Text(
                    text = "New items", modifier = Modifier
                        .rotate(270F)
                        .offset(x = (-70).dp),
                    fontSize = 18.sp,
                    fontFamily = PoppinsFamily,
                    fontWeight = FontWeight.SemiBold
                )
            }
            LazyColumn {
                items(shoes) { shoesItem ->
                    NewGoodsCard(shoes = shoesItem)
                }
            }
        }
    }

}

@Composable
fun NewGoodsCard(shoes: Shoes) {
    Card(
        modifier = Modifier
            .size(width = 280.dp, height = 102.dp)
            .padding(top = 18.dp, end = 26.dp),
        shape = AbsoluteRoundedCornerShape(5.dp),
        elevation = 3.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Surface {
                Image(
                    painter = painterResource(id = shoes.imageIndex),
                    contentDescription = "New shoes",
                    modifier = Modifier.size(width = 100.dp, height = 80.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxHeight()
            ) {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = shoes.name,
                        fontFamily = PoppinsFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_favorite_border_24),
                        contentDescription = "add goods",
                        modifier = Modifier
                            .size(18.dp)
                            .clickable { }
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$${shoes.price}", fontFamily = PoppinsFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_add_circle_outline_24),
                        contentDescription = "add goods",
                        modifier = Modifier
                            .size(18.dp)
                            .clickable { }
                    )
                }
            }
        }
    }
}
