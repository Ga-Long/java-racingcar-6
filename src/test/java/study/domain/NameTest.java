package study.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Validator;

public class NameTest {
    @DisplayName("이름 길이 5글자 초과인지 확인")
    @Test
    void checkNameLength() {
        String name = "gahyeon";

        assertThatThrownBy(() -> {
            Validator.checkNameLength(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름에 공백 포함되어 있는지 확인")
    @Test
    void checkNameHasSpace() {
        String name = "ga hyeon";

        assertThatThrownBy(() -> {
            Validator.isSpace(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자 2명이상인지 확인")
    @Test
    void checkNumberOfParticipants() {
        String[] participants = new String[]{"ghlee"};

        assertThatThrownBy(() -> {
            Validator.checkMinimumParticipants(participants);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 중복되어 있는지 확인")
    @Test
    void checkNameDuplicate() {
        String[] names = new String[]{"ghlee", "ghlee"};

        assertThatThrownBy(() -> {
            Validator.isNameDuplicate(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름 앞뒤 공백 제거 확인")
    @Test
    void checkNameTrimSpaces() {
        String carNames = "pobi     ,  woni ,    jun";

        Cars cars = new Cars();
        cars.registerCars(carNames);

        List<Car> carList = cars.getCars();

        assertEquals("pobi", carList.get(0).getName());
        assertEquals("woni", carList.get(1).getName());
        assertEquals("jun", carList.get(2).getName());
    }

}
