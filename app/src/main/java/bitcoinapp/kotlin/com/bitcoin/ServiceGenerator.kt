package bitcoinapp.kotlin.com.bitcoin

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {

    private val client = OkHttpClient.Builder()

    private val builder = Retrofit.Builder()
        .baseUrl("https://api.coindesk.com/v1/bpi/currentprice.json/")
        //.baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client.build())

    private val retrofit = builder.build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}