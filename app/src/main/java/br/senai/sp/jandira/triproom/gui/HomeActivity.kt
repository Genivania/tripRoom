package br.senai.sp.jandira.triproom.gui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.triproom.model.Category
import br.senai.sp.jandira.triproom.repository.CategoryRepository
import br.senai.sp.jandira.triproom.ui.theme.TriproomTheme

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriproomTheme {
                Surface() {
                    HomeScreen(CategoryRepository.getCategories())
                }
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true )
@Composable

fun HomeScreen(categories: List<Category>) {

    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)


        ) {
            Image(
                painter = painterResource(id = br.senai.sp.jandira.triproom.R.drawable.rectangle17),
                contentDescription = "Logo",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = stringResource(id = R.string.categories),
            color = Color(56, 54, 54),
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
        LazyRow() {
            items(categories) {
                Card(
                    modifier = Modifier
                        .size(width = 109.dp, height = 94.dp)
                        .padding(vertical = 8.dp, horizontal = 4.dp),
                    backgroundColor = Color(207, 6, 240)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = it.categoryIcon,
                            contentDescription = it.categoryName
                        )
                        Text(
                            text = "${it.categoryName}",
                            color = Color.White
                        )
                    }

                }
            }
        }
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            placeholder = {
                Text(text = stringResource(id = R.string.searchYourDestinity))
            },
            trailingIcon ={
                IconButton(
                    onClick = {}
                ) {
                    Icon(imageVector = Icons.Default.Search,
                        contentDescription = "")
                }
            }
        )
    }
}

