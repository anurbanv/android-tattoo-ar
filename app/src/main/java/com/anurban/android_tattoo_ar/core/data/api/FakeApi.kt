package com.anurban.android_tattoo_ar.core.data.api

import com.anurban.android_tattoo_ar.core.data.api.request.GenerateIdeaRequest
import com.anurban.android_tattoo_ar.core.data.api.response.GenerateIdeaResponse
import retrofit2.Response

object FakeApi {

    fun generateIdeaSuccess(request: GenerateIdeaRequest): Response<GenerateIdeaResponse> {
        return Response.success(GenerateIdeaResponse(
            imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F574068283723416708%2F&psig=AOvVaw2YXZ-P5opDJ1CDU_2JBWQw&ust=1680206080396000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCLDyusb1gf4CFQAAAAAdAAAAABAE"
        ))
    }
}
