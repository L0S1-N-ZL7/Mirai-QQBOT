package org.example.mirai.plugin.tkvm

import io.ktor.http.*
import org.example.mirai.plugin.*
import java.io.File

{
    name: string,
    shortName: string,
    price: number,
    basePrice: number,
    avg24hPrice: number,
    avg7daysPrice: number
    traderName: string,
    traderPrice: string
}

$str = '{"data":[{"id":1,"name":"Zhang","Record":90},{"id":2,"name":"Xiao","Record":85}]}';
$arr = json_decode($str);
$data = [];
foreach ($arr as $value) {
    foreach ($value as $val){
        if($val->id == 2){
        $data = $val;
    }
    }
}

//https://tarkov-market.com/api/v1/item?q=btc & x-api-key=LtqsedrEFLY3vGE5
//
//https://tarkov-market.com/api/v1/item?q=btc
//
//x-api-key:LtqsedrEFLY3vGE5
//
//GET


