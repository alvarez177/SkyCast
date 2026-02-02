package com.bold.data.model

import com.bold.domain.model.Location
import com.google.gson.annotations.SerializedName

data class LocationApi(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("country")
    val country: String
) {
    fun toDomain(): Location {
        return Location(
            id, name, region, country
        )
    }
}