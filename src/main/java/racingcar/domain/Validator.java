package racingcar.domain;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "숫자이여야 합니다.";
    private static final String POSITIVE_NUMBER_EXCEPTION_MESSAGE = "양수여야 합니다.";
    private static final String NAME_SPACE_EXCEPTION_MESSAGE = "이름에 공백이 포함되어 있습니다.";
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "이름은 5자 이하이어야 합니다.";
    private static final String MINIMUM_PARTICIPANTS_EXCEPTION_MESSAGE = "참여자는 2명 이상이여야 합니다.";
    private static final String NAME_DUPLICATE_EXCEPTION_MESSAGE = "중복된 이름이 존재합니다: ";


    public static void checkNumber(String attemptCount) {
        try {
            Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    public static void isPositiveNum(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public static void isSpace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(NAME_SPACE_EXCEPTION_MESSAGE);
        }
    }

    public static void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public static void checkMinimumParticipants(String[] names) {
        if (names.length < 2) {
            throw new IllegalArgumentException(MINIMUM_PARTICIPANTS_EXCEPTION_MESSAGE);
        }
    }

    public static void isNameDuplicate(String[] names) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException(NAME_DUPLICATE_EXCEPTION_MESSAGE + name);
            }
        }
    }
}
