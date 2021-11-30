package adeldolgov.emeter.common.extensions

fun <T> lazyUnsafe(initializer: () -> T): Lazy<T> =
    lazy(LazyThreadSafetyMode.NONE, initializer)

