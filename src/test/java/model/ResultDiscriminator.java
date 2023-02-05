package model;

import java.util.HashSet;
import java.util.List;

public class ResultDiscriminator {
    public static Result discriminate(Input input, Target target) {
        HashSet<Integer> targetNumberSet = new HashSet<>();
        List<Integer> targetNumbers = target.getNumbers();
        List<Integer> inputNumbers = input.getInputNumbers();
        int strikeCount = 0;
        int ballCount = 0;

        for (Integer number : targetNumbers) {
            targetNumberSet.add(number);
        }

        for (int i = 0; i < inputNumbers.size(); i++) {
            Integer currentInputNumber = inputNumbers.get(i);
            if (currentInputNumber == targetNumbers.get(i)) {
                strikeCount++;
                continue;
            }
            if (targetNumberSet.contains(currentInputNumber)) {
                ballCount++;
            }
        }

        return new Result(ballCount,strikeCount);
    }
}
