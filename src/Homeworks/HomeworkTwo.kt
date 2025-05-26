package Homeworks

data class Person(val name: String, val age: Int)

fun main() {
    val people = listOf(
        Person("Петя", 25),
        Person("Вася", 30),
        Person("Даша", 25),
        Person("Женя", 30),
        Person("Алексей", 20),
        Person("Алина", 22),
        Person("Артур", 28),
        Person("Агата", 27),
        Person("Олег", 31),
        Person("Мария", 24),
        Person("Антон", 26),
        Person("Наташа", 29),
        Person("Анастасия", 23),
        Person("Юлия", 27),
        Person("Игорь", 30)
    )

    // Задание 1: Группировка по возрасту
    val groupedByAge = people.groupBy { it.age }

    println("Группировка по возрасту:")
    for ((age, group) in groupedByAge) {
        println("Возраст $age: ${group.size} человек(а)")
    }

    // Задание 2: Фильтрация и группировка по длине имени (имена на "А")
    val namesStartingWithA = people.map { it.name }
        .filter { it.startsWith("А") }
        .groupBy { it.length }

    println("Имена на 'А', сгруппированные по длине:")
    for ((length, group) in namesStartingWithA) {
        println("Длина $length: ${group.joinToString(", ")}")
    }
}
