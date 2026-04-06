package com.ktlevell.gronur.gronur

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform