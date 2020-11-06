package com.androidiots.playground.kotlinbytes

import java.math.BigInteger

data class Person(
        val name: String,
        val surName: String,
        val age: Int
)

class SuperHuman(
        val coolName: String,
        val civiliansSaved: BigInteger
) {
    operator fun component1() = coolName
    operator fun component2() = civiliansSaved
}

fun deStructurePerson() {
    val person = Person(name = "Gintoki", surName = "Sakata", age = 23)

    // de-structure all values
    val (name1, surname1, age1) = person

    // de-structure and skip middle value
    val (name2, _, age2) = person

    // de-structure just last
    val (_, age3) = person

    // de-structure just first
    val (name3, _) = person
    val (name4) = person

    // de-structure just mid?
    val (_, surname3, _) = person
}

fun deStructureSuperHuman() {
    val superMan = SuperHuman("Superman", BigInteger("3039768898793547264523745379249934"))

    val (name, rescues) = superMan

    val (name2) = superMan
}