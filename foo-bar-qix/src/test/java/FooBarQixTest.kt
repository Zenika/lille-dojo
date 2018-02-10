import main.java.compute
import main.java.getPrefix
import main.java.getSuffix
import org.assertj.core.api.Assertions
import org.junit.Test

/**
 * Created by zenika on 08/02/18.
 */
class FooBarQixTest {

    @Test
    fun computeWorksWith1() {
        Assertions.assertThat(compute(1)).isEqualTo("1")
    }

    @Test
    fun computeWorksWith3() {
        Assertions.assertThat(compute(3)).isEqualTo("foofoo")
    }

    @Test
    fun computeWorksWith9() {
        Assertions.assertThat(compute(9)).isEqualTo("foo")
    }

    @Test
    fun computeWorksWith5() {
        Assertions.assertThat(compute(5)).isEqualTo("barbar")
    }

    @Test
    fun computeWorksWith15() {
        Assertions.assertThat(compute(15)).isEqualTo("foobarbar")
    }


    @Test
    fun computeWorksWith10() {
        Assertions.assertThat(compute(10)).isEqualTo("bar*")
    }

    @Test
    fun computeWorksWith7() {
        Assertions.assertThat(compute(7)).isEqualTo("qixqix")
    }

    @Test
    fun computeWorksWith101() {
        Assertions.assertThat(compute(101)).isEqualTo("1*1")
    }

    @Test
    fun computeWorksWith105() {
        Assertions.assertThat(compute(105)).isEqualTo("foobarqix*bar")
    }
}
