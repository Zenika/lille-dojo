package test.java

import main.kotlin.calculateGift
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.Ignore
import org.junit.Test

/**
 * Created by zenika on 22/02/18.
 */
class GiftTest {
/*    @Test
    fun `should return 'equals' if there is enough money`() {
        assertThat(canPay(100, listOf(100))).isEqualTo(0)
    }

    @Test
    fun `should return 'neg' if there is ,ot enough money`() {
        assertThat(canPay(200, listOf(100))).isEqualTo(-1)
    }

    @Test
    fun `should return 'pos' if there is enough money with 2 resources`() {
        assertThat(canPay(100, listOf(80,30))).isEqualTo(1)
    }

    @Test
    fun `should return 'neg' if list is empty`() {
        assertThat(canPay(1, emptyList())).isEqualTo(-1)
    }
*/
    @Test
    fun `should return an array with one resource`() {
        assertThat(calculateGift(100, listOf(100))).isEqualTo(listOf(100))
    }

    @Test(expected = RuntimeException::class)
    fun `should throw an exception if not enough money available`() {
        calculateGift(100, listOf(20))
    }

    @Test
    fun `should return an array with one resource if too much money`() {
        assertThat(calculateGift(100, listOf(150))).isEqualTo(listOf(100))
    }

    @Test
    fun `should return an array with two resources if enough money`() {
        assertThat(calculateGift(100, listOf(40,60))).isEqualTo(listOf(40,60))
    }

    @Test
    fun `should return an array with two resources if too much money`() {
        assertThat(calculateGift(100, listOf(40,70))).isEqualTo(listOf(40,60))
    }

    @Test
    fun `should return an array with two resources if too much money 2`() {
        assertThat(calculateGift(100, listOf(30,80))).isEqualTo(listOf(30,70))
    }

    @Test
    fun `should return an array with two resources if too much money 3`() {
        assertThat(calculateGift(28, listOf(10, 10, 10))).isEqualTo(listOf(9, 9, 10))
    }
}