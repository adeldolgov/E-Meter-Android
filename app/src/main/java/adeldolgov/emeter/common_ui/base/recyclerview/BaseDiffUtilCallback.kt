package adeldolgov.emeter.common_ui.base.recyclerview

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

/*
*@author Adel Dolgov on 28,Ноябрь,2021
*/
internal class BaseDiffUtilCallback : DiffUtil.ItemCallback<BaseItem>() {

    override fun areItemsTheSame(oldItem: BaseItem, newItem: BaseItem): Boolean = oldItem.id == newItem.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: BaseItem, newItem: BaseItem): Boolean = oldItem == newItem
}
