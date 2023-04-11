package br.senai.sp.jandira.triproom.gui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.triproom.componentes.BottomShape
import br.senai.sp.jandira.triproom.componentes.TopShape
import br.senai.sp.jandira.triproom.model.User
import br.senai.sp.jandira.triproom.repository.UserRepository
import br.senai.sp.jandira.triproom.ui.theme.TriproomTheme
import kotlin.math.log

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            TriproomTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth()
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

    var userNameState by remember {
        mutableStateOf("")
    }

    var phoneState by remember {
        mutableStateOf("")
    }

    var emailState by remember {
        mutableStateOf("")
    }
    var passwordState by remember {
        mutableStateOf("")
    }
    var overState by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current

    var scrollState = rememberScrollState()

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
                        value = userNameState,
                        onValueChange = { userNameState = it },
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
                        value = phoneState,
                        onValueChange = { phoneState = it },
                        modifier = Modifier
                            .width(370.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
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
                        value = emailState,
                        onValueChange = {
                            emailState = it
                        },
                        modifier = Modifier
                            .width(370.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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
                        value = passwordState,
                        onValueChange = { passwordState = it },
                        modifier = Modifier
                            .width(370.dp),
                        label =
                        {
                            Text(text = stringResource(id = R.string.password))
                        },
                        shape = RoundedCornerShape(16.dp),
                        visualTransformation = PasswordVisualTransformation(),
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

                Checkbox(checked = overState, onCheckedChange = {overState = it})
                Text(text = stringResource(id = R.string.over_18))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(17.dp),
            ) {

                //--------------------------

                Button(
                    onClick = {
                        saveUser(
                            userNameState,
                            phoneState,
                            emailState,
                            passwordState,
                            overState,
                            context
                        )
                    },
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

fun saveUser(
    userName: String,
    phone: String,
    email: String,
    password: String,
    isOver18: Boolean,
    context: Context
) {

    val newUser = User(
        id = 0,
        userName = userName,
        phone = phone,
        email = email,
        password = password,
        isOver18 = isOver18
    )

    //Criando uma instancia do repositorio
    val userRepository = UserRepository(context)


    //Verificar se o usuario já existe
    val user = userRepository.findUserByEmail(email)
    Log.i(
        "DS2m", "${user.toString()}"
    )

    //Salvar o usuário
    if( user == null){
        val id = userRepository.save(newUser)
        Toast.makeText(
            context,
            "Created User #$id",
            Toast.LENGTH_LONG
        ).show()
    } else {
        val id = userRepository.save(newUser)
        Toast.makeText(
            context,
            "User already exists!",
            Toast.LENGTH_LONG
        ).show()
    }


}


