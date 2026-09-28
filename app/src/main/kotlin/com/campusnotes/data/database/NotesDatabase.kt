package com.campusnotes.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.campusnotes.data.dao.NoteDao
import com.campusnotes.data.dao.UnitDao
import com.campusnotes.model.Note
import com.campusnotes.model.Unit

@Database(entities = [Unit::class, Note::class], version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun unitDao(): UnitDao
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NotesDatabase? = null

        fun getDatabase(context: Context): NotesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDatabase::class.java,
                    "campus_notes_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
