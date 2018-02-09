import main.java.compute
import org.assertj.core.api.Assertions
import org.junit.Test

/**
 * Created by zenika on 08/02/18.
 */
class KataTest {

    @Test
    fun works_with_1() {
        Assertions.assertThat(compute(1)).isEqualTo("1")
    }

    @Test
    fun works_with_3() {
        Assertions.assertThat(compute(3)).isEqualTo("foofoo")
    }

    @Test
    fun works_with_9() {
        Assertions.assertThat(compute(9)).isEqualTo("foo")
    }

    @Test
    fun works_with_5() {
        Assertions.assertThat(compute(5)).isEqualTo("barbar")
    }

    @Test
    fun works_with_15() {
        Assertions.assertThat(compute(15)).isEqualTo("foobarbar")
    }


    @Test
    fun works_with_10() {
        Assertions.assertThat(compute(10)).isEqualTo("bar*")
    }

    @Test
    fun works_with_7 () {
        Assertions.assertThat(compute(7)).isEqualTo("qixqix")
    }

    @Test
    fun works_with_101 () {
        Assertions.assertThat(compute(101)).isEqualTo("1*1")
    }

    @Test
    fun works_with_105() {
        Assertions.assertThat(compute(105)).isEqualTo("foobarqix*bar")
    }
}