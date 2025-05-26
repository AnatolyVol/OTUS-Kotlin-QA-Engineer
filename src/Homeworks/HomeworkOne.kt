package Homeworks

fun <I, O> transformCollection(
    collection: Collection<I>, transform: (I) -> O): List<O> {
    val transformedList = mutableListOf<O>()
    for (item in collection) {
        transformedList.add(transform(item))
    }
    return transformedList
}

fun <I, O> transformCollectionTwo(
    collection: Collection<I>,
    transform: (I) -> O
): List<O> = collection.map(transform)

fun intToDouble(n: Int) = n.toDouble()

fun main() {
    val names = listOf("Иван", "Анна", "Александр")
    val uppercaseNames = transformCollection(names) {it.uppercase()}
    println(uppercaseNames)

    val numbers = listOf(1, 5, 9)
    val doubleNumbers = transformCollectionTwo(numbers, ::intToDouble)
    println(doubleNumbers)
}