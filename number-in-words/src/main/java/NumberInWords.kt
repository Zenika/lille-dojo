package main.java

val numbers = hashMapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four", 5 to "five", 6 to "six", 10 to "ten", 20 to "twenty")

fun convertIntPart(number: Int): String  {
    val digit = number % 10
    val dozen = number - digit

    var returned: String = ""

    if (dozen > 0){

        returned += numbers.get(dozen)

        if (digit > 0) returned += " "
    }

    if (digit > 0) returned += numbers.get(digit)

    return "${returned} ${getSuffix(number.toDouble())}"
}
fun convert(number: Double): String {
    return convertIntPart(number.toInt())
}

fun getSuffix(number: Double) = "dollar".takeIf { number <= 1 } ?: "dollars"
