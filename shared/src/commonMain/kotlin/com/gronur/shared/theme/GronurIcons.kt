package com.gronur.shared.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import gronur.shared.generated.resources.*
import org.jetbrains.compose.resources.painterResource

object GronurIcons {
    @Composable
    fun plus(): Painter = painterResource(Res.drawable.ic_add)

    @Composable
    fun home(): Painter = painterResource(Res.drawable.ic_home)

    @Composable
    fun cart(): Painter = painterResource(Res.drawable.ic_shopping_cart)

    @Composable
    fun mail(): Painter = painterResource(Res.drawable.ic_mail)

    @Composable
    fun more(): Painter = painterResource(Res.drawable.ic_more)

    @Composable
    fun user(): Painter = painterResource(Res.drawable.ic_user)

    @Composable
    fun minus(): Painter = painterResource(Res.drawable.ic_minus)

    @Composable
    fun phone(): Painter = painterResource(Res.drawable.ic_phone)

    @Composable
    fun store(): Painter = painterResource(Res.drawable.ic_store)

    @Composable
    fun trash(): Painter = painterResource(Res.drawable.ic_trash)

    @Composable
    fun users(): Painter = painterResource(Res.drawable.ic_users)

    @Composable
    fun search(): Painter = painterResource(Res.drawable.ic_search)

    @Composable
    fun wallet(): Painter = painterResource(Res.drawable.ic_wallet)

    @Composable
    fun garlic(): Painter = painterResource(Res.drawable.ic_garlic)

    @Composable
    fun refresh(): Painter = painterResource(Res.drawable.ic_refresh)

    @Composable
    fun location(): Painter = painterResource(Res.drawable.ic_location)

    @Composable
    fun password(): Painter = painterResource(Res.drawable.ic_password)

    @Composable
    fun settings(): Painter = painterResource(Res.drawable.ic_settings)

    @Composable
    fun sliderHorizontal(): Painter = painterResource(Res.drawable.ic_slider_horizontal)

    @Composable
    fun capsicums(): Painter = painterResource(Res.drawable.it_capsicums)

    @Composable
    fun strawberryIcon(): Painter = painterResource(Res.drawable.ic_strawberry)

    @Composable
    fun watermelon(): Painter = painterResource(Res.drawable.it_watermelon)

    @Composable
    fun back(): Painter = painterResource(Res.drawable.ic_arrow_back)
}
