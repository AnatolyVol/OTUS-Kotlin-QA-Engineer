package Homeworks

fun <I, O> transformCollection(
    collection: Collection<I>, transform: (I) -> O): List<O> {
    val transformedList = mutableListOf<O>()
    for (item in collection) {
        transformedList.add(transform(item))
    }
    return transformedList
}

fun main() {
    val names = listOf("Иван", "Анна", "Александр")
    val uppercaseNames = transformCollection(names) {it.uppercase()}
    println(uppercaseNames)
}