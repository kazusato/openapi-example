import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NullableTest {

    @Test
    fun testNullable() {
        val str : String? = null
        val result = str.isNullOrEmpty()
        assertThat(result).isTrue()
    }

}