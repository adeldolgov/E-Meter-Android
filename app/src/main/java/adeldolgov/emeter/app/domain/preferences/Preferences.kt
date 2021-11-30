package adeldolgov.emeter.app.domain.preferences

interface Preferences {

    fun putString(key: String, value: String?)

    fun putInt(key: String, value: Int)

    fun putBoolean(key: String, value: Boolean)

    fun getString(key: String, defaultValue: String?): String?

    fun getInt(key: String, defaultValue: Int): Int

    fun getBoolean(key: String, defaultValue: Boolean): Boolean
}