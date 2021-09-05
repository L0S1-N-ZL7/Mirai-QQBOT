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
import net.mamoe.mirai.message.data.*
//新好友申请事件
//日志组件(logger)发控制台信息函数
//消息(messageChain)中的图片类型
//消息(messageChain)中的纯文本类型
//监听器
//监听范围
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import net.mamoe.mirai.message.data.MessageSource.Key.recall
import net.mamoe.mirai.message.data.MessageSource.Key.recallIn

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
        id = "tkv.chuib.mirai-example",
        name = "tkv.chuib",
        version = "0.1.1"
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

        GlobalEventChannel.subscribeAlways<GroupMessageEvent> {gme-> GroupMessageMonitoring(gme).open()}
        logger.info { "塔科夫WIKI加载完成" }

        /*eventChannel.subscribeAlways<GroupMessageEvent>{
            //群消息
            group.sendMessage("hi")
        }
        eventChannel.subscribeAlways<FriendMessageEvent>{
            //好友信息
            sender.sendMessage("hi")
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
