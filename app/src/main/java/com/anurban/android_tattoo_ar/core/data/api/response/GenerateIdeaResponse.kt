package com.anurban.android_tattoo_ar.core.data.api.response

import com.google.gson.annotations.SerializedName

data class GenerateIdeaResponse(
    @SerializedName("image_url") val imageUrl: String,
)
