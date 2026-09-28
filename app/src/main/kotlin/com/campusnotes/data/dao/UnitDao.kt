package com.campusnotes.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.campusnotes.model.Unit
import kotlinx.coroutines.flow.Flow

@Dao
interface UnitDao {
    @Insert
    suspend fun insertUnit(unit: Unit): Long

    @Update
    suspend fun updateUnit(unit: Unit)

    @Delete
    suspend fun deleteUnit(unit: Unit)

    @Query("SELECT * FROM units ORDER BY createdAt DESC")
    fun getAllUnits(): Flow<List<Unit>>

    @Query("SELECT * FROM units WHERE id = :unitId")
    suspend fun getUnitById(unitId: Int): Unit

    @Query("SELECT * FROM units WHERE name LIKE '%' || :searchQuery || '%'")
    fun searchUnits(searchQuery: String): Flow<List<Unit>>
}
