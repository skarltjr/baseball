package model;

public class Result {
    // todo 하드코딩 상수 중복 정리 필요
    private int ballCount;
    private int strikeCount;
    private static final int MAX_STRIKE_COUNT = 3;
    private static final int ZERO = 0;

    public Result(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }


    public boolean ifWin() {
        return strikeCount == MAX_STRIKE_COUNT && ballCount == ZERO ? true : false;
    }

    public boolean isNothing() {
        return ballCount == ZERO && strikeCount == ZERO ? true : false;
    }
}
