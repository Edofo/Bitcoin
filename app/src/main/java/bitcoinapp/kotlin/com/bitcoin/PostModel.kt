package bitcoinapp.kotlin.com.bitcoin

import com.google.gson.annotations.SerializedName
import java.util.*


public class PostModel {

    @SerializedName("time")
    val time: DataTime? = null

    @SerializedName("disclaimer")
    val disclaimer: String? = null

    @SerializedName("chartName")
    val chartName: String? = null

    @SerializedName("bpi")
    val bpi: Databpi? = null
}


class DataTime {
    @SerializedName("updated")
    val updated: String? = null

    @SerializedName("updatedISO")
    val updatedISO: String? = null

    @SerializedName("updateduk")
    val updateduk: String? = null
}

class Databpi {
    @SerializedName("USD")
    val USD: dataInfo? = null

    @SerializedName("GBP")
    val GBP: dataInfo? = null

    @SerializedName("EUR")
    val EUR: dataInfo? = null
}

class dataInfo {
    @SerializedName("code")
    val code: String? = null

    @SerializedName("symbol")
    val symbol: String? = null

    @SerializedName("rate")
    val rate: String? = null

    @SerializedName("description")
    val description: String? = null

    @SerializedName("rate_float")
    val rate_float: Float? = null
}