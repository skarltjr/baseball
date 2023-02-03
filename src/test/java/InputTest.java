import model.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTest {
    @Test
    @DisplayName("수 입력 - 입력된 숫자는 3자리여야한다.")
    void checkNumberInputLength(){
        String target = "1234";
        String exceptionMessage = assertThrows(IllegalArgumentException.class, () -> {
            new Input(target);
        }).getMessage();

        assertThat(exceptionMessage).isEqualTo(Input.NUMBER_RANGE_MESSAGE);
    }

    @Test
    @DisplayName("수 입력 - 입력된 숫자는 1~9 이내의 숫자여야한다")
    void checkNumberRange(){
        String target = "012";
        String exceptionMessage = assertThrows(IllegalArgumentException.class, () -> {
            new Input(target);
        }).getMessage();

        assertThat(exceptionMessage).isEqualTo(Input.NUMBER_RANGE_MESSAGE);
    }

    @Test
    void createInput(){
        String target = "123";
        Input input = new Input(target);
        List<Integer> numbers = input.getInputNumbers();

        assertThat(numbers.size()).isEqualTo(3);
        numbers.forEach(number -> assertRange(number));

    }

    private void assertRange(Integer number) {
        assertThat(number).isGreaterThanOrEqualTo(Input.MIN_INPUT_NUMBER_RANGE);
        assertThat(number).isLessThanOrEqualTo(Input.MAX_INPUT_NUMBER_RANGE);

    }
}
