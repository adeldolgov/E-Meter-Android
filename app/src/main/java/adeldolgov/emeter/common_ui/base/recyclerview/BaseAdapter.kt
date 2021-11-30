package adeldolgov.emeter.common_ui.base.recyclerview

import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding

/*
*@author Adel Dolgov on 28,Ноябрь,2021
*/
abstract class BaseAdapter : ListAdapter<BaseItem, BaseViewHolder<BaseItem, ViewBinding>>(BaseDiffUtilCallback())