package study.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Validator;

public class NameTest {
    @Test
    void 이름_5자_초과_예외처리() {
        String name = "gahyeon";

        assertThatThrownBy(() -> {
            Validator.checkNameLength(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_공백_포함_예외처리() {
        String name = "ga hyeon";

        assertThatThrownBy(() -> {
            Validator.isSpace(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 참여자_2명_미만_예외처리() {
        String[] participants = new String[]{"ghlee"};

        assertThatThrownBy(() -> {
            Validator.checkMinimumParticipants(participants);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차_이름_중복_예외처리() {
        String[] names = new String[]{"ghlee", "ghlee"};

        assertThatThrownBy(() -> {
            Validator.isNameDuplicate(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_앞뒤_공백_제거() {
        String carNames = "pobi     ,  woni ,    jun";

        Cars cars = new Cars();
        cars.registerCars(carNames);

        List<Car> carList = cars.getCars();

        assertEquals("pobi", carList.get(0).getName());
        assertEquals("woni", carList.get(1).getName());
        assertEquals("jun", carList.get(2).getName());
    }

}
