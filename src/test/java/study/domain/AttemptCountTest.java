package study.domain;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Validator;

public class AttemptCountTest {
    @DisplayName("시도할 횟수 숫자 입력 예외처리")
    @Test
    void checkNumber() {
        String attemptCount = "ㅇ";

        assertThatThrownBy(() -> {
            Validator.checkNumber(attemptCount);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도할 횟수 양수 입력 예외처리")
    @Test
    void checkPositiveNumber() {
        int attemptCount = -1;

        assertThatThrownBy(() -> {
            Validator.isPositiveNum(attemptCount);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
