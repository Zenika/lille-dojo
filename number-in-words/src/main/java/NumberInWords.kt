package main.java

fun convert(number: Double): String? {
    val numbers = hashMapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four", 5 to "five", 6 to "six")
    return numbers[number.toInt()] + getSuffix(number)
}

fun getSuffix(number: Double): String {
    return " dollar".takeIf { number <= 1 } ?: " dollars";
}
