package com.github.polyKa.gtKawasaki.repository.commands

import com.github.polyKa.gtKawasaki.R

class MoveByCoordinate: Command {
    override val image: Int
        get() = R.drawable.icon_move_by_coordinate
    override val commandText: String
        get() = "Move to point"
}