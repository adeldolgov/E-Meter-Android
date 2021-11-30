package adeldolgov.emeter.common_ui.base.recyclerview

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/*
*@author Adel Dolgov on 28,Ноябрь,2021
*/
abstract class BaseViewHolder<T : BaseItem, VB : ViewBinding>(
    protected val viewBinding: VB
) : RecyclerView.ViewHolder(viewBinding.root) {

    abstract fun bind(item: T)
}