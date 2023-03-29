package com.anurban.android_tattoo_ar.core.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.anurban.android_tattoo_ar.core.data.database.entity.Idea

@Dao
interface IdeaDao {
    @Insert
    fun insert(idea: Idea)

    @Delete
    fun delete(idea: Idea)
}
