package com.example.buildwithaiandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buildwithaiandroid.ui.theme.AndroidTheme
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidTheme {
                MyApp()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyApp() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        //display the posts
        listOfPosts.forEach { post ->
            Card {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = post.title,
                            style = TextStyle(fontSize = 20.sp, color = Color.Blue)
                        )
                        Text(text = post.desc)
                    }
                    Image(
                        painter = painterResource(id = post.image),
                        contentDescription = "",
                        modifier = Modifier.clip(RectangleShape)
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

//data class is like a data holder
data class MyPost(
    val title: String,
    val desc: String,
    val image: Int
)

val listOfPosts = listOf(
    MyPost("A random post of an image", "A random desc of an immage", R.drawable.bird_image),
    MyPost("A random post of an image", "A random desc of an immage", R.drawable.twitter_post_1),
    MyPost("A random post of an image", "A random desc of an immage", R.drawable.bird_image),
    MyPost("A random post of an image", "A random desc of an immage", R.drawable.twitter_post_1),
    MyPost("A random post of an image", "A random desc of an immage", R.drawable.bird_image),
    MyPost("A random post of an image", "A random desc of an immage", R.drawable.bird_image),
    MyPost("A random post of an image", "A random desc of an immage", R.drawable.twitter_post_1),
)


