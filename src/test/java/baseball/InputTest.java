package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    @Test
    void 게임_정상_입력() {
        String input = "123";
        setInput(input);

        Input.guess();

        assertThat(Input.userGuess).isEqualTo(input);
    }

    @Test
    void 게임_세자리_숫자가_아닌_입력시_예외() {
        String input = "하나둘";    // "하나둘", "#$@", ""
        setInput(input);

        assertThatThrownBy(Input::guess)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputErrorMessage.GUESS);
    }

    @Test
    void 게임_중복된_숫자_입력시_예외() {
        String input = "111";
        setInput(input);

        assertThatThrownBy(Input::guess)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputErrorMessage.GUESS);
    }

    @Test
    void 게임_입력에_0_포함시_예외() {
        String input = "305";   // "012", "890"
        setInput(input);

        assertThatThrownBy(Input::guess)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputErrorMessage.GUESS);
    }


    protected void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
