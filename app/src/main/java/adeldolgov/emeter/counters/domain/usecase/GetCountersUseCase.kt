package adeldolgov.emeter.counters.domain.usecase

import adeldolgov.emeter.counters.domain.entities.Counter
import adeldolgov.emeter.counters.domain.entities.CounterType
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.math.BigDecimal
import java.util.concurrent.TimeUnit
import javax.inject.Inject

interface GetCountersUseCase {

    operator fun invoke(): Observable<List<Counter>>
}

internal class GetCountersUseCaseImpl @Inject constructor() : GetCountersUseCase {

    override fun invoke(): Observable<List<Counter>> {
        return Observable.fromCallable { createTestCounters() }
            .delay(1500, TimeUnit.MILLISECONDS, Schedulers.io())
    }

    private fun createTestCounters(): List<Counter> {
        return listOf(
            Counter(
                id = "c-1",
                name = "ХВС v.0.95",
                value = BigDecimal.valueOf(14.751),
                price = BigDecimal.valueOf(624),
                valueDiff = BigDecimal.valueOf(-0.75),
                type = CounterType.COLD
            ),
            Counter(
                id = "c-2",
                name = "ГВС v.0.95",
                value = BigDecimal.valueOf(10),
                price = BigDecimal.valueOf(2050),
                valueDiff = BigDecimal.valueOf(-1.521),
                type = CounterType.HOT
            ),
            Counter(
                id = "c-3",
                name = "ГВС v.0.95.\nВторая кв.",
                value = BigDecimal.valueOf(4),
                price = BigDecimal.valueOf(820),
                valueDiff = BigDecimal.valueOf(1.074),
                type = CounterType.HOT
            ),
            Counter(
                id = "c-1-4",
                name = "ХВС v.0.95",
                value = BigDecimal.valueOf(5),
                price = BigDecimal.valueOf(220),
                valueDiff = BigDecimal.valueOf(0),
                type = CounterType.COLD
            ),
        )
    }
}