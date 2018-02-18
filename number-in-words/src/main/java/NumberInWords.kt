package main.java

import java.math.BigDecimal

val numbers = hashMapOf(
        0 to "zero",
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four",
        5 to "five",
        6 to "six",
        7 to "seven",
        8 to "eight",
        9 to "nine",
        10 to "ten",
        11 to "eleven",
        12 to "twelve",
        13 to "thirteen",
        14 to "fourteen",
        15 to "fifteen",
        16 to "sixteen",
        17 to "seventeen",
        18 to "eighteen",
        19 to "nineteen",
        20 to "twenty",
        30 to "thirty",
        40 to "forty",
        50 to "fifty",
        60 to "sixty",
        70 to "seventy",
        80 to "eighty",
        90 to "ninety"
)

fun getDecimals(number: Double) = BigDecimal.valueOf(number).divideAndRemainder(BigDecimal.ONE)[1].toFloat() * 100

fun pluralize(token: String) = { n: Int -> token.takeIf { n <= 1 } ?: "${token}s" }

fun hundredWords(digits: List<Int>) = digits
        .zip(listOf("hundred and ", "", ""))
        .map { "${numbers[it.first]} ${it.second}" }
        .filter { !it.matches(Regex("zero.*")) }
        .fold(String()) { acc, str -> acc + str }
        .replace(Regex("and.$"), "")
        .trim()

fun numberPartition(number: Int): List<List<Int>> {
    val parts = mutableListOf<List<Int>>()
    var remainder = number
    do {
        parts.add(hundredPartition(remainder % 1000))
        remainder -= remainder % 1000
        remainder /= 1000
    } while (remainder > 0)
    return parts
}

fun hundredPartition(hundred: Int): List<Int> {
    val tens = hundred % 100
    val units = (tens % 10).takeIf { tens > 20 && tens % 10 != 0 } ?: 0
    val hundreds = (hundred - tens) / 100
    return listOf(hundreds, tens - units, units)
}

fun convert(number: Double): String {
    val cents = getDecimals(number).toInt()
    val dollars = number.toInt()
    val multipliers = listOf("", "thousand,", "million,", "billion,")
    val partition = numberPartition(dollars)
    var words = partition.map { hundredWords(it) }
            .zip(multipliers)
            .filterNot { it.first.isEmpty() }
            .reversed()
            .map { "${it.first} ${it.second} " }
            .fold(String()) { acc, str -> acc + str }
            .replace(Regex(",.$"), "")
            .trim()
    if (dollars > 0) {
        words += pluralize(" dollar")(dollars)
    }
    if (dollars > 0 && cents > 0) {
        words += " and "
    }
    if (cents > 0) {
        words += hundredWords(hundredPartition(cents)) + pluralize(" cent")(cents)
    }
    return words
}


