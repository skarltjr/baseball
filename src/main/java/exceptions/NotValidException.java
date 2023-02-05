package exceptions;

public class NotValidException extends RuntimeException {
    public static final String NUMBER_RANGE_MESSAGE = "1부터 9까지 숫자를 활용하여 3자리수를 입력해주세요.";

    public NotValidException() {
        super(NUMBER_RANGE_MESSAGE);
    }
}
