package com.example.scrolllist.data

import com.example.scrolllist.R
import com.example.scrolllist.model.Cat

/**
 * [Datasource] generates a list of [Cat]
 */
class Datasource() {
    fun loadCats(): List<Cat> {
        return listOf<Cat>(
            Cat(R.string.cat1, R.drawable.cat1),
            Cat(R.string.cat2, R.drawable.cat2),
            Cat(R.string.cat3, R.drawable.cat3),
            Cat(R.string.cat4, R.drawable.cat4),
            Cat(R.string.cat5, R.drawable.cat5),
            Cat(R.string.cat6, R.drawable.cat6),
            Cat(R.string.cat7, R.drawable.cat7),
            Cat(R.string.cat8, R.drawable.cat8))
    }
}