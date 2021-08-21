package org.example.mirai.plugin.tkvm

import net.mamoe.mirai.data.UserInfo


public class DATA{
    var name:String = "1"
    var shortName:String = "2"
    var price:String = "3"
    var basePrice:String = "4"
    var avg24hPrice:String = "5"
    var avg7daysPrice:String = "6"
    var traderName:String = "7"
    var traderPrice:String = "8"
}

fun main(args:Array<String>){
    val tkv = DATA()
    println(tkv.name)
    println(tkv.shortName)
    println(tkv.price)
    println(tkv.basePrice)
    println(tkv.avg24hPrice)
    println(tkv.avg7daysPrice)
    println(tkv.traderName)
    println(tkv.traderPrice)
}


//$str = '{"data":[{"id":1,"name":"Zhang","Record":90},{"id":2,"name":"Xiao","Record":85}]}';
//$arr = json_decode($str);
//$data = [];
//foreach ($arr as $value) {
//    foreach ($value as $val){
//        if($val->id == 2){
//        $data = $val;
//    }
//    }
//}


//https://tarkov-market.com/api/v1/item?q=btc & x-api-key=LtqsedrEFLY3vGE5
//
//https://tarkov-market.com/api/v1/item?q=btc
//
//x-api-key:LtqsedrEFLY3vGE5
//
//GET


