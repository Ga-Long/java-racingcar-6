package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.FinalWinners;
import racingcar.domain.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final Cars cars = new Cars();
    private int attemptCount;

    public void start() {
        registerCars();
        inputAttemptCount();

        play();
    }

    private void registerCars() {
        String carNames = InputView.carNames();

        cars.registerCars(carNames);
    }

    private void inputAttemptCount() {
        String count = InputView.attemptCount();

        checkNaturalNumber(count);

        setAttemptCount(Integer.parseInt(count));
    }

    private void checkNaturalNumber(String count) {
        Validator.checkNumber(count);
        Validator.isPositiveNum(Integer.parseInt(count));
    }

    private void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public void play() {
        executeGame();
    }

    private void executeGame() {
        OutputView.executionResult();
        playRounds();
        FinalWinners finalWinners = decideWinner();
        OutputView.finalWinner(finalWinners);
    }

    private void playRounds() {
        for (int i = 0; i < attemptCount; i++) {
            Round round = new Round(cars);
            round.play();
        }
    }

    private FinalWinners decideWinner() {
        FinalWinners finalWinners = new FinalWinners();

        finalWinners.decideWinner(cars);

        return finalWinners;
    }
}
