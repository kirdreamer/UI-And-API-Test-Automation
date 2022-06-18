package helper;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomHelper {

    public String getRandomString(int length, boolean isLettersIncluded, boolean isNumbersIncluded) {
        return RandomStringUtils.random(length, isLettersIncluded, isNumbersIncluded);
    }
}
