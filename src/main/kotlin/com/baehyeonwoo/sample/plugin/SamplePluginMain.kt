/*
 * Copyright (c) 2022 BaeHyeonWoo
 *
 *  Licensed under the General Public License, Version 3.0. (https://opensource.org/licenses/gpl-3.0/)
 */

package com.baehyeonwoo.sample.plugin

import com.baehyeonwoo.sample.plugin.commands.SampleKommand
import com.baehyeonwoo.sample.plugin.config.SampleConfig
import com.baehyeonwoo.sample.plugin.events.SampleEvent
import com.baehyeonwoo.sample.plugin.tasks.SampleTask
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

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

    private val configFile = File(dataFolder, "config.yml")

    override fun onEnable() {
        instance = this
        SampleConfig.load(configFile)
        logger.info("Hello World!")
        server.pluginManager.registerEvents(SampleEvent(), this)
//        server.scheduler.runTaskTimer(this, SampleConfigReloadTask(), 0L, 20L)
        server.scheduler.runTaskTimer(this, SampleTask(), 0L, 0L)
        SampleKommand.sampleKommand()
    }
}