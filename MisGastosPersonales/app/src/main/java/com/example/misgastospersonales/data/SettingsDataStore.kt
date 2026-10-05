package com.example.misgastospersonales.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore(name = "settings")

class SettingsDataStore(private val context: Context) {
      companion object {
        val DARK_THEME_KEY = booleanPreferencesKey("dark_theme")
        val USER_NAME_KEY = stringPreferencesKey("user_name")
        val DAILY_LIMIT_KEY = intPreferencesKey("daily_limit")
        val IS_CONFIGURED_KEY = booleanPreferencesKey("is_configured")
    }
}

