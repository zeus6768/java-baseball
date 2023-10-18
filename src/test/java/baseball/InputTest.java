package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {

    @DisplayName("인게임 입력: 정상 입력")
    @Test
    void 정상_입력() {
        String input = "123";
        setInput(input);

        Input.guess();

        assertThat(Input.userGuess).isEqualTo(input);
    }

    protected void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
