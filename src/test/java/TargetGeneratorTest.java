import model.Target;
import model.TargetGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetGeneratorTest {
    @Test
    @DisplayName("생성된 결과물은 3자리수다")
    void digitsToBe3() {
        Target target = TargetGenerator.createTarget();
        List<Integer> numbers = target.getNumbers();

        assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("생성된 결과물에 중복된수는 없어야한다.")
    void noDuplication() {
        Set<Integer> createdValues = new HashSet<>();

        for (int i = 0; i < 1000; i++) {
            Target target = TargetGenerator.createTarget();
            createdValues.addAll(target.getNumbers());

            assertThat(createdValues).hasSize(3);
            createdValues.clear();
        }
    }

    @Test
    @DisplayName("생성된 결과물엔 0이란 숫자는 없어야한다.")
    void doNotContainZero() {
        for (int i = 0; i < 1000; i++) {
            Target target = TargetGenerator.createTarget();
            assertThat(target.getNumbers()).doesNotContain(Integer.valueOf(0));
        }
    }

}
