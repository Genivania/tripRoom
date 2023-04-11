package br.senai.sp.jandira.triproom.gui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.triproom.ui.theme.TriproomTheme

class MyTripsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriproomTheme {
                myTripsScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun myTripsScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {

            Card(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.rectangle17),
                    contentDescription = "Paris",
                    modifier = Modifier.fillMaxWidth()
                )
                Column(modifier = Modifier.fillMaxHeight()) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(13.dp), horizontalAlignment = Alignment.End
                    ) {
                        Card(shape = CircleShape, border = BorderStroke(2.dp, Color.White)) {
                            Image(
                                painter = painterResource(id = R.drawable.eclipse1),
                                contentDescription = "",
                                Modifier.width(61.dp)
                            )
                        }
                        Column(Modifier.fillMaxSize()) {
                            Text(text = "You're in Paris", color = Color.White)
                            Text(
                                text = "My Trips",
                                color = Color.White,
                                fontWeight = FontWeight(900),
                                fontSize = 32.sp
                            )
                        }

                    }
                }
            }
        }

    }
}
