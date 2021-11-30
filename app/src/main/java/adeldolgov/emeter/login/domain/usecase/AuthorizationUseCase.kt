package adeldolgov.emeter.login.domain.usecase

import adeldolgov.emeter.login.domain.entities.Auth
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

internal interface AuthorizationUseCase {

    operator fun invoke(login: String, password: String): Single<Auth>
}

internal class AuthorizationUseCaseImpl @Inject constructor() : AuthorizationUseCase {

    override fun invoke(login: String, password: String): Single<Auth> {
        return Single.fromCallable {
            if (login == MOCK_LOGIN && password == MOCK_PASS) Auth(MOCK_TOKEN)
            else throw IllegalArgumentException(MOCK_ERROR)
        }.delay(1700, TimeUnit.MILLISECONDS, Schedulers.io())
    }

    companion object {

        private const val MOCK_LOGIN = "adeldolgov"
        private const val MOCK_PASS = "qwerty512"
        private const val MOCK_TOKEN = "abcdefghijklmnopqrstu"
        private const val MOCK_ERROR = "Invalid user login or password"
    }
}