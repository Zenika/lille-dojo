package main.kotlin


fun calculateGift(cost: Int, available: List<Int>): List<Int> {
    if (available.sum() < cost) {
        throw RuntimeException()
    }
    val gathered = mutableListOf<Int>()
    for (i in 0 until available.size) {
        val remainingParticipantsNumber = available.size - i
        val remainingCost = cost - gathered.sum()
        if (remainingParticipantsNumber * available[i] > remainingCost) {
            // remaining participants will not pay all of their money
            val m = remainingCost / remainingParticipantsNumber
            return gathered +
                    List(remainingParticipantsNumber - remainingCost % remainingParticipantsNumber, { _ -> m }) +
                    List(remainingCost % remainingParticipantsNumber, { _ -> m + 1 })
        }
        // current participant must pay all of their money
        gathered.add(available[i])
    }
    return gathered
}

fun recursivecalculateGift(cost: Int, available: List<Int>): List<Int> {
    if (available.sum() < cost) {
        throw RuntimeException()
    }
    val participantsNumber = available.size
    if (participantsNumber * available[0] < cost) {
        return listOf(available[0]) + recursivecalculateGift(cost - available[0], available.subList(1, available.size))
    }
    return List(participantsNumber, {i -> cost / participantsNumber + if (i < participantsNumber - cost % participantsNumber) 0 else 1})
}