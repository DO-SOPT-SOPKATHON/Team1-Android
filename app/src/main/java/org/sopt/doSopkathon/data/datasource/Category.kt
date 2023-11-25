package org.sopt.doSopkathon.data.datasource

data class Category(
    val id: Int,
    val name: String,
    var isSelected: Boolean = false
)