package adeldolgov.emeter.security.domain

import adeldolgov.emeter.app.domain.preferences.Preferences
import javax.inject.Inject

/*
*@author Adel Dolgov on 15,Май,2021
*/

interface SecurityManager {

    var token: String?

    val isAuthorized: Boolean
}

internal class SecurityManagerImpl @Inject constructor(
    private val preferences: Preferences
) :
    SecurityManager {

    override var token: String?
        get() = preferences.getString(TOKEN_KEY, null)
        set(value) = preferences.putString(TOKEN_KEY, value)

    override val isAuthorized: Boolean
        get() = token != null

    companion object {

        private const val TOKEN_KEY = "auth_token"
    }
}