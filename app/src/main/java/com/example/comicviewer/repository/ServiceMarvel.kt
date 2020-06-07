package repository


import com.example.comicviewer.model.comic.ComicResponse
import retrofit2.http.GET
import retrofit2.http.Query

public const val PUBLIC_KEY = "5d2e57d76e6f41bee69c7452328b134f"
public const val PRIVATE_KEY = "7aede368342627ad6244522c85ed2445d847a89b"

interface ServiceMarvel {

    @GET("comics")
    suspend fun getComics(
        @Query("apikey") apikey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("limit") limit: Int = 20
    ): ComicResponse
}