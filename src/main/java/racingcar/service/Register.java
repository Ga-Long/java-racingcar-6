package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.Validator;
import racingcar.view.InputView;

public class Register {

    public void registerCars(Cars cars) {
        String carNames = InputView.carNames();

        cars.registerCars(carNames);
    }

    public int inputAttemptCount() {
        String count = InputView.attemptCount();

        checkNaturalNumber(count);

        return Integer.parseInt(count);
    }

    private void checkNaturalNumber(String count) {
        Validator.checkNumber(count);
        Validator.isPositiveNum(Integer.parseInt(count));
    }

}
