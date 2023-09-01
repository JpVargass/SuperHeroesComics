package cl.jpvs.superheroescomics.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface HeroeApi {
    @GET("superheroes/")
    suspend fun getDataHeroe(): Response<List<Heroe>>
}