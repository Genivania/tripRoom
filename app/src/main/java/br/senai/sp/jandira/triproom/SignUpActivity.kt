package br.senai.sp.jandira.triproom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.ui.theme.TriproomTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriproomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//////
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TriproomTheme {
        Greeting("Android")
    }
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {

            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {

                    Card(
                        modifier = Modifier
                            .width(150.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(
                            0.dp, 0.dp, 0.dp, 20.dp
                        ),
                        backgroundColor = Color(
                            red = 207,
                            green = 6,
                            blue = 240
                        )
                    ) {

                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 120.dp, start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.sign_up),
                        fontSize = 54.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(
                            red = 207,
                            green = 6,
                            blue = 240
                        )
                    )
                    Text(
                        text = stringResource(id = R.string.create_new),
                        fontSize = 16.sp,
                        color = Color(
                            red = 160,
                            green = 156,
                            blue = 156
                        )
                    )

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = {
                            Text(
                                text = stringResource(id = R.string.email)
                            )
                        },
                        modifier = Modifier
                            .padding(top = 80.dp)
                            .width(360.dp),
                        shape = RoundedCornerShape(16.dp)
                    )

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = {
                            Text(
                                text = stringResource(id = R.string.password)
                            )
                        },
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .width(360.dp),
                        shape = RoundedCornerShape(16.dp)
                    )
                }
            }

        }

    }
}