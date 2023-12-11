package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {
    private int randomNum;

    public RandomNumber() {
    }

    public void make() {
        randomNum = pickNumberInRange(0, 9);
    }

    public boolean isForward() {
        if (randomNum >= 4) {
            return true;
        }
        return false;
    }
}
