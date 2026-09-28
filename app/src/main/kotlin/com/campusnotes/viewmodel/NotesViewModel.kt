package com.campusnotes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.campusnotes.data.database.NotesDatabase
import com.campusnotes.model.Note
import com.campusnotes.model.Unit
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    private val unitDao = NotesDatabase.getDatabase(application).unitDao()
    private val noteDao = NotesDatabase.getDatabase(application).noteDao()

    val allUnits: LiveData<List<Unit>> = unitDao.getAllUnits().asLiveData()

    fun addUnit(unitName: String, description: String = "") {
        viewModelScope.launch {
            val unit = Unit(name = unitName, description = description)
            unitDao.insertUnit(unit)
        }
    }

    fun updateUnit(unit: Unit) {
        viewModelScope.launch {
            unitDao.updateUnit(unit)
        }
    }

    fun deleteUnit(unit: Unit) {
        viewModelScope.launch {
            unitDao.deleteUnit(unit)
        }
    }

    fun searchUnits(query: String): LiveData<List<Unit>> =
        unitDao.searchUnits(query).asLiveData()

    fun getNotesByUnit(unitId: Int): LiveData<List<Note>> =
        noteDao.getNotesByUnit(unitId).asLiveData()

    fun getNotesByUnitAndYear(unitId: Int, year: Int): LiveData<List<Note>> =
        noteDao.getNotesByUnitAndYear(unitId, year).asLiveData()

    fun addNote(unitId: Int, title: String, content: String, year: Int) {
        viewModelScope.launch {
            val note = Note(
                unitId = unitId,
                title = title,
                content = content,
                year = year
            )
            noteDao.insertNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            noteDao.updateNote(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            noteDao.deleteNote(note)
        }
    }

    fun searchNotes(query: String): LiveData<List<Note>> =
        noteDao.searchNotes(query).asLiveData()
}
