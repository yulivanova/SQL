package ru.netology.web.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.data.SQLHelper;
import ru.netology.web.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.web.data.SQLHelper.cleanDatabase;

public class AuthTest {

    @AfterAll
    public static void tearDown() {
        cleanDatabase();
    }


    @Test
    @DisplayName("Логин с валидными данными")
    void shouldSuccesfull() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = SQLHelper.getRandomVerificationCode();
        verificationPage.validVerify(verificationCode);
    }
}
