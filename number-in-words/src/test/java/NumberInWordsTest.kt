import main.java.convert
import org.assertj.core.api.Assertions
import org.junit.Test
import kotlin.test.fail

/**
 * Created by zenika on 15/02/18.
 */
class NumberInWordsTest {


    @Test
    fun oneDollar() {
        Assertions.assertThat(convert(1.0)).isEqualTo("one dollar");
    }

    @Test
    fun twoDollars() {
        Assertions.assertThat(convert(2.0)).isEqualTo("two dollars");
    }


}
