package main.java

val numbers = hashMapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four", 5 to "five", 6 to "six", 10 to "ten", 20 to "twenty")

fun convertIntPart(number: Int): String  {
    val digit = number % 10
    val dozen = number - digit

    var returned = mutableListOf<String>()

    if (dozen > 0) returned.add(numbers.getOrDefault(dozen, ""))

    if (digit > 0) returned.add(numbers.getOrDefault(digit, ""))

    return "${returned.reduce { acc, cur -> acc.plus(" ").plus(cur)} } ${getSuffix(number.toDouble())}"
}

fun convertDecimalPart(number: Double): Int {
    return (number - number.toInt()) * 100
}

fun convert(number: Double): String {
    val intPart = convertIntPart(number.toInt())

    return intPart
}

fun getSuffix(number: Double) = "dollar".takeIf { number <= 1 } ?: "dollars"
