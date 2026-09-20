package com.michelle.motionx

data class MotionGroup(
    val name: String,
    val icon: String,
    val description: String,
    val members: Int,
    val category: String,
    var isJoined: Boolean = false
)