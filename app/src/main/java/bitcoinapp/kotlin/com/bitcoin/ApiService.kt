package bitcoinapp.kotlin.com.bitcoin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers("Content-Type: application/json")
    @GET(".")
    fun getBitcoin() : Call<PostModel>

}