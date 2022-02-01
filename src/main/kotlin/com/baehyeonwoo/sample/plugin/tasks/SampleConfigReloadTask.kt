/*
 * Copyright (c) 2022 BaeHyeonWoo
 *
 *  Licensed under the General Public License, Version 3.0. (https://opensource.org/licenses/gpl-3.0/)
 */

package com.baehyeonwoo.sample.plugin.tasks

import com.baehyeonwoo.sample.plugin.objects.SampleObject.getInstance
import java.io.File

/***
 * @author BaeHyeonWoo
 *
 * "Until my feet are crushed,"
 * "Until I can get ahead of myself."
 */

class SampleConfigReloadTask: Runnable {
    private val configFile = File(getInstance().dataFolder, "config.yml")

    private var configFileLastModified = configFile.lastModified()

    override fun run() {
        // Live Config Reloading. If you need this task, register it anywhere you want.
        // But you should know in advance that this method uses "java.io.File" so it will read your local config file. This means that if you set this task delay for 0, it will read file 20 times per second.
        // Use with caution, especially for hard drive users.

        if (configFileLastModified != configFile.lastModified()) {
            getInstance().logger.info("Config Reloaded.")
            getInstance().reloadConfig()
            getInstance().saveConfig()

            configFileLastModified = configFile.lastModified()
        }
    }
}
