package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RandomNumber;
import racingcar.view.OutputView;

public class Round {
    private final Cars cars;

    public Round(Cars cars) {
        this.cars = cars;
    }

    public void play() {
        createRandom();
        OutputView.resultGame(cars.getCars());
    }

    public void createRandom() {
        RandomNumber randomNumber = new RandomNumber();

        for (Car car : cars.getCars()) {
            randomNumber.make();
            if (randomNumber.isForward()) {
                car.forward();
            }
        }
    }
}
