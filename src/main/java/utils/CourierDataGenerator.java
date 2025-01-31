package utils;

import model.Courier;
import org.apache.commons.lang3.RandomStringUtils;

public class CourierDataGenerator {
    public static Courier getRandomCourierDataLoginPasswordFirstName() {
        String login = RandomStringUtils.randomAlphabetic(6);
        String password = RandomStringUtils.randomAlphanumeric(6);
        String firstName = RandomStringUtils.randomAlphabetic(6);

        return new Courier(login, password, firstName);
    }

    public static Courier getRandomCourierDataPasswordFirstNameEmptyLogin() {
        String password = RandomStringUtils.randomAlphanumeric(6);
        String firstName = RandomStringUtils.randomAlphabetic(6);

        return new Courier("", password, firstName);
    }

    public static Courier getRandomCourierDataLoginFirstNameEmptyPassword() {
        String login = RandomStringUtils.randomAlphabetic(6);
        String firstName = RandomStringUtils.randomAlphabetic(6);

        return new Courier(login, "", firstName);
    }

    public static Courier getRandomCourierDataLoginPassword() {
        String login = RandomStringUtils.randomAlphabetic(6);
        String password = RandomStringUtils.randomAlphanumeric(6);

        return new Courier(login, password);
    }

    public static Courier getRandomCourierDataLoginEmptyPassword() {
        String login = RandomStringUtils.randomAlphabetic(6);

        return new Courier(login, "");
    }

    public static Courier getRandomCourierDataEmptyLoginPassword() {
        String password = RandomStringUtils.randomAlphanumeric(6);

        return new Courier("", password);
    }
}
