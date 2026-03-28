package com.example.audiotrimmer.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.audiotrimmer.Constant.RoomConstants
import com.example.audiotrimmer.data.room.entity.CropSegmentTable
import kotlinx.coroutines.flow.Flow

@Dao
interface CropSegmentDao {
    @Upsert
    fun upsertCropSegment(cropSegmentTable: CropSegmentTable)

    @Query("SELECT DISTINCT fileName FROM ${RoomConstants.CROP_SEGMENT_TABLE_NAME}")
    fun getRecentCroppedSegmentFiles(): Flow<List<String>>

    @Query("SELECT * FROM ${RoomConstants.CROP_SEGMENT_TABLE_NAME} WHERE fileType = :fileType")
    fun getRecentCropByFileType(fileType: String): Flow<List<CropSegmentTable>>

    @Query("SELECT * FROM ${RoomConstants.CROP_SEGMENT_TABLE_NAME} WHERE fileName = :fileName")
    fun getCropSegmentsByFileName(fileName: String): Flow<List<CropSegmentTable>>

    @Delete
    fun deleteRecentCroppedSegment(cropSegmentTable: CropSegmentTable)


}