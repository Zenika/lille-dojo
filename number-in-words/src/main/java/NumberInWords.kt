package main.java

fun convert(number: Double): String {
    val numbers = hashMapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four", 5 to "five", 6 to "six", 10 to "ten", 20 to "twenty")
    val digit = number.toInt() % 10
    val dozen = number - digit

    return "${numbers.getOrDefault(dozen.toInt(), "")} ${numbers.getOrDefault(digit, "")} ${getSuffix(number)}"
}

fun getSuffix(number: Double) = "dollar".takeIf { number <= 1 } ?: "dollars"
