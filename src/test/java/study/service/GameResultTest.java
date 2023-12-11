package study.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.FinalWinners;

public class GameResultTest {

    @DisplayName("단독 우승자 출력")
    @Test
    void printSoleWinner() {
        Cars cars = new Cars();

        String carNames = "pobi, jun";
        cars.registerCars(carNames);

        Car car1 = cars.getCars().get(0);
        car1.forward();

        FinalWinners finalWinners = new FinalWinners();
        finalWinners.decideWinner(cars);

        assertEquals("최종 우승자 : pobi", finalWinners.toString());
    }

    @DisplayName("공동 우승자 출력")
    @Test
    void printJointWinner() {
        Cars cars = new Cars();

        String carNames = "pobi, jun";
        cars.registerCars(carNames);

        Car car1 = cars.getCars().get(0);
        car1.forward();
        Car car2 = cars.getCars().get(1);
        car2.forward();

        FinalWinners finalWinners = new FinalWinners();
        finalWinners.decideWinner(cars);

        assertEquals("최종 우승자 : pobi, jun", finalWinners.toString());
    }
}
