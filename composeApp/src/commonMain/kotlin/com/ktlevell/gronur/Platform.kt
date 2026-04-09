package com.ktlevell.gronur

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform