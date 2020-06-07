package repository


import com.example.comicviewer.model.comic.ComicResponse
import retrofit.RetroInit
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class RepositoryMarvel {
    private var url = "https://gateway.marvel.com/v1/public/"
    private var service = ServiceMarvel::class
    private val ts = (System.currentTimeMillis()/1000).toString()
    private fun getMd5(ts: String): String {
        try {
            val md = MessageDigest.getInstance("MD5")
            val messageDigest = md.digest(
                ts.toByteArray()
                        + PRIVATE_KEY.toByteArray()
                        + PUBLIC_KEY.toByteArray()
            )
            val no = BigInteger(1, messageDigest)
            var hashtext = no.toString(16)
            while (hashtext.length < 32) {
                hashtext = "0$hashtext"
            }
            return hashtext
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        }
    }
    private val serviceMarvel = RetroInit(url).create(service)

    suspend fun getComicService(): ComicResponse {
        return serviceMarvel.getComics(PUBLIC_KEY, ts, getMd5(ts))
    }
}