package com.github.polyKa.gtKawasaki.repository.commands

import com.github.polyKa.gtKawasaki.R

class CloseGripper:Command {
    override val image: Int
        get() = R.drawable.icon_close_gripper
    override val commandText: Int
        get() = R.string.command_close_gripper
}