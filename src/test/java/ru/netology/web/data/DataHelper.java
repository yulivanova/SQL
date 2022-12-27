package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

public class DataHelper {
    private static Faker faker = new Faker();

    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getRandomVerificationCode() {
        return new VerificationCode(faker.numerify("#####"));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthCode {
        private String id;
        private String user_id;
        private String code;
        private String created;
    }
}



