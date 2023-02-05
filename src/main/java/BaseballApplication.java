import model.BaseballGame;
import view.InputView;

public class BaseballApplication {

    public static void main(String[] args) {
        play();
    }

    public static void play() {
        BaseballGame game = new BaseballGame();
        game.gameStart();
        if (InputView.restart()) {
            play();
        }
    }

}
