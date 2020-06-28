package jp.kirin3.realmtest

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Person(
    // Properties can be annotated with PrimaryKey or Index.
    @PrimaryKey var id: Long = 0,
    var name: String = "",
    var age: Int = 0
) : RealmObject()