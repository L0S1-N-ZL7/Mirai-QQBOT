package org.example.mirai.plugin
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import net.mamoe.mirai.message.data.content
import net.mamoe.mirai.message.data.toPlainText

class GroupMessageMonitoring(gme:GroupMessageEvent) {
    var gme = gme
    suspend fun open(){

        val plainText = linebreak(gme.message)
        val split = plainText.split("#")

        if (split[0].equals("跳蚤")) {
            if (split.size == 1) {
                gme.group.sendMessage(At(gme.sender).plus("\n").plus("玩你🐴的垃圾游戏呢😅".trimMargin()))
                return
            } else if (split.size == 2) {

                val tkvdt = org.example.mirai.plugin.tkvm.DATA()
                val tp = org.example.mirai.plugin.tkvm.main(split[1])

                if (tp != null) {
                    gme.group.sendMessage(
                            At(gme.sender).plus("\n").plus(
                                """
                            物品名：${tkvdt.name}
                            当前价格：${tkvdt.price}
                            24h均价：${tkvdt.avg24hPrice}
                            7天均价：${tkvdt.avg7daysPrice}
                            收购商人：${tkvdt.traderName}
                            商人收购价：${tkvdt.traderPrice}
                            玩你🐴的垃圾游戏呢😅
                            """.trimIndent()
                            )
                    )
                    return
                }
            }
        }

        if (gme.message.contentToString() == "前source") {
            //群内发送
            gme.group.sendMessage(
                At(gme.sender) //At((消息.)发送者)
                    + gme.message.quote() + "Play your 🐴🉐️🌶️🐔🎮呢🧍‍♂️😅")
            //不继续处理
            return
        }
    }

    //" "分隔
    fun linebreak(str: MessageChain):String{
        val content = str.content.toPlainText()
        return if(content.equals("")){
            ""
        }else{
            content.contentToString().trim()
        }
    }
}