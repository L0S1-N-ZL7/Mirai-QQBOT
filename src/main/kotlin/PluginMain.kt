package org.example.mirai.plugin

import net.mamoe.mirai.event.*
import net.mamoe.mirai.event.events.*
import net.mamoe.mirai.message.data.Image.Key.queryUrl
import net.mamoe.mirai.utils.info
//插件信息
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
//主类继承
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
//机器人被拉进群的事件
import net.mamoe.mirai.event.events.BotInvitedJoinGroupRequestEvent
//收到好友信息事件
import net.mamoe.mirai.event.events.FriendMessageEvent
//收到群消息事件
import net.mamoe.mirai.event.events.GroupMessageEvent
//新好友申请事件
import net.mamoe.mirai.event.events.NewFriendRequestEvent
//日志组件(logger)发控制台信息函数
import net.mamoe.mirai.utils.info
//消息(messageChain)中的图片类型
import net.mamoe.mirai.message.data.Image
//消息(messageChain)中的纯文本类型
import net.mamoe.mirai.message.data.PlainText
//监听器
import net.mamoe.mirai.event.Listener
//监听范围
import net.mamoe.mirai.event.globalEventChannel
import net.mamoe.mirai.message.data.toPlainText
//协程范围?
import kotlin.coroutines.EmptyCoroutineContext


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
        val name = "捞逼特币"
        val price = "一块六毛五"
        val avg24hPrice = "一块六毛五"
        val avg7daysPrice = "一块六毛五"
        val traderName = "我"
        val traderPrice = "一块"
        logger.info { "Plugin loaded" }
        //配置文件目录 "${dataFolder.absolutePath}/"
        val eventChannel = GlobalEventChannel.parentScope(this)
        eventChannel.subscribeAlways<GroupMessageEvent>{
            if (message.contentToString() == "跳跳蚤#BTC") {
                //群内发送
                group.sendMessage("物品名：" +name+"\n"+
                    "当前价格：" +price+"\n"+
                    "24h均价：" +avg24hPrice+"\n"+
                    "7天均价：" +avg7daysPrice+"\n"+
                    "收购商人：" +traderName+"\n"+
                    "商人收购价：" +traderPrice+"\n"+
                    "这个是假的 这个是演鸽在玩")
                //向发送者私聊发送消息
                //不继续处理
                return@subscribeAlways
            }

            if (message.contentToString() == "你妈的") {
                //群内发送
                group.sendMessage("ss")
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
