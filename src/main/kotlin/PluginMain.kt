package org.example.mirai.plugin

import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.*
import net.mamoe.mirai.event.events.*
import net.mamoe.mirai.message.data.Image
import net.mamoe.mirai.message.data.Image.Key.queryUrl
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.utils.info

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
        super.onEnable()
        logger.info { "Plugin loaded" }
        //配置文件目录 "${dataFolder.absolutePath}/"
        val eventChannel = GlobalEventChannel.parentScope(this)
        eventChannel.subscribeAlways<GroupMessageEvent>{
            eventChannel.subscribeMessages {

                //一次消息弹5个
                "跳蚤#1" reply {
                    "物品名：1\n" +
                        "当前价格：1\n" +
                        "24h均价：1\n" +
                        "7天均价：1\n" +
                        "收购商人：1\n" +
                        "商人收购价：1\n"
                }

                //未知
                "跳蚤#2" reply {
                    "物品名：实体比特币\n当前价格：287390\n24h均价：288471\n7天均价：293910\n收购商人：Therapist\n商人收购价：287390(卢布)"
                }

                //未知
                "弹药#BTC" reply {
                    group.sendMessage("查询失败，没有此弹药。\n" +
                        "请按照“口径[空格]弹药名”格式查询，如：\n" +
                        "7.62 BP")
                }

                //未知
                "Hello" reply "你三岁小孩吗" // 当消息内容为 "Hello" 时回复 "Hi"




                val listener: Listener<MessageEvent> = "1" reply "2"
                listener.complete()
            }
            /*
            //复读示例
            if (message.contentToString().startsWith("复读")) {
                group.sendMessage(message.contentToString().replace("复读", ""))
            }
            if (message.contentToString() == "hi") {
                //群内发送
                group.sendMessage("hi")
                //向发送者私聊发送消息
                sender.sendMessage("hi")
                //不继续处理
                return@subscribeAlways
            }
            //分类示例
            message.forEach {
                //循环每个元素在消息里
                if (it is Image) {
                    //如果消息这一部分是图片
                    val url = it.queryUrl()
                    group.sendMessage("图片，下载地址$url")
                }
                if (it is PlainText) {
                    //如果消息这一部分是纯文本
                    group.sendMessage("纯文本，内容:${it.content}")
                }
            }
            */
        }
        eventChannel.subscribeAlways<FriendMessageEvent>{
            //好友信息
            sender.sendMessage("hi")
        }
        /*eventChannel.subscribeAlways<NewFriendRequestEvent>{
            //自动同意好友申请
            accept()
        }
        eventChannel.subscribeAlways<BotInvitedJoinGroupRequestEvent>{
            //自动同意加群申请
            accept()
        }*/
    }
}
