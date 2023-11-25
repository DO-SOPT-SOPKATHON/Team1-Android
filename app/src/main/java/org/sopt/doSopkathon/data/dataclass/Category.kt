package org.sopt.doSopkathon.data.dataclass

data class Category(
    val id: Int,
    val name: String,
    var isSelected: Boolean = false
)