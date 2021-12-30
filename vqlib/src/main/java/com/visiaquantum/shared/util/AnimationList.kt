package com.visiaquantum.shared.util

data class AnimationList(
    var resAnimationForwardIn: Int, var resAnimationForwardOut: Int,
    var resAnimationBackIn: Int, var resAnimationBackOut: Int,
    var resAnimationFill: Int = 0, var resAnimationEmpty: Int = 0
)