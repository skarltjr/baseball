package model;
import view.InputView;
import view.OutputView;



public class BaseballGame {
    private boolean isEnd;

    public BaseballGame() {
        this.isEnd = false;
    }

    public void gameStart() {
        Target target = TargetGenerator.createTarget();

        while (!isEnd) {
            Input input = InputView.inputNumber();
            Result result = ResultDiscriminator.discriminate(input, target);
            if (result.ifWin()) {
                isEnd = true;
            }

            OutputView.printResult(result);
        }

    }
}
