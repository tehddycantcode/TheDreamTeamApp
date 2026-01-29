package com.example.thedreamteamapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thedreamteamapp.ui.theme.TheDreamTeamAppTheme

// Light color palette
val BackgroundGradientTop = Color(0xFFF5F7FB)
val BackgroundGradientBottom = Color(0xFFE3ECFF)
val CardBackground = Color(0xFFFFFFFF)
val AccentBlue = Color(0xFF2563EB)
val AccentBlueSoft = Color(0xFFE0EDFF)
val TextPrimary = Color(0xFF111827)
val TextSecondary = Color(0xFF6B7280)
val AvatarPlaceholder = Color(0xFFD1D5DB)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheDreamTeamAppTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Transparent
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ) {
                        composable("home") {
                            DreamTeamScreen(navController)
                        }
                        composable("edward") {
                            EdwardProfileScreen()
                        }
                        composable("mollejon") {
                            MollejonProfileScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DreamTeamScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFF3F8FF), 
                        Color(0xFFD7E8FF),
                        Color(0xFFFDFBFF)
                    )
                )
            )
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            // Header
            Text(
                text = "THE DREAM TEAM APP",
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary,
                modifier = Modifier.align(Alignment.Start)
            )

            Text(
                text = "Meet our Team",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(bottom = 8.dp)
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                ProfileNavButton(
                    name = "Edward Moro",
                    subtitle = "Git Manager",
                    imageRes = (R.drawable.ejpic),
                    accentColor = AccentBlue,
                    onClick = { navController.navigate("edward") }
                )
                ProfileNavButton(
                    name = "Student 2",
                    subtitle = "Bio Screen 2",
                    imageRes = android.R.drawable.ic_menu_gallery,
                    accentColor = Color(0xFF4F46E5),
                    onClick = { }
                )
                ProfileNavButton(
                    name = "Student 3",
                    subtitle = "Bio Screen 3",
                    imageRes = android.R.drawable.ic_menu_gallery,
                    accentColor = Color(0xFF0EA5E9),
                    onClick = { }
                )
                ProfileNavButton(
                    name = "Israel Mollejon",
                    subtitle = "Feature Developer",
                    imageRes = R.drawable.israelmollejonpic,
                    accentColor = Color(0xFF10B981),
                    onClick = { }
                )
                ProfileNavButton(
                    name = "Student 5",
                    subtitle = "Bio Screen 5",
                    imageRes = android.R.drawable.ic_menu_gallery,
                    accentColor = Color(0xFFEC4899),
                    onClick = { }
                )
            }
        }
    }
}

@Composable
fun ProfileNavButton(
    name: String,
    subtitle: String,
    imageRes: Int,
    accentColor: Color,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(AvatarPlaceholder)
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.matchParentSize()
                )
            }

            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary
                )

                Text(
                    text = subtitle,
                    fontSize = 13.sp,
                    color = TextSecondary,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(999.dp))
                    .background(accentColor.copy(alpha = 0.12f))
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "Open",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = accentColor
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DreamTeamPreview() {
    TheDreamTeamAppTheme {
        DreamTeamScreen(rememberNavController())
    }
}