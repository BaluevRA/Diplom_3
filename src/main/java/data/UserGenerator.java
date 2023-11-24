package data;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static User generateUser() {
        return new User()
                .withEmail(RandomStringUtils.randomAlphabetic(8) + "@gmail.com")
                .withPassword(RandomStringUtils.randomAlphabetic(10))
                .withName(RandomStringUtils.randomAlphabetic(8));
    }

    public static User generateUserWithInvalidData() {
        return new User()
                .withEmail(RandomStringUtils.randomAlphabetic(8) + "@gmail.com")
                .withPassword(RandomStringUtils.randomAlphabetic(1))
                .withName(RandomStringUtils.randomAlphabetic(8));
    }
}
