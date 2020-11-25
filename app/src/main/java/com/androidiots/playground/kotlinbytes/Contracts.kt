package com.androidiots.playground.kotlinbytes

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * src :
 * 1. https://proandroiddev.com/how-to-make-the-compiler-smarter-b37f414875ac
 * 2. https://www.baeldung.com/kotlin-contracts
 */

//@ExperimentalContracts
//fun CharSequence?.isNullOrEmpty(): Boolean {
//    contract {
//        returns(false) implies (this@isNullOrEmpty != null)
//    }
//    return this == null || this.length == 0
//}


@ExperimentalContracts
fun printString() {
    val s: String? = "Hey Medium!"
    if (!s.isNullOrEmpty()) {
        // s is automatically cast to String (non-nullable) because of the effect produced by isNotNull function
        print("The length of '$s' is ${s.length}")
    }
}

class Adapter {
    var nameList : ArrayList<String>? = null
}

class Program {
    @ExperimentalContracts
    private fun send() {
        val list: ArrayList<String> = ArrayList()
        val adapter = Adapter()
//        initializeAdapter {
//             adapter = Adapter()
//        }

        // Case 1
        var otherList = adapter.nameList
        if (otherList != null) {
            list.addAll(otherList) // <--- no error
        }

        // Case 2
        if (adapter.isNotNull() && adapter.nameList.isNullOrEmpty()) {
//            list.addAll(adapter.nameList) // <--- Error here
//  Smart cast to 'kotlin.collections.ArrayList<String> /* = java.util.ArrayList<String> */' is impossible,
//  because 'adapter.nameList' is a mutable property that could have been changed by this time
        }
    }
}

@ExperimentalContracts
fun Adapter?.isNotNull(): Boolean {
    contract {
        // Error in contract description: only references to parameters are allowed in contract description
        returns(true) implies (this@isNotNull != null) // && this@isNotNull.nameList != null)
    }
    return this != null && this.nameList.isNotNull()
}

@ExperimentalContracts
fun<T> ArrayList<T>?.isNotNull(): Boolean {
    contract {
        returns(true) implies (this@isNotNull != null)
    }
    return this != null
}

@ExperimentalContracts
fun initializeAdapter(lambda: () -> Unit) {
    contract {
        callsInPlace(lambda, InvocationKind.EXACTLY_ONCE)
    }
    lambda()
}

@ExperimentalContracts
fun initialize(lambda: ()->Unit) {
    contract {
        callsInPlace(lambda, InvocationKind.AT_LEAST_ONCE)
    }
    lambda()
}


