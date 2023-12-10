package study.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.FinalWinners;

public class GameResultTest {

    @Test
    void 단독_우승_출력() {
        Cars cars = new Cars();

        String carNames = "pobi, jun";
        cars.registerCars(carNames);

        Car car1 = cars.getCars().get(0);
        car1.forward();

        FinalWinners finalWinners = new FinalWinners();
        finalWinners.decideWinner(cars);

        assertEquals("최종 우승자 : pobi", finalWinners.toString());
    }

    @Test
    void 공동_우승_출력() {
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
