package com.srg.pruebamarvel.data

import com.srg.pruebamarvel.data.features.characters.models.MarvelResponseApiModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by sebrodgar on 26/02/2021.
 */
interface MarvelApiService {

    @GET("/characters/")
    suspend fun getCharacters(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): MarvelResponseApiModel

    @GET("/characters/{characterId}")
    suspend fun getCharacterItem(
        @Path("characterId") characterId: Long
    ): MarvelResponseApiModel
}