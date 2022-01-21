/*
 * Copyright (c) 2022 BaeHyeonWoo
 *
 *  Licensed under the General Public License, Version 3.0. (https://opensource.org/licenses/gpl-3.0/)
 */

package com.baehyeonwoo.sample.plugin.commands

import com.baehyeonwoo.sample.plugin.objects.SampleObject.getInstance
import io.github.monun.kommand.kommand
import net.kyori.adventure.text.Component.text

/***
 * @author BaeHyeonWoo
 *
 * "Until my feet are crushed,"
 * "Until I can get ahead of myself."
 */

object SampleKommand {
    fun sampleKommand() {
        getInstance().kommand {
            register("sample") {
                requires { playerOrNull != null && isOp }
                executes {
                    sender.sendMessage(text("Hello World!"))
                }
            }
        }
    }
}