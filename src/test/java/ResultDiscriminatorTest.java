import model.Input;
import model.Result;
import model.ResultDiscriminator;
import model.Target;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultDiscriminatorTest {

    private Target target;
    @BeforeEach
    void setUp() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        target = new Target(numbers);
    }
    @Test
    @DisplayName("수와 위치가 동일하면 strike")
    void strike() {
        Input input = new Input("149");
        Result result = ResultDiscriminator.discriminate(input, target);
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("수는 동일하지만 위치가 다르면 ball")
    void ball() {
        Input input = new Input("231");
        Result result = ResultDiscriminator.discriminate(input, target);
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("동일한 수가 하나도 없는 경우")
    void nothing() {
        Input input = new Input("456");
        Result result = ResultDiscriminator.discriminate(input, target);
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("완전일치 = 3 strike 0 ball")
    void end() {
        Input input = new Input("123");
        Result result = ResultDiscriminator.discriminate(input, target);
        assertThat(result.getStrikeCount()).isEqualTo(3);
        assertThat(result.getBallCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("입력 숫자가 모두 동일한 숫자면서 하나만 위치가 동일한 경우")
    void sameInputNumberAndOnlyOneSameLocation() {
        Input input = new Input("111");
        Result result = ResultDiscriminator.discriminate(input, target);
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(2);
    }

}
