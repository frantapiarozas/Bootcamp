package com.example.lasobremesa.ui.theme


import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.lasobremesa.ui.theme.LaSobremesaThemeColors

private val DarkColorScheme = darkColorScheme(
        // En modo oscuro, el color principal suele ser una versión un poco más clara o brillante para que resalte
        primary = LaSobremesaThemeColors.Action.Accent, // O tu color primario adaptado a oscuro
        onPrimary = LaSobremesaThemeColors.Text.Primary,
        secondary = LaSobremesaThemeColors.Action.Primary,
        onSecondary = LaSobremesaThemeColors.Text.Primary,
        // Fondos oscuros (puedes tirar de los tonos más altos de tus grises/beiges o un negro suave)
        background = Color(0xFF121212),
        onBackground = Color(0xFFE0E0E0), // Texto claro para leer sobre fondo oscuro
        surface = Color(0xFF1E1E1E),     // Superficies de tarjetas oscuras
        onSurface = Color(0xFFE0E0E0),
        outline = LaSobremesaThemeColors.Border.Strong
    )

private val LightColorScheme = lightColorScheme(
    primary = LaSobremesaThemeColors.Action.Primary,
    onPrimary = LaSobremesaThemeColors.Action.ContentPrimary.Default,
    secondary = LaSobremesaThemeColors.Action.Accent,
    onSecondary = LaSobremesaThemeColors.Action.ContentPrimary.Default,
    background = LaSobremesaThemeColors.Background.Primary,
    onBackground = LaSobremesaThemeColors.Text.Primary,
    surface = LaSobremesaThemeColors.Background.Secondary,
    onSurface = LaSobremesaThemeColors.Text.Primary,
    outline = LaSobremesaThemeColors.Border.Default
)
@Composable
fun LaSobremesaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}






