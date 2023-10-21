package baseball.verifier;

import baseball.system.SystemConstant;
import baseball.system.SystemException;

public class InputVerifier {
    public void checkBallNumber(String isBallNumber) throws IllegalArgumentException {
        checkNumeric(isBallNumber);
        checkRange(isBallNumber);
        checkDistinct(isBallNumber);
        checkHasZero(isBallNumber);
    }

    public void checkGameNumber(String isGameNumber) throws IllegalArgumentException {
        checkNumeric(isGameNumber);
        int intGameNumber = Integer.parseInt(isGameNumber);
        if (intGameNumber != SystemConstant.NEW_GAME && intGameNumber != SystemConstant.END_GAME) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_GAME_NUMBER);
        }
    }

    private void checkNumeric(String isNumeric) {
        try {
            Integer.parseInt(isNumeric);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_NUMERIC);
        }
    }

    private void checkRange(String inRange) {
        if (Integer.parseInt(inRange) < 123 || 987 < Integer.parseInt(inRange)) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_RANGE);
        }
    }

    private void checkHasZero(String inRange) {
        if (inRange.contains("0")) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_HAS_ZERO);
        }
    }

    private void checkDistinct(String isDistinct) {
        if (isDistinct.chars()
                .distinct()
                .count() != SystemConstant.MAXIMUM_DIGIT) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_DISTINCT);
        }
    }
}
