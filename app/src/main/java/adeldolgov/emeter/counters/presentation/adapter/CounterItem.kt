package adeldolgov.emeter.counters.presentation.adapter

import adeldolgov.emeter.common_ui.base.recyclerview.BaseItem
import androidx.annotation.ColorRes
import java.math.BigDecimal

/*
*@author Adel Dolgov on 28,Ноябрь,2021
*/
internal data class CounterItem(
    override val id: String,
    val name: String,
    val value: BigDecimal,
    val price: BigDecimal,
    val valueDiff: BigDecimal,
    @ColorRes
    val color: Int,
) : BaseItem