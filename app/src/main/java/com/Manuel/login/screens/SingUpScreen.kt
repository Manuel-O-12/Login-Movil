package com.Manuel.login.screens

import android.R.attr.enabled
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.enableLiveLiterals
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SingUpScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    var nameError by remember { mutableStateOf(false) }
    var mailError by remember{mutableStateOf(false)}
    var phoneError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    var confirmPasswordError by remember { mutableStateOf(false) }


    fun isValidateName (name: String): Boolean{
        return name.matches(Regex ("^[a-zA-Z ]+$"))
    }

    fun isValidateEmail (email: String): Boolean{
        return  android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidatePhone (phone: String): Boolean{
        return phone.matches(Regex("^[0-9]{10}$"))
    }

    fun isValidatePassword (password: String): Boolean{
        return password.length >= 8
    }

    fun isMatchPassword(): Boolean{
        return password == confirmPassword && password.isNotEmpty()
    }

    val isFormValidate = remember(name,email,phone,password,confirmPassword) {
        isValidateName(name) &&
                isValidateEmail(email) &&
                isValidatePhone(phone) &&
                isValidatePassword(password) &&
                isMatchPassword()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E5BB2)),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .background(Color.White)
                .padding(24.dp)
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Create account",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(30.dp))

                TextField(
                    value = name,
                    onValueChange =
                        {
                        name = it
                        nameError = !isValidateName(it)
                        },
                    label = {Text("name")},
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,

                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                    ),
                    isError = nameError,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    )

                )

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    value = email,
                    onValueChange = {
                        email = it
                        mailError = !isValidateEmail(it)},
                    label = {Text("email")},
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,

                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                    ),
                    isError = mailError,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )

                )

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    value = phone,
                    onValueChange =
                        {
                            phone = it
                            phoneError = !isValidatePhone(it)
                        },
                    label = {Text("phone Number")},
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,

                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                    ),
                    isError = phoneError,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )

                )

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    value = password,
                    onValueChange =
                        {
                        password = it
                            passwordError = !isValidatePassword(it) && it.isNotEmpty()
                            if (confirmPassword.isNotEmpty()){
                                confirmPasswordError = !isMatchPassword()
                            }
                        },
                    label = {Text("password")},
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,

                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    isError = passwordError,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    )

                )

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    value = confirmPassword,
                    onValueChange =
                        {
                            confirmPassword = it
                            confirmPasswordError = !isMatchPassword() && it.isNotEmpty()
                        },
                    label = {Text("confirmPassword")},
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,

                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    isError = confirmPasswordError,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    )

                )

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = { navController.navigate("Login") },
                    enabled = isFormValidate,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .clip(RoundedCornerShape(25.dp)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(25.dp)
                ){
                    //Text("Sing Up")
                    Text(
                        text = "Login",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }



                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { navController.navigate("Welcome") },

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .clip(RoundedCornerShape(25.dp)),
                    shape = RoundedCornerShape(25.dp)
                )
                {
                    Text("Return")
                }

            }

        }
    }
}
