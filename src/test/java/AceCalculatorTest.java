import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AceCalculatorTest {

    @Test
    void mainTest() throws IOException {
        //given
        String input = "3\n10\n16";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String[] args = {};
        //when
        AceCalculator.main(args);

        String[] outputs = outputStream.toString().trim().split(System.lineSeparator());

        //then
        Assertions.assertThat(outputs[0]).isEqualTo("Ace score : 11");
        Assertions.assertThat(outputs[1]).isEqualTo("Ace score : 11");
        Assertions.assertThat(outputs[2]).isEqualTo("Ace score : 1");
    }

    @Test
    void calculateAce_one() {
        //given
        int totalScore = 11;

        //when
        int aceScore = AceCalculator.calculateAce(totalScore);

        //then
        Assertions.assertThat(aceScore).isEqualTo(1);
    }

    @Test
    void calculateAce_eleven() {
        //given
        int totalScore = 10;

        //when
        int aceScore = AceCalculator.calculateAce(totalScore);

        //then
        Assertions.assertThat(aceScore).isEqualTo(11);
    }
}