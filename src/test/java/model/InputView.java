package model;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_IF_RESTART_MESSAGE = "게임을 새로 시작하려면 0, 종료하려면 -1을 입력해주세요";
    private static final Scanner scanner = new Scanner(System.in);

    public static Input inputNumber() {
        System.out.println(INPUT_NUMBER_MESSAGE);
        return new Input(scanner.next());
    }

    public static boolean restart() {
        System.out.println(INPUT_IF_RESTART_MESSAGE);
        return Input.checkIfRestart(scanner.nextInt());
    }
}
