package adeldolgov.emeter.counters.domain.entities

import java.math.BigDecimal

/*
*@author Adel Dolgov on 28,Ноябрь,2021
*/
class Counter(
    val id: String,
    val name: String,
    val value: BigDecimal,
    val price: BigDecimal,
    val valueDiff: BigDecimal,
    val type: CounterType,
)