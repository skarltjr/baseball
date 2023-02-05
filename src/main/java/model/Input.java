package model;

import exceptions.NotValidException;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final int MAX_RANGE = 3;
    private static final int RESTART_GAME = 1;
    public static final int MIN_INPUT_NUMBER_RANGE = 1;
    public static final int MAX_INPUT_NUMBER_RANGE = 9;

    private List<Integer> inputNumbers;

    // 책임은 2가지다
    // 1. 문자열 숫자를 전달받고 이를 검증 후 결과값을 담은 input을 반환한다..
    // 2. 게임 재시작 or 종료를 판단한다.


    public Input(String inputs) {
        checkInputsLength(inputs);
        this.inputNumbers = inputStringToNumbers(inputs);
    }

    public List<Integer> getInputNumbers() {
        return inputNumbers;
    }

    private List<Integer> inputStringToNumbers(String inputs) {
        // 삽입 최대 3개 but 조회 빈번 -> arrayList
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < inputs.length(); i++) {
            int target = inputs.charAt(i) - '0';
            validateNumberRange(target);
            numbers.add(target);
        }

        return numbers;
    }

    private void validateNumberRange(int target) {
        if (target < MIN_INPUT_NUMBER_RANGE || target > MAX_INPUT_NUMBER_RANGE) {
            throw new NotValidException();
        }
    }

    private void checkInputsLength(String inputs) {
        if (inputs.length() != MAX_RANGE) {
            throw new NotValidException();
        }
    }


    public static boolean checkIfRestart(int input) {
        return input == RESTART_GAME;
    }
}
