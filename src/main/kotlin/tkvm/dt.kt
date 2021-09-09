package org.example.mirai.plugin.tkvm


import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException



class Tkv{

    data class ResultBean(
        val ch: String,
        val status: String,
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



fun main(iN:String): ResultBean? {

//    val client = OkHttpClient()
//    val JSON:MediaType = "application/json".toMediaType()
//
//    val json = JSONObject()
//    json.put("A","1")
//    json.put("B","2")
//    json.put("C","3")

//    val client = OkHttpClient()
//    val request = Request.Builder().url("https://tarkov-market.com/api/v1/item?q=$iN&x-api-key=LtqsedrEFLY3vGE5").get().build()
//    val call = client.newCall(request)
//    val string = call.execute().body?.string()
//    return Gson().fromJson(string, ResultBean::class.java)

    val apiurl = "https://tarkov-market.com/api/v1/item?q=$iN&x-api-key=LtqsedrEFLY3vGE5"

    val okHttpClient = OkHttpClient()
    val request: Request = Request.Builder()
        .url(apiurl)
        .get() //默认就是GET请求，可以不写
        .addHeader("Content-Type", "application/json")
        .build()
    val call = okHttpClient.newCall(request)
    call.enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            println("onFailure: ")
        }

        @Throws(IOException::class)
        override fun onResponse(call: Call, response: Response) {
            var text = JSON.toJSONString(response.body!!.string())

            val fly = text.replace("\\", "")
            text = fly.substring(1, fly.length - 1)

            println("删除斜杠后:" + text)
            println("\n" + "\n")

            var bbT: JSONObject? = null
            // 将JSON数组字符串解析成JSON数组
            val jsonArray3 = JSON.parseArray(text)
            println("\n" + "\n")
            // 获取JSON数组长度
            val size = jsonArray3.size
            // 遍历JSON数组
            for (i in 0 until size) {
                // 根据索引获取JSON对象
                bbT = jsonArray3.getJSONObject(i)
                // 将JSON对象打印到控制台
                println("从JSON数组中取出JSON对象:" + bbT)
            }
            // JSON字符串转换成JSON对象
            val jsonObject = bbT
            // 分别取出name、age所对应的值
            val name = jsonObject?.getString("name")
            val price = jsonObject?.getInteger("price")
            // 打印到控制台
            println("name:$name, price:$price")
            println("\n" + "\n")


            // 将JSON字符串转换成JSON数组
            val jsonArray = JSON.parseArray(text)
            println(jsonArray)
            // 遍历JSON数组
            for (i in jsonArray.indices) {
                // 根据索引，从JSON数组中直接取出Java对象
                val person: DATA = jsonArray.getObject(i, DATA::class.java)
                // 打印到控制台
                println("名字：" + person.name)
                println("价格：" + person.price)
                println("那啥：" + person.shortName)
            }
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
    return null
}

}


//var result: Test = Gson().fromJson(response.body().string, Test::class.java)