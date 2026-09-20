package com.michelle.motionx

data class AthleteRanking(
    val rank: Int,
    val initials: String,
    val name: String,
    val distance: Double,
    val activities: Int,
    val xp: Int,
    var isFollowing: Boolean = false
)