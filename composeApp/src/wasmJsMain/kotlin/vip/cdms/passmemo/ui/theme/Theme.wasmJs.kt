package vip.cdms.passmemo.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import kotlinx.browser.document

private const val MetaThemeColorID = "meta-theme-color"

@Composable
actual fun AppTheme(
    darkTheme: Boolean,
    contrast: Contrast,
    content: @Composable () -> Unit
) {
    val colorScheme = remember(darkTheme, contrast) {
        getColorScheme(darkTheme, contrast).apply {
            document.getElementById(MetaThemeColorID) ?: run {
                document.createElement("meta").apply {
                    setAttribute("id", MetaThemeColorID)
                    setAttribute("name", "theme-color")
                    document.head?.appendChild(this)
                }
            }.setAttribute("content", primary.toHex())
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}

fun Color.toHex(): String {
    val red = (red * 255).toInt().toString(16).padStart(2, '0')
    val green = (green * 255).toInt().toString(16).padStart(2, '0')
    val blue = (blue * 255).toInt().toString(16).padStart(2, '0')
    return "#$red$green$blue"
}
