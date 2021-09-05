package org.example.mirai.plugin.tkvm


//import jogamp.graph.font.typecast.ot.table.Table.post

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import okhttp3.*
import java.io.IOException


class Test {
    /**
     * status : 0
     * intro : byhieg
     * shopName : byhige
     * message : 查询成功
     */
    var name: String? = null
    var shortName: String? = null
    var price: Int? = null
    var basePrice: Int? = null
    var avg24hPrice: Int? = null
    var avg7daysPrice: Int? = null
    var traderName: String? = null
    var traderPrice: Int? = null
}

class DATA{
    private var IN = "BTC"
    //val apiResponse = URL("https://tarkov-market.com/api/v1/item?q=$IN&x-api-key=LtqsedrEFLY3vGE5").readText()
    var name:String = "BTC"
    var shortName:String = "BTC"
    var price:String = "BTC"
    var basePrice:String = "BTC"
    var avg24hPrice:String = "BTC"
    var avg7daysPrice:String = "BTC"
    var traderName:String = "BTC"
    var traderPrice:String = "BTC"
}



fun main() {

//    val client = OkHttpClient()
//    val JSON:MediaType = "application/json".toMediaType()
//
//    val json = JSONObject()
//    json.put("A","1")
//    json.put("B","2")
//    json.put("C","3")

    val iN = "相控"
    val api = "https://tarkov-market.com/api/v1/item?q=$iN&x-api-key=LtqsedrEFLY3vGE5"

    val url = api
    val okHttpClient = OkHttpClient()
    val request: Request = Request.Builder()
        .url(url)
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

            println("删除斜杠后:"+text)
            println("\n"+"\n")

            var bbT: JSONObject? = null
            // 将JSON数组字符串解析成JSON数组
            val jsonArray3 = JSON.parseArray(text)
            println("\n"+"\n")
            // 获取JSON数组长度
            val size = jsonArray3.size
            // 遍历JSON数组
            for (i in 0 until size) {
                // 根据索引获取JSON对象
                bbT = jsonArray3.getJSONObject(i)
                // 将JSON对象打印到控制台
                println("从JSON数组中取出JSON对象:"+bbT)
            }
            // JSON字符串转换成JSON对象
            val jsonObject = bbT
            // 分别取出name、age所对应的值
            val name = jsonObject?.getString("name")
            val price = jsonObject?.getInteger("price")
            // 打印到控制台
            println("name:$name, price:$price")
            println("\n"+"\n")


            // 将JSON字符串转换成JSON数组
            val jsonArray = JSON.parseArray(text)
            println(jsonArray)
            // 遍历JSON数组
            for (i in jsonArray.indices) {
                // 根据索引，从JSON数组中直接取出Java对象
                val person: Test = jsonArray.getObject(i, Test::class.java)
                // 打印到控制台
                println("名字："+person.name)
                println("价格："+person.price)
                println("那啥："+person.shortName)
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
}




//https://tarkov-market.com/api/v1/item?q=btc & x-api-key=LtqsedrEFLY3vGE5
//
//https://tarkov-market.com/api/v1/item?q=btc
//
//x-api-key:LtqsedrEFLY3vGE5
//
//GET




//var result: Test = Gson().fromJson(response.body().string, Test::class.java)