//FT
//repositorio que gestiona preferencias y configuraciones
//
package com.example.misgastospersonales.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.misgastospersonales.data.SettingsDataStore.Companion.IS_CONFIGURED_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences


class SettingsRepository(private val dataStore: DataStore<Preferences>) {
    // Leer configuraciones como un Flow
    val themeFlow: Flow<Boolean> = dataStore.data.map { prefs ->
        prefs[SettingsDataStore.DARK_THEME_KEY] ?: false
    }
    val isConfiguredFlow: Flow<Boolean> = dataStore.data.map { prefs ->
        prefs[SettingsDataStore.IS_CONFIGURED_KEY] ?: false
    }
    val userNameFlow: Flow<String> = dataStore.data.map { prefs ->
        prefs[SettingsDataStore.USER_NAME_KEY] ?: "Usuario"
    }
    val dailyLimitFlow: Flow<Int> = dataStore.data.map { prefs ->
        prefs[SettingsDataStore.DAILY_LIMIT_KEY] ?: 0
    }

    // Funciones para guardar datos de forma asíncrona
    suspend fun saveTheme(isDark: Boolean) {
        dataStore.edit { prefs ->
            prefs[SettingsDataStore.DARK_THEME_KEY] = isDark
        }
    }

    suspend fun saveLimit(limit: Int) {
        dataStore.edit { prefs ->
            prefs[SettingsDataStore.DAILY_LIMIT_KEY] = limit
        }
    }

    suspend fun saveIsConfigured(isConfigured: Boolean) {
        dataStore.edit { prefs ->
            prefs[SettingsDataStore.IS_CONFIGURED_KEY] = isConfigured
        }
    }

    suspend fun saveName(name: String) {
        dataStore.edit { prefs ->
            prefs[SettingsDataStore.USER_NAME_KEY] = name
        }
    }
}
