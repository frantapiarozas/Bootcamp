package com.lasobremesa.ui.theme // Mantén el paquete que ya tenga tu archivo

import androidx.compose.ui.graphics.Color

// =====================================================================
// 1. PRIMITIVOS DE COLOR (Los que agregaste primero)
// =====================================================================

// Green
val Green700 = Color(0xFF144523)
val Green50  = Color(0xFFEFEFEA)
val Green100 = Color(0xFFDCCFEF)
val Green200 = Color(0xFF9BABAB)
val Green300 = Color(0xFF599674)
val Green400 = Color(0xFF348234)
val Green500 = Color(0xFF1B5530)
val Green600 = Color(0xFF154201)
val Green800 = Color(0xFF134A1A)
val Green900 = Color(0xFF022A1A)

// Brown
val Brown200 = Color(0xFF341304)
val Brown50  = Color(0xFFECCEE5)
val Brown100 = Color(0xFFDCAE60)
val Brown200Val = Color(0xFFC4ADAD)
val Brown300 = Color(0xFF9DCC59)
val Brown400 = Color(0xFF80756F)
val Brown500 = Color(0xFF6F655E)
val Brown600 = Color(0xFF5A524D)
val Brown700 = Color(0xFF453F3C)
val Brown800 = Color(0xFF312C2A)
val Brown900 = Color(0xFF1D1A19)

// Orange
val Orange400 = Color(0xFFD56630)
val Orange600 = Color(0xFFCC5634)
val Orange50  = Color(0xFFF3CDEF)
val Orange100 = Color(0xFFFDC5A3)
val Orange200 = Color(0xFFE5A17F)
val Orange300 = Color(0xFFCC7D5B)
val Orange500 = Color(0xFF9E4B28)
val Orange700 = Color(0xFF70351C)
val Orange800 = Color(0xFF572A17)
val Orange900 = Color(0xFF3D1E10)

// Beige
val Beige50   = Color(0xFFF9F7FC)
val Beige100  = Color(0xFFF5F2F9)
val Beige200  = Color(0xFFECE7F5)
val Beige300  = Color(0xFFE4DCF1)
val Beige400  = Color(0xFFDCB1E6)
val Beige500  = Color(0xFFD1B6EA)
val Beige600  = Color(0xFFC4A1DF)
val Beige700  = Color(0xFFB88CD4)
val Beige800  = Color(0xFFAB77C8)
val Beige900  = Color(0xFF9F62BD)

// Cream / Otros
val Cream100  = Color(0xFFF9F4EA)


// =====================================================================
// 2. TOKENS SEMÁNTICOS Y DE ESTADO (A continuación de los primitivos)
// =====================================================================

object LaSobremesaThemeColors {

    object Background {
        val Primary = Color(0xFFF9F7CA)
        val Brand = Color(0xFF016330)
        val Accent = Color(0xFFCF3F08)
        val Secondary = Color(0xFFFCF6FF)
        val Subtle = Color(0xFFFDFCF5)
        val Disabled = Color(0xFFEAEAEE)
    }

    object Border {
        val Default = Color(0xFF8281AB)
        val Brand = Color(0xFF016330)
        val Subtle = Color(0xFF4E2305)
        val Strong = Color(0xFF800C14)
        val Accent = Color(0xFFCF3F08)
        val Disabled = Color(0xFF8B91A4)
    }

    object Text {
        val Primary = Color(0xFF421107)
        val Brand = Color(0xFFFFCCF5)
        val Accent = Color(0xFFCC3916)
        val Secondary = Color(0xFF4856A9)
        val Subtle = Color(0xFF656665)
        val Strong = Color(0xFF4B4B4B)
        val Disabled = Color(0xFF8B91A4)
    }

    object Icon {
        val Primary = Color(0xFF421107)
        val Brand = Color(0xFF016330)
        val Accent = Color(0xFFCC3916)
        val Contrast = Color(0xFF4E6961)
        val Secondary = Color(0xFF4856A9)
        val Disabled = Color(0xFF8B91A4)
    }

    object Action {
        val Primary = Color(0xFF014622)
        val Accent = Color(0xFFABC39A)

        object PrimaryState {
            val Default = Color(0xFF016330)
            val Hover = Color(0xFF014622)
            val Pressed = Color(0xFF002A14)
            val Disabled = Color(0xFF8B91A4)
        }

        object ContentPrimary {
            val Default = Color(0xFFF9F7FC)
            val Disabled = Color(0xFFFFF0F0)
        }

        object SecondaryState {
            val Default = Color(0xFFF9F7FC)
            val Hover = Color(0xFFEFFEEA)
            val Pressed = Color(0xFFABC39A)
            val Disabled = Color(0xFF8B91A4)
        }

        object ContentSecondary {
            val Default = Color(0xFF016330)
            val Hover = Color(0xFF014622)
            val Pressed = Color(0xFF002A14)
            val Disabled = Color(0xFF8B91A4)
        }

        object AccentState {
            val Default = Color(0xFFCF3F08)
            val Hover = Color(0xFFB53004)
            val Pressed = Color(0xFF922506)
            val Disabled = Color(0xFF8B91A4)
        }
    }

    object Feedback {
        object Success {
            val Subtle = Color(0xFFEFEFCA)
            val Default = Color(0xFF016330)
            val Strong = Color(0xFF014622)
        }

        object Warning {
            val Subtle = Color(0xFFF9CFC7)
            val Default = Color(0xFFCC5634)
            val Strong = Color(0xFF70351C)
        }

        object Info {
            val Subtle = Color(0xFFF3CDEF)
            val Default = Color(0xFF4856A9)
            val Strong = Color(0xFF432865)
        }

        object Focus {
            val FocusRing = Color(0xFFCF3F08)
            val FocusOffset = Color(0xFFEFEFEA)
        }
    }
}
