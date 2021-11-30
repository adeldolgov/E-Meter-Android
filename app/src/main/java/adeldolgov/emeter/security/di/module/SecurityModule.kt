package adeldolgov.emeter.security.di.module

import adeldolgov.emeter.security.domain.SecurityManager
import adeldolgov.emeter.security.domain.SecurityManagerImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/*
*@author Adel Dolgov on 15,Май,2021
*/
@Module
internal interface SecurityModule {

    @Binds
    fun bindAuthProvider(impl: SecurityManagerImpl): SecurityManager
}