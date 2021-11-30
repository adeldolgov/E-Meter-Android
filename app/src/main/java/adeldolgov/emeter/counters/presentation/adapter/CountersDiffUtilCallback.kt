package adeldolgov.emeter.counters.presentation.adapter

import androidx.recyclerview.widget.DiffUtil

internal class CountersDiffUtilCallback : DiffUtil.ItemCallback<CounterItem>() {

    override fun areItemsTheSame(oldItem: CounterItem, newItem: CounterItem): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CounterItem, newItem: CounterItem): Boolean = oldItem == newItem
}