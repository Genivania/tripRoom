package br.senai.sp.jandira.triproom.gui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.triproom.componentes.BottomShape
import br.senai.sp.jandira.triproom.componentes.TopShape
import br.senai.sp.jandira.triproom.model.User
import br.senai.sp.jandira.triproom.repository.UserRepository
import br.senai.sp.jandira.triproom.ui.theme.TriproomTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val user = User(
            userName = "Maria da Silva",
            email = "maria@terra.com.br",
            password = "123456",
            phone = "(11)99999-9999",
            isOver18 = true
        )

        val userRep =UserRepository(this)
        var id = userRep.save(user)

        Toast.makeText(
            this,
            "$id",
            Toast.LENGTH_LONG)
            .show()

        setContent {
            TriproomTheme {
                Surface(modifier = Modifier.fillMaxWidth()
                ) {

                }
                SignUpScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreen() {
    var scrollState = rememberScrollState()
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
                    .fillMaxWidth()
                    .padding(17.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.sign_up),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(207, 6, 240)
                )
                Text(
                    text = stringResource(id = R.string.create_new),
                    fontSize = 14.sp,
                    color = Color(160, 156, 156)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Box(

                ) {
                    Card(
                        modifier = Modifier
                            .size(100.dp),
                        shape = CircleShape,
                        backgroundColor = Color(232, 232, 232, 255)
                    )
                    {
                        Image(
                            painter = painterResource(
                                id = R.drawable.profile
                            ),
                            contentDescription = null
                        )

                    }
                    Image(
                        painter = painterResource(
                            id = R.drawable.baseline_add_a_photo_24
                        ),
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.BottomEnd)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .height(height = 290.dp)
            ) {

                Column(
                    modifier = Modifier
                        .height(300.dp)
                        .fillMaxWidth()
                        .padding(17.dp)
                ) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .width(370.dp),
                        label =
                        {
                            Text(text = stringResource(id = R.string.username))
                        },
                        shape = RoundedCornerShape(16.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.person),
                                contentDescription = stringResource(
                                    id = R.string.username
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
                            .width(370.dp),
                        label =
                        {
                            Text(text = stringResource(id = R.string.phone))
                        },
                        shape = RoundedCornerShape(16.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.phone),
                                contentDescription = stringResource(
                                    id = R.string.phone
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
                            .width(370.dp),
                        label =
                        {
                            Text(text = stringResource(id = R.string.email))
                        },
                        shape = RoundedCornerShape(16.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.email),
                                contentDescription = stringResource(
                                    id = R.string.email
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
                            .width(370.dp),
                        label =
                        {
                            Text(text = stringResource(id = R.string.password))
                        },
                        shape = RoundedCornerShape(16.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.lock),
                                contentDescription = stringResource(
                                    id = R.string.password
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
            }
            // textFields
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Checkbox(checked = false, onCheckedChange = {})
                Text(text = stringResource(id = R.string.over_18))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(17.dp),
            ) {

                //--------------------------

                Button(
                    onClick = {/*TODO*/ },
                    modifier = Modifier
                        .height(48.dp)
                        .width(370.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(Color(207, 1, 240)),

                    ) {
                    Text(
                        text = stringResource(
                            id = R.string.create_account
                        ).uppercase(),
                        fontWeight = FontWeight(800),
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(17.dp),
                horizontalArrangement = Arrangement.End,
            ) {
                Text(
                    text = stringResource(id = R.string.already_have_an_account),
                    color = Color(160, 156, 156)
                )
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    modifier = Modifier.clickable {
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)

                    },
                    text = stringResource(id = R.string.sign_ini),
                    color = Color(207, 1, 240),
                    fontWeight = FontWeight(800)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                BottomShape()
            }
        }// 1 column
    }// surface
}// SignUpScreen()