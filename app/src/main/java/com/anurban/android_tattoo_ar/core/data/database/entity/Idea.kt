package com.anurban.android_tattoo_ar.core.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Idea(
    @PrimaryKey var id: Int = 0,
    @ColumnInfo(name = "style") val style: Int = 0,
    @ColumnInfo(name = "description") val description: String = "",
    @ColumnInfo(name = "image_url") val imageUrl: String = "",
)
