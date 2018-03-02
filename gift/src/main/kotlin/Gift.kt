package main.java

fun main(args: Array<String>) {
    println("It works")
}

fun canPay(cost: Int, available: List<Int>): Int {
    val total = available.sum()
    if (total < cost) {
        return -1
    }
    if (total == cost) {
        return 0
    }
    return 1
}

fun calculateGift(cost: Int, available: List<Int>): List<Int> {
    val canPay = canPay(cost, available)

    if (canPay < 0) {
        throw RuntimeException()
    }
    if (canPay == 0) {
        return available
    }

    if(available.size == 1) {
        return listOf(cost)
    }

    return arrayListOf(available[0])
            .addAll(
            calculateGift(
            cost-available[0],
            available.slice(1 until available.size)))

}