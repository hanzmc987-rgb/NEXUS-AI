package com.nexusai.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Lavender = Color(0xFFEDEBFF)
private val Lime = Color(0xFFC6FF00)
private val Purple = Color(0xFF873BFF)
private val Ink = Color(0xFF17131F)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NexusApp()
        }
    }
}

@Composable
fun NexusApp() {
    var language by remember { mutableStateOf("Bahasa Indonesia") }
    var showLanguages by remember { mutableStateOf(false) }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Lavender)
                .padding(20.dp)
        ) {
            Text(
                "NEXUS AI",
                fontSize = 30.sp,
                fontWeight = FontWeight.Black,
                color = Ink
            )

            Text(
                "YOUR AI. YOUR WORLD.",
                fontSize = 12.sp,
                color = Purple,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(28.dp))

            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(20.dp)) {
                    Text("SELAMAT DATANG", fontWeight = FontWeight.Black)
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Satu aplikasi. Banyak kecerdasan.",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(16.dp))

                    Button(
                        onClick = { showLanguages = true },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Lime,
                            contentColor = Ink
                        )
                    ) {
                        Text("🌍 $language", fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(Modifier.height(20.dp))

            Text("PILIH AI ENGINE", fontWeight = FontWeight.Black)
            Spacer(Modifier.height(10.dp))

            listOf("OpenAI", "Gemini", "DeepSeek", "Claude").forEach {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Text(
                        it,
                        modifier = Modifier.padding(18.dp),
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(Modifier.height(20.dp))

            Card(
                colors = CardDefaults.cardColors(containerColor = Purple),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "START CHATTING →",
                    modifier = Modifier.padding(20.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Black
                )
            }
        }
    }

    if (showLanguages) {
        AlertDialog(
            onDismissRequest = { showLanguages = false },
            title = { Text("Pilih Bahasa") },
            text = {
                Column {
                    listOf(
                        "Bahasa Indonesia",
                        "English",
                        "Español",
                        "Français",
                        "العربية",
                        "日本語",
                        "한국어",
                        "中文",
                        "हिन्दी",
                        "Português"
                    ).forEach {
                        TextButton(onClick = {
                            language = it
                            showLanguages = false
                        }) {
                            Text(it)
                        }
                    }
                }
            },
            confirmButton = {}
        )
    }
}
