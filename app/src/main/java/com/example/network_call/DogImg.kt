package com.example.network_call
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class DogImg(
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: String?
): Serializable