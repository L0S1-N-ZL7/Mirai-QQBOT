package org.example.mirai.plugin

import net.mamoe.mirai.event.*
import net.mamoe.mirai.utils.info
//插件信息
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
//主类继承
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
//机器人被拉进群的事件
//收到好友信息事件
//收到群消息事件
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.MessageSource
//新好友申请事件
//日志组件(logger)发控制台信息函数
//消息(messageChain)中的图片类型
//消息(messageChain)中的纯文本类型
//监听器
//监听范围
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import net.mamoe.mirai.message.data.MessageSource.Key.recall
import net.mamoe.mirai.message.data.MessageSource.Key.recallIn
import net.mamoe.mirai.message.data.messageChainOf
import net.mamoe.mirai.message.data.source

//协程范围?


/**
 * 使用 kotlin 版请把
 * `src/main/resources/META-INF.services/net.mamoe.mirai.console.plugin.jvm.JvmPlugin`
 * 文件内容改成 `org.example.mirai.plugin.PluginMain` 也就是当前主类全类名
 *
 * 使用 kotlin 可以把 java 源集删除不会对项目有影响
 *
 * 在 `settings.gradle.kts` 里改构建的插件名称、依赖库和插件版本
 *
 * 在该示例下的 [JvmPluginDescription] 修改插件名称，id和版本，etc
 *
 * 可以使用 `src/test/kotlin/RunMirai.kt` 在 ide 里直接调试，
 * 不用复制到 mirai-console-loader 或其他启动器中调试
 */

object PluginMain : KotlinPlugin(
    JvmPluginDescription(
        id = "org.example.mirai-example",
        name = "插件示例",
        version = "0.1.0"
    ) {
        author("作者名称或联系方式")
        info(
            """
            这是一个测试插件, 
            在这里描述插件的功能和用法等.
        """.trimIndent()
        )
        // author 和 info 可以删除.
    }
) {
    override fun onEnable() {
        //变量声明
        val tkvdt = org.example.mirai.plugin.tkvm.DATA()
        val name = tkvdt.name
        val price = tkvdt.price
        val avg24hPrice = tkvdt.avg24hPrice
        val avg7daysPrice = tkvdt.avg7daysPrice
        val traderName = tkvdt.traderName
        val traderPrice = tkvdt.traderPrice
        logger.info { "Plugin loaded" }
        //配置文件目录 "${dataFolder.absolutePath}/"
        val eventChannel = GlobalEventChannel.parentScope(this)
        eventChannel.subscribeAlways<GroupMessageEvent>{
                    if (message.contentToString() == "跳蚤#BTC") {
                        // Kotlin// this: GroupMessageEvent
                        group.sendMessage(
                            message.quote() +
                                "物品名：" + name + "\n" +
                                "当前价格：" + price + "\n" +
                                "24h均价：" + avg24hPrice + "\n" +
                                "7天均价：" + avg7daysPrice + "\n" +
                                "收购商人：" + traderName + "\n" +
                                "商人收购价：" + traderPrice + "\n"
                        )
                        message.recallIn(1)
                        // 引用收到的消息并回复 "Hi!", 也可以添加图片等更多元素.
                        //群内发送
                        //向发送者私聊发送消息
                        //不继续处理
                        return@subscribeAlways
                    }


            if (message.contentToString() == "你妈的") {
                //群内发送
                group.sendMessage(message.quote() + "弟弟")
                ////因为message已经被实例化了 所以可以使用message去调用撤回的方法 recallin（1millis 1分钟）
                message.recallIn(1)
                //向发送者私聊发送消息
                //不继续处理
                return@subscribeAlways
            }
            if (message.contentToString() == "dd") {
                //群内发送
                group.sendMessage("ss")
                group.sendMessage("dd")
                //向发送者私聊发送消息
                //不继续处理
                return@subscribeAlways
            }

            if (message.contentToString() == "弟弟") {
                //群内发送
                group.sendMessage("大")
                group.sendMessage("d")
                //向发送者私聊发送消息
                //不继续处理
                return@subscribeAlways
            }

            if (message.contentToString() == "雨雨雨鸽") {
                //群内发送
                group.sendMessage("阿拉德大冤种\n" +
                    "阿拉德大冤种")
                //group.sendMessage("dddd")
                //向发送者私聊发送消息
                //不继续处理
                return@subscribeAlways
            }

            if (message.contentToString() == "h4史23夫3a") {
                //群内发送
                group.sendMessage("塔科夫大冤种\n" +
                    "塔科夫大冤种")
                group.sendMessage("dd")
                //向发送者私聊发送消息
                //不继续处理
                return@subscribeAlways
            }

            if (message.contentToString() == "dd") {
                //群内发送
                group.sendMessage("的s")
                group.sendMessage("dddd")
                //向发送者私聊发送消息
                //不继续处理
                return@subscribeAlways
            }

            if (message.contentToString() == "的d") {
                //群内发送
                group.sendMessage("的sdds")
                group.sendMessage("d是d")
                //向发送者私聊发送消息
                //sender.sendMessage("的s")
                //sender.sendMessage("dd")
                //不继续处理
                return@subscribeAlways
            }

            if (message.contentToString() == "的d") {
                //群内发送
                group.sendMessage("ddddds")
                group.sendMessage("d是d")
                group.sendMessage("dadadads")
                group.sendMessage("的的1234d")
                //向发送者私聊发送消息
                //sender.sendMessage("的s")
                //sender.sendMessage("dd")
                //不继续处理
                return@subscribeAlways
            }

        }

        /*eventChannel.subscribeAlways<FriendMessageEvent>{
            //好友信息
            //sender.sendMessage("hi")
        }
        eventChannel.subscribeAlways<NewFriendRequestEvent>{
            //自动同意好友申请
            accept()
        }
        eventChannel.subscribeAlways<BotInvitedJoinGroupRequestEvent>{
            //自动同意加群申请
            accept()
        }*/
    }
}
