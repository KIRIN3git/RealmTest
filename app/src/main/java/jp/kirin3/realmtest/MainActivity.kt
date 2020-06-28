package jp.kirin3.realmtest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RealmSql.insertData(this,"taro",28)
        RealmSql.insertData(this,"jiro",15)
        RealmSql.insertData(this,"saburo",7)

        val personList = RealmSql.selectPersonData()

        for(person in personList){
            Log.w("DEBUG_DATA","person.id = " + person.id);
            Log.w("DEBUG_DATA","person.name = " + person.name);
            Log.w("DEBUG_DATA","person.age = " + person.age);
        }

        RealmSql.deletePersonData()

    }
}
