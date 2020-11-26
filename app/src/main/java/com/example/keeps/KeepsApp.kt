package com.example.keeps

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class KeepsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        //init realm
        Realm.init(this)

        val configuration = RealmConfiguration.Builder()
            .name("Keeps.db")
            .deleteRealmIfMigrationNeeded()
            .schemaVersion(0)
            .build()

        Realm.setDefaultConfiguration(configuration)


    }


}