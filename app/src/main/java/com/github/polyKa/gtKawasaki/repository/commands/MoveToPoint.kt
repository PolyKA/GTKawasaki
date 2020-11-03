package com.github.polyKa.gtKawasaki.repository.commands

import com.github.polyKa.gtKawasaki.R

class MoveToPoint: Command {
    override val image: Int
        get() = R.drawable.move_to_point
    override val commandText: String
        get() = "Move to point"
}