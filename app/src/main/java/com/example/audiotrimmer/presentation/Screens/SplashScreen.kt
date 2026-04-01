package com.example.audiotrimmer.presentation.Screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.audiotrimmer.R
import com.example.audiotrimmer.presentation.Navigation.SELECTFEATURESCREEN
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    val scale = remember { Animatable(0.8f) }
    var dots by remember { mutableStateOf("") }

    val infiniteTransition = rememberInfiniteTransition()

    val glowSize by infiniteTransition.animateFloat(
        initialValue = 90f,
        targetValue = 120f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200),
            repeatMode = RepeatMode.Reverse
        )
    )

    LaunchedEffect(Unit) {
        scale.animateTo(
            1f,
            animationSpec = tween(
                durationMillis = 900,
                easing = FastOutSlowInEasing
            )
        )
    }

    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(SELECTFEATURESCREEN) {
            popUpTo("splash") { inclusive = true }
        }
    }

    LaunchedEffect(Unit) {
        while (true) {
            dots = when (dots) {
                "" -> "."
                "." -> ".."
                ".." -> "..."
                else -> ""
            }
            delay(400)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Box(contentAlignment = Alignment.Center) {

                // Glow pulse
                Box(
                    modifier = Modifier
                        .size(glowSize.dp)
                        .blur(35.dp)
                        .background(
                            color = Color(0xFFFF5722).copy(alpha = 0.35f),
                            shape = CircleShape
                        )
                )

                // Logo
                Image(
                    painter = painterResource(id = R.drawable.audiocutterapp),
                    contentDescription = "App Logo",
                    modifier = Modifier
                        .size(120.dp)
                        .scale(scale.value)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "AudioTrimmer",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFF5722)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Audio & Video Editing Tools",
                fontSize = 14.sp,
                color = Color(0xFFBDBDBD)
            )

            Spacer(modifier = Modifier.height(40.dp))

            CircularProgressIndicator(
                color = Color(0xFFFF5722),
                strokeWidth = 3.dp,
                modifier = Modifier.size(34.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Loading$dots",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}