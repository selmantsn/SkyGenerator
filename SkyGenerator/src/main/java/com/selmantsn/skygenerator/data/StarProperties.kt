package com.selmantsn.skygenerator.data

data class StarProperties(
    val size: String,
    val color: String,
    val brightness: String
) {
    override fun toString(): String {
        return "{$size, $color, $brightness}\n"
    }
}
