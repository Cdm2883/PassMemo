package vip.cdms.passmemo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.WindowScope
import com.konyaco.fluent.FluentTheme
import com.konyaco.fluent.background.Mica
import com.mayakapps.compose.windowstyler.WindowBackdrop
import com.mayakapps.compose.windowstyler.WindowStyle

@Composable
fun WindowScope.AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    WindowStyle(
        isDarkTheme = darkTheme,
        backdropType = WindowBackdrop.Mica
    )

    val colorScheme = if (darkTheme) colorsDark else colorsLight

    FluentTheme(
        colors = colorScheme,
        typography = AppTypography,
    ) {
        Mica(modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}
