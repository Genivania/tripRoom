package br.senai.sp.jandira.triproom.gui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.componentes.BottomShape
import br.senai.sp.jandira.triproom.componentes.TopShape
import br.senai.sp.jandira.triproom.ui.theme.TriproomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriproomTheme {
                TripRoomScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TripRoomScreen() {

    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TopShape()
            }// primeira row
            Column(
                modifier = Modifier
                    .width(200.dp)
                    .padding(17.dp),
            ) {
                Text(
                    text = stringResource(id = br.senai.sp.jandira.triproom.R.string.login),
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(207, 6, 240)
                )
                Text(
                    text = stringResource(id = br.senai.sp.jandira.triproom.R.string.please_sign),
                    fontSize = 14.sp,
                    color = Color(160, 156, 156)
                )
            }
            Column(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(17.dp),
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(370.dp),
                    label =
                    {
                        Text(text = stringResource(id = br.senai.sp.jandira.triproom.R.string.email))
                    },
                    shape = RoundedCornerShape(16.dp),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = br.senai.sp.jandira.triproom.R.drawable.email),
                            contentDescription = stringResource(
                                id = br.senai.sp.jandira.triproom.R.string.email
                            ),
                            tint = Color(207, 6, 240)
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(207, 6, 240),
                        unfocusedBorderColor = Color(207, 6, 240)
                    )
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(370.dp)
                        .padding(top = 31.dp),
                    label =
                    {
                        Text(text = stringResource(id = br.senai.sp.jandira.triproom.R.string.password))
                    },
                    shape = RoundedCornerShape(16.dp),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = br.senai.sp.jandira.triproom.R.drawable.lock),
                            contentDescription = stringResource(
                                id = br.senai.sp.jandira.triproom.R.string.password
                            ),
                            tint = Color(207, 6, 240)
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(207, 6, 240),
                        unfocusedBorderColor = Color(207, 6, 240)
                    )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.End
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(134.dp)
                        .height(48.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(Color(207, 6, 240))
                ) {
                    Row() {
                        Text(
                            text = stringResource(id = br.senai.sp.jandira.triproom.R.string.sign_in).uppercase(),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Icon(
                            painter = painterResource(id = br.senai.sp.jandira.triproom.R.drawable.email),
                            contentDescription = stringResource(id = br.senai.sp.jandira.triproom.R.string.email),
                            tint = Color.White
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(15.dp))
                Row(

                ) {
                    Text(
                        text = stringResource(id = br.senai.sp.jandira.triproom.R.string.email),
                        color = Color(160, 156, 156),
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(
                        text = stringResource(id = br.senai.sp.jandira.triproom.R.string.sign_up),
                        modifier = Modifier.clickable {
                            val intent = Intent(context, SignUpActivity::class.java)
                            context.startActivity(intent)
                        },
                        color = Color(207, 6, 240),
                        fontWeight = FontWeight.Bold,
                    )
                }
            } // button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                BottomShape()
            }
        } // principal
    }// surface
}