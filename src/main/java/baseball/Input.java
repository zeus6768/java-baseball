package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    protected static String userGuess;

    protected static void guess() {
        userGuess = Console.readLine();
    }
}
