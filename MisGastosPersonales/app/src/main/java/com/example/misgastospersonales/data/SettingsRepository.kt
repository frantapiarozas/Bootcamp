//FT
//repositorio que gestiona preferencias y configuraciones
//
package com.example.misgastospersonales.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.example.misgastospersonales.data.SettingsDataStore.Companion.IS_CONFIGURED_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingsRepository(private val context: Context) {
    // Leer configuraciones como un Flow
    val themeFlow: Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[SettingsDataStore.DARK_THEME_KEY] ?: false
    }
    val isConfiguredFlow: Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[IS_CONFIGURED_KEY] ?: false
    }
    val userNameFlow: Flow<String> = context.dataStore.data.map { prefs ->
        prefs[SettingsDataStore.USER_NAME_KEY] ?: "Usuario"
    }
    val dailyLimitFlow: Flow<Int> = context.dataStore.data.map { prefs ->
        prefs[SettingsDataStore.DAILY_LIMIT_KEY] ?: 0
    }

    // Funciones para guardar datos de forma asíncrona
    suspend fun saveTheme(isDark: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[SettingsDataStore.DARK_THEME_KEY] = isDark
        }
    }

    suspend fun saveLimit(limit: Int) {
        context.dataStore.edit { prefs ->
            prefs[SettingsDataStore.DAILY_LIMIT_KEY] = limit
        }
    }

    suspend fun saveIsConfigured(isConfigured: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[SettingsDataStore.IS_CONFIGURED_KEY] = isConfigured
        }
    }

    suspend fun saveName(name: String) {
        context.dataStore.edit { prefs ->
            prefs[SettingsDataStore.USER_NAME_KEY] = name
        }
    }
}
