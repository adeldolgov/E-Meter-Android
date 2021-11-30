package adeldolgov.emeter.counters.presentation.adapter

import adeldolgov.emeter.common_ui.base.recyclerview.BaseItem

/*
*@author Adel Dolgov on 28,Ноябрь,2021
*/
internal class HeaderCounterItem(
    val userName: String,
) : BaseItem {

    override val id: String = HEADER_ITEM_ID

    companion object {

        private const val HEADER_ITEM_ID = "counters_header"
    }
}