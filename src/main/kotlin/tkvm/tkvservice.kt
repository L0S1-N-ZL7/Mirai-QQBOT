package org.example.mirai.plugin.tkvm

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class tkvservice {
    fun main(iN:String): tkvservice.ResultBean? {
        val client = OkHttpClient()
        val request = Request.Builder().url("https://tarkov-market.com/api/v1/item?q=$iN&lang=cn&x-api-key=LtqsedrEFLY3vGE5").get().build()
        val call = client.newCall(request)
        val string = call.execute().body?.string()
        return Gson().fromJson(string, ResultBean::class.java)
    }

    data class ResultBean(
        val ch:String,
        val status:String,
        val ts: String,
        val data: List<DATA>
    )

    data class DATA(
        var name: String,
        var shortName: String,
        var price: Int,
        var basePrice: Int,
        var avg24hPrice: Int,
        var avg7daysPrice: Int,
        var traderName: String,
        var traderPrice: Int
    )
}