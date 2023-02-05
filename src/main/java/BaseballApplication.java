import model.BaseballGame;
import view.InputView;

public class BaseballApplication {

    public static void main(String[] args) {
        play();
        if (InputView.restart()) {
           play();
        }
    }

    public static void play() {
        BaseballGame game = new BaseballGame();
        game.gameStart();
    }

}
