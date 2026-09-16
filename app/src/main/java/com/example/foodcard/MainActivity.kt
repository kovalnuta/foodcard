package com.example.foodcard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodcard.ui.theme.FoodcardTheme
import com.example.foodcard.ui.theme.PizzaBackgroundDark
import com.example.foodcard.ui.theme.PizzaGrayTextDark
import com.example.foodcard.ui.theme.PizzaGrayTextLight
import com.example.foodcard.ui.theme.PizzaStarDark
import com.example.foodcard.ui.theme.PizzaStarLight
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodcardTheme {
                PizzaPepperoniCard()
            }
        }
    }
}
@Preview
@Composable
fun PizzaPepperoniCard() {
    val isDark = MaterialTheme.colorScheme.background == PizzaBackgroundDark
    val grayText = if (isDark) PizzaGrayTextDark else PizzaGrayTextLight
    val starColor = if (isDark) PizzaStarDark else PizzaStarLight
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.pizza),
                contentDescription = "Пицца Пепперони",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            IconButton(
                onClick = { },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Назад",
                    tint = Color.White
                )
            }
            IconButton(
                onClick = { },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Избранное",
                    tint = Color.White
                )
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp, top = 16.dp, start = 16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Пицца Пепперони",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(8.dp))
                // Рейтинг
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "★★★★★",
                        fontSize = 16.sp,
                        color = starColor
                    )
                    Text(
                        text = "  4.8  (128 отзывов)",
                        fontSize = 14.sp,
                        color = grayText
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Сложность",
                            fontSize = 12.sp,
                            color = grayText
                        )
                        Text(
                            text = "Средняя",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Column {
                        Text(
                            text = "Время",
                            fontSize = 12.sp,
                            color = grayText
                        )
                        Text(
                            text = "35 мин",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Описание",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Классическая итальянская пицца с пикантной пепперони, моцареллой и томатным соусом.",
                    fontSize = 14.sp,
                    color =  grayText
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Состав",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "• Пепперони\n• Моцарелла\n• Томатный соус\n• Тесто",
                    fontSize = 14.sp,
                    color = grayText
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Отзывы",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(8.dp))
                ReviewItem(
                    name = "Анна Коваленко",
                    text = "Лучшая пицца! Пепперони очень вкусная.",
                    time = "2 дня назад",
                    grayText = grayText
                )

                Spacer(modifier = Modifier.height(8.dp))

                ReviewItem(
                    name = "Иван Сидоров",
                    text = "Отличная пицца, рекомендую!",
                    time = "1 неделю назад",
                    grayText = grayText
                )
            }
        }
    }
}

@Composable
fun ReviewItem(name: String, text: String, time: String, grayText : Color) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = text,
            fontSize = 13.sp,
            color = grayText
        )
        Text(
            text = time,
            fontSize = 11.sp,
            color = grayText
        )
    }
}