package com.anurban.android_tattoo_ar.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anurban.android_tattoo_ar.core.data.database.dao.IdeaDao
import com.anurban.android_tattoo_ar.core.data.database.entity.Idea

@Database(entities = [Idea::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun ideaDao(): IdeaDao
}
