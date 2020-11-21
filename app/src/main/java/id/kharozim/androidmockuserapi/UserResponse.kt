package id.kharozim.androidmockuserapi

import com.google.gson.annotations.SerializedName
import id.kharozim.androidmockuserapi.model.ResponseModel

data class UserResponse(

    @field:SerializedName("results")
    val results: List<ResponseModel>,

    )