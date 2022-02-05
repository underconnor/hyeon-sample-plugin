/*
 * Copyright (c) 2022 BaeHyeonWoo
 *
 *  Licensed under the General Public License, Version 3.0. (https://opensource.org/licenses/gpl-3.0/)
 */

package com.baehyeonwoo.sample.plugin.commands

import io.github.monun.kommand.KommandBuilder
import net.kyori.adventure.text.Component.text
import org.bukkit.entity.Player

/***
 * @author BaeHyeonWoo
 *
 * "Until my feet are crushed,"
 * "Until I can get ahead of myself."
 */

object SampleKommand {
    fun register(builder: KommandBuilder) {
        builder.apply {
            require { sender -> sender is Player && sender.isOp }
            executes {
                it.sender.sendMessage(text("Hello World!"))
            }
        }
    }
}