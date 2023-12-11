package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.FinalWinners;
import racingcar.service.Register;
import racingcar.service.Round;
import racingcar.view.OutputView;

public class RacingGame {
    private final Cars cars = new Cars();
    private int attemptCount;

    public void start() {
        registerCars();
        play();
    }


    private void registerCars() {
        Register register = new Register();

        register.registerCars(cars);
        attemptCount = register.inputAttemptCount();
    }

    private void play() {
        OutputView.executionResult();
        executeGame();
    }

    private void executeGame() {
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
