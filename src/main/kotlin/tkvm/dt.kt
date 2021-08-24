package org.example.mirai.plugin.tkvm


import okhttp3.*
import java.io.IOException
import java.net.URL


public class DATA{
    private var IN = "BTC"
    val apiResponse = URL("https://tarkov-market.com/api/v1/item?q=$IN&x-api-key=LtqsedrEFLY3vGE5").readText()
    var name:String = "1"
    var shortName:String = "2"
    var price:String = "3"
    var basePrice:String = "4"
    var avg24hPrice:String = "5"
    var avg7daysPrice:String = "6"
    var traderName:String = "7"
    var traderPrice:String = "8"
}

fun main(args:Array<String>) {

//    val client = OkHttpClient()
//    val JSON:MediaType = "application/json".toMediaType()
//
//    val json = JSONObject()
//    json.put("A","1")
//    json.put("B","2")
//    json.put("C","3")

    var IN = "BTC"
    val api = "https://tarkov-market.com/api/v1/item?q=$IN&x-api-key=LtqsedrEFLY3vGE5"

    val url = api
    val okHttpClient = OkHttpClient()
    val request: Request = Request.Builder()
        .url(url)
        .get() //默认就是GET请求，可以不写
        .build()
    val call = okHttpClient.newCall(request)
    println(call)
    println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n")
    call.enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            println("onFailure: ")
        }

        @Throws(IOException::class)
        override fun onResponse(call: Call, response: Response) {
            println("onResponse: " + response.body!!.string())
        }
    })



//    //var IN = ""
//    val url:String = "https://tarkov-market.com/api/v1/item?q=BTC&x-api-key=LtqsedrEFLY3vGE5"
//
//    val builder = FormBody.Builder()
//    //builder.add("",  "BTC")
//    val formBody = builder.build()
//
//    val request = Request.Builder()
//        .method("POST", formBody)
//        .url(url).build()
//
//    val client = OkHttpClient()
//
//    client.newCall(request).enqueue(object : Callback {
//
//        override fun onResponse(call: Call, response: Response) {
//            val result = response.body?.string()
//            println("result：$result")
//        }
//
//        override fun onFailure(call: Call, e: IOException) {
//            println("Failed request api :( " + e.message)
//        }
//
//    })

//    val tkv = DATA()
//
//    println(tkv.name)
//    println(tkv.shortName)
//    println(tkv.price)
//    println(tkv.basePrice)
//    println(tkv.avg24hPrice)
//    println(tkv.avg7daysPrice)
//    println(tkv.traderName)
//    println(tkv.traderPrice)
    //println(request)
}




//https://tarkov-market.com/api/v1/item?q=btc & x-api-key=LtqsedrEFLY3vGE5
//
//https://tarkov-market.com/api/v1/item?q=btc
//
//x-api-key:LtqsedrEFLY3vGE5
//
//GET


//class Test {
//    /**
//     * status : 0
//     * intro : byhieg
//     * shopName : byhige
//     * message : 查询成功
//     */
//    var status = 0
//    var intro: String? = null
//    var shopName: String? = null
//    var message: String? = null
//}

//var result: Test = Gson().fromJson(response.body().string, Test::class.java)