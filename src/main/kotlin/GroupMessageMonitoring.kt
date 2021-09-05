package org.example.mirai.plugin
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import net.mamoe.mirai.message.data.MessageSource.Key.recall
import net.mamoe.mirai.message.data.MessageSource.Key.recallIn
import net.mamoe.mirai.message.data.source

class GroupMessageMonitoring(gme:GroupMessageEvent) {
    var gme = gme
    suspend fun open(){
        val tkvdt = org.example.mirai.plugin.tkvm.DATA()
        if(gme.message.contentToString() == "跳蚤#BTC"){
            gme.group.sendMessage(
                gme.message.quote() +
                    At(gme.sender) + "\n" +
                    "物品名：" + tkvdt.name + "\n" +
                    "当前价格：" + tkvdt.price + "\n" +
                    "24h均价：" + tkvdt.avg24hPrice + "\n" +
                    "7天均价：" + tkvdt.avg7daysPrice + "\n" +
                    "收购商人：" + tkvdt.traderName + "\n" +
                    "商人收购价：" + tkvdt.traderPrice + "\n" +
                    "玩你🐴的垃圾游戏呢😅"
            )
            return
        }

        if (gme.message.contentToString() == "前source") {
            ////因为message已经被实例化了 所以可以使用message去调用撤回的方法 recallin（1millis 1分钟）
            gme.message.source.recallIn(5000)
            gme.message.recallIn(5000)
            //群内发送
            gme.group.sendMessage(
                At(gme.sender) //At((消息.)发送者)
                    + gme.message.quote() + "Play your 🐴🉐️🌶️🐔🎮呢🧍‍♂️😅")
            gme.message.source.recall()
            gme.message.recall()
            //向发送者私聊发送消息
            //不继续处理
            return
        }
        if (gme.message.contentToString() == "后source") {
            //群内发送
            gme.group.sendMessage(
                At(gme.sender) //At((消息.)发送者)
                    + gme.message.quote() + "Play your 🐴🉐️🌶️🐔🎮呢🧍‍♂️😅")
            ////因为message已经被实例化了 所以可以使用message去调用撤回的方法 recallin（1millis 1分钟）
            gme.message.source.recallIn(5000)
            gme.message.recallIn(5000)
            //向发送者私聊发送消息
            //不继续处理
            return
        }
    }
}