package main.java

fun main(args: Array<String>) {
    println("FooBarQix (run tests)")
}

val matches = hashMapOf(3 to "foo", 5 to "bar", 7 to "qix", 0 to "*")

fun getPrefix(number: Number): String {
    return matches.keys
            .filterNot { it == 0 }
            .filter { number.toInt() % it == 0 }
            .sorted()
            .map { matches[it] }
            .fold(String()) { acc, k -> acc.plus(k) }
}

fun getSuffix(number: Number): String {
    return number.toString()
            .split(String())
            .filterNot { it.isEmpty() }
            .map { matches.getOrDefault(it.toInt(), it) }
            .fold(String()) { acc, k -> acc.plus(k) }
}

fun compute(number: Number): String {
    return getSuffix(number)
            .takeIf({ getPrefix(number).isEmpty() }) ?:
                getPrefix(number).plus(getSuffix(number).replace(Regex("\\d"), String()))
}
