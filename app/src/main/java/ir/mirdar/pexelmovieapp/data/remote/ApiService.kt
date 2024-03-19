package ir.mirdar.pexelmovieapp.data.remote

import ir.mirdar.pexelmovieapp.data.remote.model.Curated
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("curated")
    suspend fun getUpcomingList(
        @Query("page") page: Int
    ) : Response<Curated>
}