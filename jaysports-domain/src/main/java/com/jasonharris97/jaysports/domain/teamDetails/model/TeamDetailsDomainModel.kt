package com.jasonharris97.jaysports.domain.teamDetails.model

data class TeamDetailsDomainModel(
    val id: String,
    val name: String,
    val code: String,
    val country: String,
    val founded: Int,
    val logoUrl: String,
)
