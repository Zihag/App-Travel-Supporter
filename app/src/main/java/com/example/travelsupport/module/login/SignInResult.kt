package com.example.signinsignup

class SignInResult(
    val data: com.example.signinsignup.UserData?,
    val errorMessage: String?
)
data class UserData(
    val userID: String,
    val username: String?,
    val profilePictureUrl: String?
)