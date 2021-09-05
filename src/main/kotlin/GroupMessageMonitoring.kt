package org.example.mirai.plugin
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import net.mamoe.mirai.message.data.MessageSource.Key.recallIn

class GroupMessageMonitoring(gme:GroupMessageEvent) {
    var gme = gme
    suspend fun open(){
        val tkvdt = org.example.mirai.plugin.tkvm.DATA()
        if(gme.message.contentToString() == "跳蚤#BTC"){
            gme.group.sendMessage(
                gme.message.quote() +
                    At(gme.sender) +
                    "物品名：" + tkvdt.name + "\n" +
                    "当前价格：" + tkvdt.price + "\n" +
                    "24h均价：" + tkvdt.avg24hPrice + "\n" +
                    "7天均价：" + tkvdt.avg7daysPrice + "\n" +
                    "收购商人：" + tkvdt.traderName + "\n" +
                    "商人收购价：" + tkvdt.traderPrice + "\n" +
                    "玩你🐴的垃圾游戏呢😅"
            )
            gme.message.recallIn(1)
            return
        }

        if (gme.message.contentToString() == "你妈的") {
            //群内发送
            gme.group.sendMessage(
                At(gme.sender) //At((消息.)发送者)
                    + gme.message.quote() + "弟弟")
            ////因为message已经被实例化了 所以可以使用message去调用撤回的方法 recallin（1millis 1分钟）
            gme.message.recallIn(1)
            //向发送者私聊发送消息
            //不继续处理
            return
        }
    }
}