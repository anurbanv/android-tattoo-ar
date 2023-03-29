package com.anurban.android_tattoo_ar.core.data.api

import com.anurban.android_tattoo_ar.core.data.api.request.GenerateIdeaRequest
import com.anurban.android_tattoo_ar.core.data.api.response.GenerateIdeaResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface AppApi {

    @GET("idea/generate")
    suspend fun generateIdea(@Body request: GenerateIdeaRequest): Response<GenerateIdeaResponse>
}
