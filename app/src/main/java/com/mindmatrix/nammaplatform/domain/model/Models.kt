package com.mindmatrix.nammaplatform.domain.model

data class Station(
    val code: String,
    val name: String,
    val kannadaName: String,
    val district: String,
    val platforms: Int
)

data class Train(
    val number: String,
    val name: String,
    val kannadaName: String,
    val stationCode: String,
    val platform: Int,
    val departure: String,
    val destination: String,
    val coachLayoutId: String
)

data class CoachLayout(
    val id: String,
    val trainNumber: String,
    val coaches: List<Coach>
)

data class Coach(
    val code: String,
    val type: CoachType,
    val label: String
)

enum class CoachType {
    ENGINE, GENERAL, LADIES, SLEEPER, AC
}

data class UserProfile(
    val id: Long,
    val name: String,
    val email: String,
    val phone: String,
    val photoUri: String?
)
