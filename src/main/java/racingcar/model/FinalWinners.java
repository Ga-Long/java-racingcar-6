package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class FinalWinners {
    private final List<Car> winners = new ArrayList<>();

    public void decideWinner(Cars cars) {
        int maxPosition = -1;

        for (Car car : cars.getCars()) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car);
            } else if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            result.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                result.append(", "); // 쉼표로 구분 (마지막 우승자 뒤에는 쉼표를 추가하지 않음)
            }
        }

        return result.toString();
    }
}
