package adeldolgov.emeter.app

import adeldolgov.emeter.app.di.ApplicationComponentHolder
import android.app.Application

/*
*@author Adel Dolgov on 21,Ноябрь,2021
*/
internal class EMeterApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ApplicationComponentHolder.init(this)
    }
}