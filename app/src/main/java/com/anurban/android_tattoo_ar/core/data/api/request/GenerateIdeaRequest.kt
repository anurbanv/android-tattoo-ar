package com.anurban.android_tattoo_ar.core.data.api.request

import com.google.gson.annotations.SerializedName

data class GenerateIdeaRequest(
    @SerializedName("style") val style: Int,
    @SerializedName("description") val description: String,
)
