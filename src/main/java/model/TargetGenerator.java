package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TargetGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int ZERO = 0;
    private static final int TARGET_LENGTH = 3;
    private static final List<Integer> candidates = new ArrayList<>();
    public static Target createTarget() {
        createCandidates();
        shuffleCandidates();
        return new Target(candidates.subList(ZERO,TARGET_LENGTH));
    }

    private static void createCandidates() {
        if (!candidates.isEmpty()) {
            candidates.clear();
        }

        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            candidates.add(i);
        }
    }

    private static void shuffleCandidates() {
        Collections.shuffle(candidates);
    }
}
