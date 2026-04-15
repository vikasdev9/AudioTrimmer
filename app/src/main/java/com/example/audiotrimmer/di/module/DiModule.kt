package com.example.audiotrimmer.di.module

import android.content.Context
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import com.example.audiotrimmer.core.MediaPlayerManager
import com.example.audiotrimmer.data.RepoImpl.AdsRepositoryImpl
import com.example.audiotrimmer.data.RepoImpl.AudioTimmerRepoImpl
import com.example.audiotrimmer.data.RepoImpl.ConvertAudioFormatRepoImpl
import com.example.audiotrimmer.data.RepoImpl.GetAllSongsRepoImpl
import com.example.audiotrimmer.data.RepoImpl.MultiCropAudioRepoImpl
import com.example.audiotrimmer.data.RepoImpl.MultiCropVideoRepoImpl
import com.example.audiotrimmer.data.RepoImpl.RecordAudioRepoImpl
import com.example.audiotrimmer.data.RepoImpl.VideoRepImpl
import com.example.audiotrimmer.data.RepoImpl.VideoSpeedRepoImpl
import com.example.audiotrimmer.domain.Repository.AdsRepository
import com.example.audiotrimmer.domain.Repository.AudioTrimmerRepository
import com.example.audiotrimmer.domain.Repository.ConvertAudioFormatRepository
import com.example.audiotrimmer.domain.Repository.GetAllSongRepository
import com.example.audiotrimmer.domain.Repository.MultiCropAudioRepository
import com.example.audiotrimmer.domain.Repository.MultiCropVideoRepository
import com.example.audiotrimmer.domain.Repository.RecordAudioRepository
import com.example.audiotrimmer.domain.Repository.VideoRepository
import com.example.audiotrimmer.domain.Repository.VideoSpeedRepository
import com.example.audiotrimmer.domain.UseCases.ChangeVideoSpeedUseCase
import com.example.audiotrimmer.domain.UseCases.ConvertAudioFormatUseCase
import com.example.audiotrimmer.domain.UseCases.GetAllSongsForMergeUseCase
import com.example.audiotrimmer.domain.UseCases.GetAllVideoUseCase
import com.example.audiotrimmer.domain.UseCases.LoadAdUseCase
import com.example.audiotrimmer.domain.UseCases.MergeSongsUseCase
import com.example.audiotrimmer.domain.UseCases.MultiCropAudioUseCase
import com.example.audiotrimmer.domain.UseCases.MultiCropVideoUseCase
import com.example.audiotrimmer.domain.UseCases.RecordAudioUseCase
import com.example.audiotrimmer.domain.UseCases.ShowAdUseCase
import com.example.audiotrimmer.domain.UseCases.TrimAudioUseCase
import com.example.audiotrimmer.domain.UseCases.TrimVideoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule {
    @Provides
    fun provideExoplayer(@ApplicationContext context: Context): ExoPlayer {
        return ExoPlayer.Builder(context).build()

    }

    @UnstableApi
    @Provides
    fun provideAudioTrimmerRepositoryObj(@ApplicationContext context: Context): AudioTrimmerRepository {
        return AudioTimmerRepoImpl()
    }

    @Provides
    fun provideAudioTrimmerUseCaseObj(repository: AudioTrimmerRepository): TrimAudioUseCase {
        return TrimAudioUseCase(repository = repository)

    }

    @UnstableApi
    @Provides
    fun provideGetAllSongUseCaseObj(@ApplicationContext context: Context): GetAllSongRepository {
        return GetAllSongsRepoImpl(context = context)

    }

    @Provides
    fun provideMediaPlayerManager(exoPlayer: ExoPlayer): MediaPlayerManager {
        return MediaPlayerManager(exoPlayer = exoPlayer)
    }

    @UnstableApi
    @Provides
    fun provideVideoRepo(@ApplicationContext context: Context): VideoRepository {
        return VideoRepImpl(context = context)
    }

    @UnstableApi
    @Provides
    fun provideVideoSpeedRepo(@ApplicationContext context: Context): VideoSpeedRepository {
        return VideoSpeedRepoImpl(context = context)
    }

    @Provides
    fun provideChangeVideoSpeedUseCase(repository: VideoSpeedRepository): ChangeVideoSpeedUseCase {
        return ChangeVideoSpeedUseCase(repository = repository)
    }

    @Provides
    fun provideGetAllVideoUseCase(videoRepository: VideoRepository): GetAllVideoUseCase {
        return GetAllVideoUseCase(repository = videoRepository)
    }

    @Provides
    fun provideTrimVideoUseCase(videoRepository: VideoRepository): TrimVideoUseCase {
        return TrimVideoUseCase(repository = videoRepository)
    }

    @Provides
    fun provideGetAllSongsForMergeUseCase(repository: GetAllSongRepository): GetAllSongsForMergeUseCase {
        return GetAllSongsForMergeUseCase(getAllSongRepository = repository)
    }

    @Provides
    fun provideMergeSongsUseCase(repository: GetAllSongRepository): MergeSongsUseCase {
        return MergeSongsUseCase(repository = repository)
    }

    @Provides
    @Singleton
    fun provideAdsRepository(@ApplicationContext context: Context): AdsRepository {
        return AdsRepositoryImpl(context = context)
    }

    @Provides
    fun provideLoadAdUseCase(repository: AdsRepository): LoadAdUseCase {
        return LoadAdUseCase(repository = repository)
    }

    @Provides
    fun provideShowAdUseCase(repository: AdsRepository): ShowAdUseCase {
        return ShowAdUseCase(repository = repository)
    }

    @UnstableApi
    @Provides
    fun provideMultiCropRepo(@ApplicationContext context: Context): MultiCropAudioRepository {
        return MultiCropAudioRepoImpl(context = context)
    }

    @UnstableApi
    @Provides
    fun provideMultiCropAudioUseCase(repository: MultiCropAudioRepository): MultiCropAudioUseCase {
        return MultiCropAudioUseCase(repository = repository)
    }

    @UnstableApi
    @Provides
    fun provideMultiCropVideoRepo(@ApplicationContext context: Context): MultiCropVideoRepository {
        return MultiCropVideoRepoImpl(context = context)
    }

    @UnstableApi
    @Provides
    fun provideMultiCropVideoUseCase(repository: MultiCropVideoRepository): MultiCropVideoUseCase {
        return MultiCropVideoUseCase(repository = repository)
    }

    @UnstableApi
    @Provides
    fun provideConvertAudioFormatRepo(@ApplicationContext context: Context): ConvertAudioFormatRepository {
        return ConvertAudioFormatRepoImpl(context = context)
    }

    @UnstableApi
    @Provides
    fun provideConvertAudioFormatUseCase(repository: ConvertAudioFormatRepository): ConvertAudioFormatUseCase {
        return ConvertAudioFormatUseCase(repository = repository)
    }

    @UnstableApi
    @Provides
    @Singleton
    fun provideRecordAudioRepo(@ApplicationContext context: Context): RecordAudioRepository {
        return RecordAudioRepoImpl(context = context)
    }

    @Provides
    fun provideRecordAudioUseCase(repository: RecordAudioRepository): RecordAudioUseCase {
        return RecordAudioUseCase(repository = repository)
    }

}