package com.example.nyc.schools.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchoolInformation(
        schoolInformationEntities: List<SchoolInformationEntity>
    )

    @Query("DELETE FROM schoolinformationentity")
    suspend fun clearSchoolInformation()

    @Query(
        """
        SELECT * FROM schoolinformationentity
        WHERE LOWER(name) LIKE '%' || LOWER(:query)
        """
    )
    suspend fun searchSchoolInformation(query: String): List<SchoolInformationEntity>
}