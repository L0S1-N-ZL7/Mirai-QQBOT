package org.example.mirai.plugin.tkvm


import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException



/*class Tkv{

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

}*/

class DATA {
    var name: String? = null
    var shortName: String? = null
    var price: Int? = null
    var basePrice: Int? = null
    var avg24hPrice: Int? = null
    var avg7daysPrice: Int? = null
    var traderName: String? = null
    var traderPrice: Int? = null
}


//fun main(iN:String): Tkv.ResultBean? {
    fun main(args:Array<String>){

//    val client = OkHttpClient()
//    val request = Request.Builder().url("https://tarkov-market.com/api/v1/item?q=iN&lang=cn&x-api-key=LtqsedrEFLY3vGE5").get().build()
//    val call = client.newCall(request)
//    val string = call.execute().body?.string()
//    return Gson().fromJson(string, ResultBean::class.java)

//var result: Test = Gson().fromJson(response.body().string, Test::class.java)

    var iN = "比特币"
    val apiurl = "https://tarkov-market.com/api/v1/item?q=$iN&lang=cn"

    val okHttpClient = OkHttpClient()
    val request: Request = Request.Builder()
        .url(apiurl)
        .get() //默认就是GET请求，可以不写
        .addHeader("x-api-key","LtqsedrEFLY3vGE5")
        .addHeader("Content-Type", "application/json")
        // .addHeader("q",iN)
        // .addHeader("lang","cn")
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


//    return null
}