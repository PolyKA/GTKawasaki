package com.github.polyKa.gtKawasaki.repository.commands

import com.github.polyKa.gtKawasaki.R

class MoveToPoint: Command {
    override val image: Int
        get() = R.drawable.move_to_point
    override val commandText: Int
        get() = R.string.command_move_to_point
}