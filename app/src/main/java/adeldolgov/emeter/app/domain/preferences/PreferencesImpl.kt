package adeldolgov.emeter.app.domain.preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

internal class PreferencesImpl @Inject constructor(context: Context) : Preferences {

    private val sharedPrefs: SharedPreferences =
        context.getSharedPreferences(APPLICATION_PREFERENCES, Context.MODE_PRIVATE)

    private val editor: SharedPreferences.Editor = sharedPrefs.edit()

    override fun putString(key: String, value: String?) {
        editor.putString(key, value).apply()
    }

    override fun putInt(key: String, value: Int) {
        editor.putInt(key, value).apply()
    }

    override fun putBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value).apply()
    }

    override fun getString(key: String, defaultValue: String?): String? {
        return sharedPrefs.getString(key, defaultValue)
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        return sharedPrefs.getInt(key, defaultValue)
    }

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sharedPrefs.getBoolean(key, defaultValue)
    }

    companion object {
        
        const val APPLICATION_PREFERENCES = "application_preferences"
    }
}