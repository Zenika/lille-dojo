import main.java.convert
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.Test
import kotlin.test.fail

/**
 * Created by zenika on 15/02/18.
 */
class NumberInWordsTest {


    @Test
    fun `one dollar`() {
        assertThat(convert(1.0)).isEqualTo("one dollar")
    }

    @Test
    fun `assert two dollars`() {
        assertThat(convert(2.0)).isEqualTo("two dollars")
    }

    @Test
    fun `assert ten dollars`() {
        assertThat(convert(10.0)).isEqualTo("ten dollars")
    }

    @Test
    fun `assert twenty dollars`() {
        assertThat(convert(20.0)).isEqualTo("twenty dollars")
    }

    @Test
    fun `assert twenty one dollars`() {
       assertThat(convert(21.0)).isEqualTo("twenty one dollars")
    }


    @Test
    fun `assert twenty one dollars and twenty cents`() {
        assertThat(convert(21.2)).isEqualTo("twenty one dollars and twenty cents")
    }

    @Test
    fun `assert eleven dollars and twenty cents`() {
        assertThat(convert(11.2)).isEqualTo("eleven dollars and twenty cents")
    }

    @Test
    fun `assert one hundred dollars and forty five cents`() {
        assertThat(convert(100.45)).isEqualTo("one hundred dollars and forty five cents")
    }

    @Test
    fun `four hundred and fifty six dollars and twenty three cents`() {
        assertThat(convert(456.23)).isEqualTo("four hundred and fifty six dollars and twenty three cents")
    }

    @Test
    fun `assert one thousand dollars`() {
        assertThat(convert(1E3)).isEqualTo("one thousand dollars")
    }

    @Test
    fun `assert one hundred thousand dollars`() {
        assertThat(convert(1E5)).isEqualTo("one hundred thousand dollars")
    }

    @Test
    fun `assert one million dollars`() {
        assertThat(convert(1E6)).isEqualTo("one million dollars")
    }

    @Test
    fun `assert one billion dollars`() {
        assertThat(convert(1E9)).isEqualTo("one billion dollars")
    }

}
