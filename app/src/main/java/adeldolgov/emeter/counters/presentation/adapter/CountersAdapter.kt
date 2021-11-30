package adeldolgov.emeter.counters.presentation.adapter

import adeldolgov.emeter.R
import adeldolgov.emeter.common_ui.base.recyclerview.BaseAdapter
import adeldolgov.emeter.common_ui.base.recyclerview.BaseItem
import adeldolgov.emeter.common_ui.base.recyclerview.BaseViewHolder
import adeldolgov.emeter.common_ui.extensions.setEndDrawableRes
import adeldolgov.emeter.databinding.ItemCounterBinding
import adeldolgov.emeter.databinding.ItemCountersHeaderBinding
import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding


/*
*@author Adel Dolgov on 28,Ноябрь,2021
*/
internal class CountersAdapter(
    private val onCounterClickListener: (String) -> (Unit)
) : BaseAdapter() {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is HeaderCounterItem -> VIEW_TYPE_HEADER
            else -> VIEW_TYPE_COUNTER
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BaseItem, ViewBinding> {
        return when (viewType) {
            VIEW_TYPE_HEADER -> CounterHeaderViewHolder(
                ItemCountersHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> CounterViewHolder(
                ItemCounterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ) { onCounterClickListener(getItem(it).id) }
        } as BaseViewHolder<BaseItem, ViewBinding>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<BaseItem, ViewBinding>, position: Int) {
        holder.bind(getItem(position))
    }

    class CounterHeaderViewHolder(
        binding: ItemCountersHeaderBinding
    ) : BaseViewHolder<HeaderCounterItem, ItemCountersHeaderBinding>(binding) {

        override fun bind(item: HeaderCounterItem) {
            viewBinding.title.text = viewBinding.root.context.getString(R.string.counters_header, item.userName)
        }
    }

    class CounterViewHolder(
        binding: ItemCounterBinding,
        private val onClickListener: (Int) -> (Unit)
    ) : BaseViewHolder<CounterItem, ItemCounterBinding>(binding) {

        init {
            viewBinding.root.setOnClickListener { onClickListener(bindingAdapterPosition) }
        }

        override fun bind(item: CounterItem) {
            val context: Context = viewBinding.root.context
            viewBinding.counterName.text = item.name
            viewBinding.counterValue.text = context.getString(R.string.counters_value_holder, item.value.toPlainString())

            val cardColor: Int = ContextCompat.getColor(context, item.color)
            viewBinding.root.backgroundTintList = ColorStateList.valueOf(cardColor)
            viewBinding.counterIcon.imageTintList = ColorStateList.valueOf(cardColor)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
                viewBinding.root.outlineAmbientShadowColor = cardColor
                viewBinding.root.outlineSpotShadowColor = cardColor
            }

            viewBinding.counterDayValueDiff.text = context.getString(R.string.counters_value_holder, item.valueDiff.toPlainString())
            viewBinding.counterPrice.text = context.getString(R.string.common_price_holder, item.price.toPlainString())

            when (item.valueDiff.signum()) {
                0 -> {
                    viewBinding.counterDayValueDiff.setTextColor(ContextCompat.getColor(context, R.color.grey))
                    viewBinding.counterDayValueDiff.setEndDrawableRes(null)
                }
                1 -> {
                    viewBinding.counterDayValueDiff.setTextColor(ContextCompat.getColor(context, R.color.red))
                    viewBinding.counterDayValueDiff.setEndDrawableRes(R.drawable.ic_price_up)
                }
                else -> {
                    viewBinding.counterDayValueDiff.setTextColor(ContextCompat.getColor(context, R.color.green))
                    viewBinding.counterDayValueDiff.setEndDrawableRes(R.drawable.ic_price_down)
                }
            }
        }
    }

    companion object {

        private const val VIEW_TYPE_COUNTER = 0
        private const val VIEW_TYPE_HEADER = 1
    }
}