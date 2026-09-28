package com.campusnotes.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.campusnotes.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note: Note): Long

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM notes WHERE unitId = :unitId ORDER BY createdAt DESC")
    fun getNotesByUnit(unitId: Int): Flow<List<Note>>

    @Query("SELECT * FROM notes WHERE unitId = :unitId AND year = :year ORDER BY createdAt DESC")
    fun getNotesByUnitAndYear(unitId: Int, year: Int): Flow<List<Note>>

    @Query("SELECT * FROM notes WHERE id = :noteId")
    suspend fun getNoteById(noteId: Int): Note

    @Query("SELECT * FROM notes WHERE title LIKE '%' || :searchQuery || '%' OR content LIKE '%' || :searchQuery || '%' ORDER BY createdAt DESC")
    fun searchNotes(searchQuery: String): Flow<List<Note>>
}
