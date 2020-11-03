package com.github.polyKa.gtKawasaki.repository.commands

import com.github.polyKa.gtKawasaki.R

class OpenGripper:Command {
    override val image: Int
        get() = R.drawable.icon_open_gripper
    override val commandText: Int
        get() = R.string.command_open_gripper
}