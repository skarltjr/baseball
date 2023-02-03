import model.Input;
import model.Target;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultDiscriminatorTest {

    private Target target;
    private ResultDiscriminator discriminator;
    @BeforeEach
    void setUp() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        target = new Target(numbers);
        discriminator = new ResultDiscriminator();
    }
    @Test
    @DisplayName("수와 위치가 동일하면 strike")
    void strike() {
        Input input = new Input("149");
        Result result = discriminator.discriminate(input, target);

    }

    @Test
    @DisplayName("수는 동일하지만 위치가 다르면 ball")
    void ball() {

    }

    @Test
    @DisplayName("동일한 수가 하나도 없다면 nothing")
    void nothing() {

    }

    @Test
    @DisplayName("완전히 일치하면 종료")
    void end() {

    }

    public class ResultDiscriminator {
        public Result discriminate(Input input, Target target) {


            return null;
        }
    }

    public class Result {
        private int ballCount;
        private int strikeCount;
        private static final String NOTHING = "nothing";

        public Result(int ballCount,int strikeCount) {
            this.ballCount = ballCount;
            this.strikeCount = strikeCount;
        }

        public String getResult() {
            if (strikeCount == 0 && ballCount == 0){
                return NOTHING;
            }

            return makeResultMessage(ballCount, strikeCount);
        }

        private String makeResultMessage(int ballCount, int strikeCount) {
            return null;
        }

    }
}
