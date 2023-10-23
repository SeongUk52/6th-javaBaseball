package baseball.verifier;

import baseball.system.SystemConstant;
import baseball.system.SystemException;

public class InputVerifier {
    public static void checkBallNumber(String isBallNumber) throws IllegalArgumentException {
        checkNumeric(isBallNumber);
        checkRange(isBallNumber);
        checkDistinct(isBallNumber);
        checkDigitRange(isBallNumber);
    }

    public static void checkGameNumber(String isGameNumber) throws IllegalArgumentException {
        if (!isGameNumber.equals(SystemConstant.NEW_GAME) && !isGameNumber.equals(SystemConstant.END_GAME)) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_GAME_NUMBER);
        }
    }

    private static void checkNumeric(String isNumeric) {
        try {
            Integer.parseInt(isNumeric);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_NUMERIC);
        }
    }

    private static void checkRange(String inRange) {
        if (inRange.length() != SystemConstant.MAX_DIGIT) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_RANGE);
        }
    }

    private static void checkDigitRange(String inRange) {
        if (inRange.chars()
                .map(Character::getNumericValue)
                .anyMatch(InputVerifier::outOfEachDigitRange)) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_HAS_ZERO);
        }
    }

    private static boolean outOfEachDigitRange(int comp) {
        return comp < SystemConstant.MIN_NUMBER_EACH_DIGIT || comp > SystemConstant.MAX_NUMBER_EACH_DIGIT;
    }

    private static void checkDistinct(String isDistinct) {
        if (isDistinct.chars()
                .distinct()
                .count() != isDistinct.length()) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_DISTINCT);
        }
    }
}
