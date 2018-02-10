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
            .fold(String()) { acc, token -> acc.plus(token) }
}

fun getSuffix(number: Number): String {
    return number.toString()
            .split(String())
            .filterNot { it.isEmpty() }
            .map { matches.getOrDefault(it.toInt(), it) }
            .fold(String()) { acc, token -> acc.plus(token) }
}

fun compute(number: Number): String {
    val prefix = getPrefix(number)
    val suffix = getSuffix(number)
    return suffix.takeIf({ prefix.isEmpty() }) ?: prefix.plus(suffix.replace(Regex("\\d"), String()))
}
