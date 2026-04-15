package com.example.audiotrimmer.presentation.Navigation

import androidx.annotation.OptIn
import androidx.compose.runtime.Composable
import androidx.media3.common.util.UnstableApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.audiotrimmer.presentation.Screens.AllAudioScreen
import com.example.audiotrimmer.presentation.Screens.AudioExtractorErrorScreen
import com.example.audiotrimmer.presentation.Screens.AudioExtractorScreen
import com.example.audiotrimmer.presentation.Screens.AudioExtractorSuccessScreen
import com.example.audiotrimmer.presentation.Screens.AudioMergeErrorScreen
import com.example.audiotrimmer.presentation.Screens.AudioMergeScreen
import com.example.audiotrimmer.presentation.Screens.AudioMergeSuccessScreen
import com.example.audiotrimmer.presentation.Screens.AudioTrimErrorScreen
import com.example.audiotrimmer.presentation.Screens.AudioTrimSuccessScreen
import com.example.audiotrimmer.presentation.Screens.AudioTrimmerScreen
import com.example.audiotrimmer.presentation.Screens.BuyProPackageScreen
import com.example.audiotrimmer.presentation.Screens.ConvertAudioFormatErrorScreen
import com.example.audiotrimmer.presentation.Screens.ConvertAudioFormatScreen
import com.example.audiotrimmer.presentation.Screens.ConvertAudioFormatSuccessScreen
import com.example.audiotrimmer.presentation.Screens.GetAllAudioForMergeScreen
import com.example.audiotrimmer.presentation.Screens.GetAllSongsForConvertAudioFormatScreen
import com.example.audiotrimmer.presentation.Screens.GetAllSongsForMultiCropScreen
import com.example.audiotrimmer.presentation.Screens.GetAllVideoForAudioExtractScreen
import com.example.audiotrimmer.presentation.Screens.GetAllVideoForSpeedScreen
import com.example.audiotrimmer.presentation.Screens.GetAllVideoScreen
import com.example.audiotrimmer.presentation.Screens.GetAllVideosForMultiCropScreen
import com.example.audiotrimmer.presentation.Screens.MultiCropAudioErrorScreen
import com.example.audiotrimmer.presentation.Screens.MultiCropAudioScreen
import com.example.audiotrimmer.presentation.Screens.MultiCropAudioSuccessScreen
import com.example.audiotrimmer.presentation.Screens.MultiCropVideoErrorScreen
import com.example.audiotrimmer.presentation.Screens.MultiCropVideoScreen
import com.example.audiotrimmer.presentation.Screens.MultiCropVideoSuccessScreen
import com.example.audiotrimmer.presentation.Screens.ProPackageScreen
import com.example.audiotrimmer.presentation.Screens.RecentAudioPlayerScreen
import com.example.audiotrimmer.presentation.Screens.RecentScreen
import com.example.audiotrimmer.presentation.Screens.RecentVideoPlayerScreen
import com.example.audiotrimmer.presentation.Screens.RecordAudioErrorScreen
import com.example.audiotrimmer.presentation.Screens.RecordAudioScreen
import com.example.audiotrimmer.presentation.Screens.RecordAudioSuccessScreen
import com.example.audiotrimmer.presentation.Screens.SelectFeatureScreen
import com.example.audiotrimmer.presentation.Screens.SplashScreen
import com.example.audiotrimmer.presentation.Screens.ThemeSelectionScreen
import com.example.audiotrimmer.presentation.Screens.VideoSpeedErrorScreen
import com.example.audiotrimmer.presentation.Screens.VideoSpeedScreen
import com.example.audiotrimmer.presentation.Screens.VideoSpeedSuccessScreen
import com.example.audiotrimmer.presentation.Screens.VideoTrimErrorScreen
import com.example.audiotrimmer.presentation.Screens.VideoTrimSuccessScreen
import com.example.audiotrimmer.presentation.Screens.VideoTrimmerScreen


