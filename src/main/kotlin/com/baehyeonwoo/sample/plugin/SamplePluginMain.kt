/*
 * Copyright (c) 2022 BaeHyeonWoo
 *
 *  Licensed under the General Public License, Version 3.0. (https://opensource.org/licenses/gpl-3.0/)
 */

package com.baehyeonwoo.sample.plugin

import com.baehyeonwoo.sample.plugin.commands.SampleKommand.register
import com.baehyeonwoo.sample.plugin.events.SampleEvent
import com.baehyeonwoo.sample.plugin.objects.SampleObject.message
import com.baehyeonwoo.sample.plugin.tasks.SampleTask
import io.github.monun.kommand.kommand
import org.bukkit.plugin.java.JavaPlugin

/***
 * @author BaeHyeonWoo
 *
 * "Until my feet are crushed,"
 * "Until I can get ahead of myself."
 */

class SamplePluginMain : JavaPlugin() {

    companion object {
        lateinit var instance: SamplePluginMain
            private set
    }

    override fun onEnable() {
        instance = this
        logger.info(message)
        server.pluginManager.registerEvents(SampleEvent(), this)
        server.scheduler.runTask(instance, SampleTask())

        kommand {
            register("sample") {
                register(this)
            }
        }
    }
}