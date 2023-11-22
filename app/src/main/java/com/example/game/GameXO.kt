package com.example.game

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class GameXO(
    var id: UUID = UUID.randomUUID(),
    val game: GAME_X_OR_O,
    var isXOrO: Boolean = false
) : Parcelable

enum class GAME_X_OR_O {
    X,
    O
}