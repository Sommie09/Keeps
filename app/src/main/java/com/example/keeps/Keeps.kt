package com.example.keeps

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Keeps(

    @PrimaryKey
    var id: Int ?= null,
    var title: String ?= null,
    var description: String ?= null

) : RealmObject()

