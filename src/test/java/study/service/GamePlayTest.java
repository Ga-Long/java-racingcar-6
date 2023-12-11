package study.service;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGame.Round;
import racingcar.domain.Cars;

public class GamePlayTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("랜덤값 4 이상이면 전진")
    @Test
    void ForwardIfFourOrMore() {
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
