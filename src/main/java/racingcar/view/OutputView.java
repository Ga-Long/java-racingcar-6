package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.FinalWinners;

public class OutputView {
    private static final String EXECUTION_RESULTS = "실행 결과";

    public static void executionResult() {
        System.out.println();
        System.out.println(EXECUTION_RESULTS);
    }

    public static void resultGame(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            printPosition(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public static void finalWinner(FinalWinners winners) {
        System.out.println(winners.toString());
    }
}