@OptIn(UnstableApi::class)
@Composable
fun MainApp() {
    val navcontroller = rememberNavController()
    NavHost(navController = navcontroller, startDestination = SELECTFEATURESCREEN) {

        composable <SELECTFEATURESCREEN>{
            SelectFeatureScreen(navController = navcontroller)
        }
        composable<RECENTSCREEN> {
            RecentScreen(navController = navcontroller)
        }
        composable<PROPACKAGESCREEN> {
            ProPackageScreen(navController = navcontroller)
        }
        composable<THEMESELECTIONSCREEN> {
            ThemeSelectionScreen(navController = navcontroller)
        }
        composable<BUYPROPACKAGESCREEN> { backstackEntry ->
            val data: BUYPROPACKAGESCREEN = backstackEntry.toRoute()
            BuyProPackageScreen(
                packageIdentifier = data.packageIdentifier,
                productId = data.productId,
                title = data.title,
                description = data.description,
                priceFormatted = data.priceFormatted,
                packageType = data.packageType
            )
        }
        composable<RECENTAUDIOPLAYERSCREEN> { backstackEntry ->
            val data: RECENTAUDIOPLAYERSCREEN = backstackEntry.toRoute()
            RecentAudioPlayerScreen(
                navController = navcontroller,
                outputUri = data.outputUri,
                outputName = data.outputName,
                inputName = data.inputName
            )
        }
        composable<RECENTVIDEOPLAYERSCREEN> { backstackEntry ->
            val data: RECENTVIDEOPLAYERSCREEN = backstackEntry.toRoute()
            RecentVideoPlayerScreen(
                navController = navcontroller,
                outputUri = data.outputUri,
                outputName = data.outputName,
                inputName = data.inputName
            )
        }
        composable<HOMESCREEN> {
            AllAudioScreen(navController = navcontroller)

        }
        composable<ALLVIDEOSCREEN> {
            GetAllVideoScreen(navController = navcontroller)

        }
        composable<AUDIOTRIMMERSCREEN> { backstackEntry ->
            val data: AUDIOTRIMMERSCREEN = backstackEntry.toRoute()
            AudioTrimmerScreen(
                navController = navcontroller,
                uri = data.uri,
                songDuration = data.songDuration,
                songName = data.songName
            )
        }
        composable<VIDEOTRIMMERSCREEN> { backstackEntry ->
            val data: VIDEOTRIMMERSCREEN = backstackEntry.toRoute()
            VideoTrimmerScreen(
                navController = navcontroller,
                uri = data.uri,
                videoDuration = data.videoDuration,
                videoName = data.videoName
            )
        }
        composable<AUDIOTRIMMERSUCCESSSTATE> {
            AudioTrimSuccessScreen(navController = navcontroller)
        }
        composable<AUDIOTRIMMERERRORSTATE> {
            AudioTrimErrorScreen(navController = navcontroller)

        }
        composable<VIDEOTRIMMERSUCCESSSTATE> {
            VideoTrimSuccessScreen(navController = navcontroller)
        }
        composable<VIDEOTRIMMERERRORSTATE> {
            VideoTrimErrorScreen(navController = navcontroller)

        }
        composable<ALLVIDEOFORAUDIOEXTRACTSCREEN> {
            GetAllVideoForAudioExtractScreen(navController = navcontroller)

        }
        composable<AUDIOEXTRACTORSCREEN> { backstackEntry ->
            val data: AUDIOEXTRACTORSCREEN = backstackEntry.toRoute()
            AudioExtractorScreen(
                navController = navcontroller,
                uri = data.uri,
                videoDuration = data.videoDuration,
                videoName = data.videoName
            )
        }
        composable<AUDIOEXTRACTORSUCCESSSTATE> {
            AudioExtractorSuccessScreen(navController = navcontroller)
        }
        composable<AUDIOEXTRACTORERRORSTATE> {
            AudioExtractorErrorScreen(navController = navcontroller)

        }
        composable<ALLAUDIOFORMERGESCREEN> {
            GetAllAudioForMergeScreen(navController = navcontroller)

        }
        composable<AUDIOMERGESCREEN> { backstackEntry ->
            val data: AUDIOMERGESCREEN = backstackEntry.toRoute()
            AudioMergeScreen(
                navController = navcontroller,
                uriList = data.uriList,
                songNames = data.songNames
            )
        }
        composable<AUDIOMERGESUCCESSSTATE> {
            AudioMergeSuccessScreen(navController = navcontroller)
        }
        composable<AUDIOMERGEERRORSTATE> {
            AudioMergeErrorScreen(navController = navcontroller)

        }

        composable<ALLSONGSFORMULTICROPSCREEN> {
            GetAllSongsForMultiCropScreen(navController = navcontroller)
        }

        composable<MULTICROPAUDIOSCREEN> { backstackEntry ->
            val data: MULTICROPAUDIOSCREEN = backstackEntry.toRoute()
            MultiCropAudioScreen(
                navController = navcontroller,
                uri = data.uri,
                songDuration = data.songDuration,
                songName = data.songName
            )
        }

        composable<MULTICROPAUDIOSUCCESSSTATE> {
            MultiCropAudioSuccessScreen(navController = navcontroller)
        }

        composable<MULTICROPAUDIOERRORSTATE> {
            MultiCropAudioErrorScreen(navController = navcontroller)
        }

        composable<ALLVIDEOSFORMULTICROPSCREEN> {
            GetAllVideosForMultiCropScreen(navController = navcontroller)
        }

        composable<MULTICROPVIDEOSCREEN> { backstackEntry ->
            val data: MULTICROPVIDEOSCREEN = backstackEntry.toRoute()
            MultiCropVideoScreen(
                navController = navcontroller,
                uri = data.uri,
                videoDuration = data.videoDuration,
                videoName = data.videoName
            )
        }

        composable<MULTICROPVIDEOSUCCESSSTATE> {
            MultiCropVideoSuccessScreen(navController = navcontroller)
        }

        composable<MULTICROPVIDEOERRORSTATE> {
            MultiCropVideoErrorScreen(navController = navcontroller)
        }

        composable<ALLSONGSFORCONVERTAUDIOFORMATSCREEN> {
            GetAllSongsForConvertAudioFormatScreen(navController = navcontroller)
        }

        composable<CONVERTAUDIOFORMATSCREEN> { backstackEntry ->
            val data: CONVERTAUDIOFORMATSCREEN = backstackEntry.toRoute()
            ConvertAudioFormatScreen(
                navController = navcontroller,
                uri = data.uri,
                songDuration = data.songDuration,
                songName = data.songName
            )
        }

        composable<CONVERTAUDIOFORMATSUCCESSSTATE> {
            ConvertAudioFormatSuccessScreen(navController = navcontroller)
        }

        composable<CONVERTAUDIOFORMATERRORSTATE> {
            ConvertAudioFormatErrorScreen(navController = navcontroller)
        }

        composable<RECORDAUDIOSCREEN> {
            RecordAudioScreen(navController = navcontroller)
        }

        composable<RECORDAUDIOSUCCESSSTATE> {
            RecordAudioSuccessScreen(navController = navcontroller)
        }

        composable<RECORDAUDIOERRORSTATE> {
            RecordAudioErrorScreen(navController = navcontroller)
        }

        composable<ALLVIDEOSFORSPEEDSCREEN> {
            GetAllVideoForSpeedScreen(navController = navcontroller)
        }

        composable<VIDEOSPEEDSCREEN> { backstackEntry ->
            val data: VIDEOSPEEDSCREEN = backstackEntry.toRoute()
            VideoSpeedScreen(
                navController = navcontroller,
                uri = data.uri,
                videoDuration = data.videoDuration,
                videoName = data.videoName
            )
        }

        composable<VIDEOSPEEDSUCCESSSTATE> {
            VideoSpeedSuccessScreen(navController = navcontroller)
        }

        composable<VIDEOSPEEDERRORSTATE> {
            VideoSpeedErrorScreen(navController = navcontroller)
        }

    }


}