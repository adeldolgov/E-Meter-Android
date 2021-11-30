package adeldolgov.emeter.counters.presentation.adapter

import adeldolgov.emeter.R
import adeldolgov.emeter.counters.domain.entities.Counter
import adeldolgov.emeter.counters.domain.entities.CounterType
import androidx.annotation.ColorRes
import javax.inject.Inject

/*
*@author Adel Dolgov on 28,Ноябрь,2021
*/
internal class CounterToItemMapper @Inject constructor() : (List<Counter>) -> (List<CounterItem>) {

    override fun invoke(list: List<Counter>): List<CounterItem> {
        return list.map {
            CounterItem(
                id = it.id,
                name = it.name,
                value = it.value,
                price = it.price,
                valueDiff = it.valueDiff,
                color = extractColorByCounterType(it.type)
            )
        }
    }

    @ColorRes
    private fun extractColorByCounterType(counterType: CounterType): Int {
        return when (counterType) {
            CounterType.HOT -> R.color.red
            CounterType.COLD -> R.color.blue
            CounterType.ELECTRIC -> R.color.teal_200
        }
    }
}