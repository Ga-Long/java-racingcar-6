package study.service;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.controller.Round;
import racingcar.model.Cars;

public class GamePlayTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 랜덤값_4이상_전진() {
        String carNames = "pobi,woni,jun";
        Cars cars = new Cars();
        cars.registerCars(carNames);

        assertRandomNumberInRangeTest(
                () -> {
                    Round round = new Round(cars);
                    round.createRandom();

                    assertEquals(0, cars.getCars().get(0).getPosition());
                    assertEquals(1, cars.getCars().get(1).getPosition());
                    assertEquals(1, cars.getCars().get(2).getPosition());
                },
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );

    }
}
