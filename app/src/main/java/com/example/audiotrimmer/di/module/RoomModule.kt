package com.example.audiotrimmer.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.audiotrimmer.Constant.RoomConstants
import com.example.audiotrimmer.data.RepoImpl.RecentRepositoryImpl
import com.example.audiotrimmer.data.room.database.AppDataBase
import com.example.audiotrimmer.domain.Repository.RecentRepository
import com.example.audiotrimmer.domain.UseCases.recent.DeleteRecentCroppedSegmentUseCase
import com.example.audiotrimmer.domain.UseCases.recent.DeleteRecentEntryUseCase
import com.example.audiotrimmer.domain.UseCases.recent.GetAllRecentEntriesUseCase
import com.example.audiotrimmer.domain.UseCases.recent.GetCropSegmentsByFileNameUseCase
import com.example.audiotrimmer.domain.UseCases.recent.GetRecentCropByFileTypeUseCase
import com.example.audiotrimmer.domain.UseCases.recent.GetRecentCroppedSegmentFilesUseCase
import com.example.audiotrimmer.domain.UseCases.recent.GetRecentEntriesByDateModifiedAscUseCase
import com.example.audiotrimmer.domain.UseCases.recent.GetRecentEntriesByDateModifiedDescUseCase
import com.example.audiotrimmer.domain.UseCases.recent.GetRecentEntriesByFeatureTypeUseCase
import com.example.audiotrimmer.domain.UseCases.recent.GetRecentEntriesByInputNameAscUseCase
import com.example.audiotrimmer.domain.UseCases.recent.GetRecentEntriesByInputNameDescUseCase
import com.example.audiotrimmer.domain.UseCases.recent.GetRecentEntriesByOutputNameAscUseCase
import com.example.audiotrimmer.domain.UseCases.recent.GetRecentEntriesByOutputNameDescUseCase
import com.example.audiotrimmer.domain.UseCases.recent.UpsertCropSegmentUseCase
import com.example.audiotrimmer.domain.UseCases.recent.UpsertRecentEntryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideRoomDataBase(@ApplicationContext context: Context): RoomDatabase{
        return Room.databaseBuilder(
            context = context ,
            klass =  AppDataBase::class.java, name = "${RoomConstants.APP_ROOM_DATA_BASE_NAME}",
        ).fallbackToDestructiveMigration().build()
    }
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDataBase{
        return Room.databaseBuilder(
            context = context ,
            klass =  AppDataBase::class.java, name = "${RoomConstants.APP_ROOM_DATA_BASE_NAME}",
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideRecentRepository(appDataBase: AppDataBase): RecentRepository {
        return RecentRepositoryImpl(appDataBase = appDataBase)
    }

    @Provides
    fun provideGetAllRecentEntriesUseCase(repository: RecentRepository): GetAllRecentEntriesUseCase {
        return GetAllRecentEntriesUseCase(repository = repository)
    }

    @Provides
    fun provideUpsertRecentEntryUseCase(repository: RecentRepository): UpsertRecentEntryUseCase {
        return UpsertRecentEntryUseCase(repository = repository)
    }

    @Provides
    fun provideDeleteRecentEntryUseCase(repository: RecentRepository): DeleteRecentEntryUseCase {
        return DeleteRecentEntryUseCase(repository = repository)
    }

    @Provides
    fun provideGetRecentEntriesByFeatureTypeUseCase(repository: RecentRepository): GetRecentEntriesByFeatureTypeUseCase {
        return GetRecentEntriesByFeatureTypeUseCase(repository = repository)
    }

    @Provides
    fun provideGetRecentEntriesByDateModifiedAscUseCase(repository: RecentRepository): GetRecentEntriesByDateModifiedAscUseCase {
        return GetRecentEntriesByDateModifiedAscUseCase(repository = repository)
    }

    @Provides
    fun provideGetRecentEntriesByDateModifiedDescUseCase(repository: RecentRepository): GetRecentEntriesByDateModifiedDescUseCase {
        return GetRecentEntriesByDateModifiedDescUseCase(repository = repository)
    }

    @Provides
    fun provideGetRecentEntriesByOutputNameAscUseCase(repository: RecentRepository): GetRecentEntriesByOutputNameAscUseCase {
        return GetRecentEntriesByOutputNameAscUseCase(repository = repository)
    }

    @Provides
    fun provideGetRecentEntriesByOutputNameDescUseCase(repository: RecentRepository): GetRecentEntriesByOutputNameDescUseCase {
        return GetRecentEntriesByOutputNameDescUseCase(repository = repository)
    }

    @Provides
    fun provideGetRecentEntriesByInputNameAscUseCase(repository: RecentRepository): GetRecentEntriesByInputNameAscUseCase {
        return GetRecentEntriesByInputNameAscUseCase(repository = repository)
    }

    @Provides
    fun provideGetRecentEntriesByInputNameDescUseCase(repository: RecentRepository): GetRecentEntriesByInputNameDescUseCase {
        return GetRecentEntriesByInputNameDescUseCase(repository = repository)
    }

    @Provides
    fun provideUpsertCropSegmentUseCase(repository: RecentRepository): UpsertCropSegmentUseCase {
        return UpsertCropSegmentUseCase(repository = repository)
    }

    @Provides
    fun provideGetRecentCroppedSegmentFilesUseCase(repository: RecentRepository): GetRecentCroppedSegmentFilesUseCase {
        return GetRecentCroppedSegmentFilesUseCase(repository = repository)
    }

    @Provides
    fun provideGetRecentCropByFileTypeUseCase(repository: RecentRepository): GetRecentCropByFileTypeUseCase {
        return GetRecentCropByFileTypeUseCase(repository = repository)
    }

    @Provides
    fun provideGetCropSegmentsByFileNameUseCase(repository: RecentRepository): GetCropSegmentsByFileNameUseCase {
        return GetCropSegmentsByFileNameUseCase(repository = repository)
    }

    @Provides
    fun provideDeleteRecentCroppedSegmentUseCase(repository: RecentRepository): DeleteRecentCroppedSegmentUseCase {
        return DeleteRecentCroppedSegmentUseCase(repository = repository)
    }
}