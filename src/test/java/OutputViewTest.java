import model.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    @Test
    @DisplayName("Result 결과를 화면에 보여준다")
    void viewResult() {
        Result result = new Result(1, 2);
        String resultMessage = OutputView.getResultMessage(result);
        assertThat(resultMessage).isEqualTo("2 스트라이크 1 볼 ");
    }

    @Test
    @DisplayName("Result 결과를 화면에 보여준다 - 승리")
    void viewResult_win() {
        Result result = new Result(0, 3);
        String resultMessage = OutputView.getResultMessage(result);
        assertThat(resultMessage).isEqualTo(" 정답입니다. ");
    }
    @Test
    @DisplayName("Result 결과를 화면에 보여준다")
    void viewResult_nothing() {
        Result result = new Result(0,0);
        String resultMessage = OutputView.getResultMessage(result);
        assertThat(resultMessage).isEqualTo(" 낫띵 ");
    }


}
