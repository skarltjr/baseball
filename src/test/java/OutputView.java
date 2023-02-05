import model.Result;

public class OutputView {
    private static final String STRIKE = " 스트라이크 ";
    private static final String BALL = " 볼 ";
    private static final String NOTHING = " 낫띵 ";
    private static final String END = " 정답입니다. ";

    public static String getResultMessage(Result result) {
        StringBuilder resultMessage = new StringBuilder();

        if (result.ifWin()) {
            resultMessage.append(END);
            return resultMessage.toString();
        }

        if (result.isNothing()) {
            resultMessage.append(NOTHING);
            return resultMessage.toString();
        }

        resultMessage.append(result.getStrikeCount()).append(STRIKE);
        resultMessage.append(result.getBallCount()).append(BALL);
        return resultMessage.toString();
    }
}
