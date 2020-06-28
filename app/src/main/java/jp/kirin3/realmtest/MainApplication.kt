package jp.kirin3.realmtest

import android.app.Application
import io.realm.Realm

class MainApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        /*
        val config = RealmConfiguration.Builder()
            .name("myrealm.realm")
            .encryptionKey(getMyKey())
            .schemaVersion(42)
            .modules(MySchemaModule())
            .migration(MyMigration())
            .readOnly()
            .inMemory()
            .build()
        Realm.setDefaultConfiguration(config)
         */

    }
}