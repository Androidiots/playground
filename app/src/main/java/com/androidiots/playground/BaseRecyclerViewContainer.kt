package com.androidiots.playground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView


/**
 * @author Anupam Singh
 * @version 1.0
 * @since 2020-03-09
 */

class BaseRecyclerViewContainer : AppCompatActivity() {

    private val baseRecylerView: RecyclerView by lazy {
        findViewById(R.id.playground_base_recyclerview_container) as RecyclerView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.playground_base_recyclerview_container)
    }

}