package org.example.mirai.plugin
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import net.mamoe.mirai.message.data.content
import net.mamoe.mirai.message.data.toPlainText
import org.example.mirai.plugin.tkvm.Tkv
import org.example.mirai.plugin.tkvm.tkvservice
import org.example.mirai.plugin.tkvm.*

//class GroupMessageMonitoring(gme:GroupMessageEvent) {
//    var gme = gme
//    suspend fun open(){
//
//        val plainText = linebreak(gme.message)
//        val split = plainText.split("#")
//
//        if (split[0].equals("è·³è¤")) {
//            if (split.size == 1) {
//                gme.group.sendMessage(At(gme.sender).plus("\n").plus("ç©ä½ ð´çåå¾æ¸¸æå¢ð".trimMargin()))
//                return
//            } else if (split.size == 2) {
//
//              val tp = Tkv().main(split[1])
//
//                if (tp != null) {
//
//                    val data = tp.data.get(0)
//
//                    gme.group.sendMessage(
//                            At(gme.sender).plus("\n").plus(
//                                """
//                            ç©ååï¼${data.name}
//                            å½åä»·æ ¼ï¼${data.price}
//                            24håä»·ï¼${data.avg24hPrice}
//                            7å¤©åä»·ï¼${data.avg7daysPrice}
//                            æ¶è´­åäººï¼${data.traderName}
//                            åäººæ¶è´­ä»·ï¼${data.traderPrice}
//                            ç©ä½ ð´çåå¾æ¸¸æå¢ð
//                            """.trimIndent()
//                            )
//                    )
//                    return
//                }
//            }
//        }
//
//        if (gme.message.contentToString() == "åsource") {
//            //ç¾¤ååé
//            gme.group.sendMessage(
//                At(gme.sender) //At((æ¶æ¯.)åéè)
//                    + gme.message.quote() + "Play your ð´ðï¸ð¶ï¸ðð®å¢ð§ââï¸ð")
//            //ä¸ç»§ç»­å¤ç
//            return
//        }
//    }
//
//    //" "åé
//    fun linebreak(str: MessageChain):String{
//        val content = str.content.toPlainText()
//        return if(content.equals("")){
//            ""
//        }else{
//            content.contentToString().trim()
//        }
//    }
//}