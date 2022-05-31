package com.example.retrofit.remote

import com.google.gson.annotations.SerializedName

data class PokemonEntry(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("types")
    val types: List<TypeEntry>,
    @SerializedName("stats")
    val stats: List<StatsEntry>,
    @SerializedName("sprites")
    val sprites: spritesEntry,
)

data class TypeEntry(
    @SerializedName("type")
    val type: TypeName
)

data class TypeName(
    @SerializedName("name")
    val name: String
)
data class StatsEntry(
    @SerializedName("base_stat")
    val base_stat: Int,
    @SerializedName("stat")
    val stat_name: statsName

)

data class statsName(
    @SerializedName("name")
    val stat: String
)

data class spritesEntry(
    @SerializedName("front_default")
    val sprite: String
)