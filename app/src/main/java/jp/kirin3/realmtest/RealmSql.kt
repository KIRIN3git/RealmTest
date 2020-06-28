package jp.kirin3.realmtest


import android.content.Context
import androidx.preference.PreferenceManager
import io.realm.Realm
import io.realm.kotlin.where

object RealmSql {

    val PREF_PERSON_NUMBER = "pref_person_number"

    fun insertData(context: Context, name: String, age: Int) {

        var id = getPersonNextId(context)

        var person = Person(id, name, age)
        if (person == null) return

        var realm = Realm.getDefaultInstance()

        realm.beginTransaction()
        realm.insert(person)
        realm.commitTransaction()

        realm.close()

        setPersonId(context, id)
    }

    fun setPersonId(context: Context, id: Long) {
        val sp = PreferenceManager.getDefaultSharedPreferences(context)
        sp.edit().putLong(PREF_PERSON_NUMBER, id).apply()
    }

    fun getPersonNextId(context: Context): Long {
        val sp = PreferenceManager.getDefaultSharedPreferences(context)
        return sp.getLong(PREF_PERSON_NUMBER, -1) + 1
    }


    fun deletePersonData() {

        var realm = Realm.getDefaultInstance()

        val persons = realm.where<Person>().findAll()

        realm.beginTransaction()
        persons.deleteAllFromRealm()
        realm.commitTransaction()

        realm.close()
    }

    fun selectPersonData(): List<Person> {

        var realm = Realm.getDefaultInstance()

        val users = realm.where<Person>().findAll()
        val user = realm.copyFromRealm(users)

        realm.close()

        return user
    }
}