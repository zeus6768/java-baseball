package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    protected static String userGuess;

    protected static void guess() {
        userGuess = Console.readLine();
        validateUserGuess();
    }

    private static void validateUserGuess() {
        if (userGuess.length() != 3) {
            throw new IllegalArgumentException(InputErrorMessage.GUESS);
        }
        if (!isNumeric()) {
            throw new IllegalArgumentException(InputErrorMessage.GUESS);
        }
        if (userGuess.contains("0")) {
            throw new IllegalArgumentException(InputErrorMessage.GUESS);
        }
        if (isDuplicate()) {
            throw new IllegalArgumentException(InputErrorMessage.GUESS);
        }
    }

    private static boolean isNumeric() {
        for (char c : userGuess.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDuplicate() {
        return userGuess.charAt(0) == userGuess.charAt(1)
                || userGuess.charAt(1) == userGuess.charAt(2)
                || userGuess.charAt(2) == userGuess.charAt(0);
    }
}
