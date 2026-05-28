package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

@Feature("Kullanıcı Girişi")
public class LoginTest extends BaseTest {

    @Test
    @Description("Geçerli kimlik bilgileriyle başarılı giriş")
    @Severity(SeverityLevel.BLOCKER)
    public void validLoginShouldSucceed() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("test@example.com", "Test1234!");
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Giriş başarısız oldu");
    }

    @Test
    @Description("Yanlış şifre ile giriş denemesi hata mesajı göstermeli")
    @Severity(SeverityLevel.CRITICAL)
    public void invalidPasswordShouldShowError() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("test@example.com", "yanlis_sifre");
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Hata mesajı görüntülenmedi");
        Assert.assertEquals(loginPage.getErrorMessage(), "E-posta veya şifre hatalı.");
    }

    @Test
    @Description("Boş alanlarla giriş denemesi hata göstermeli")
    @Severity(SeverityLevel.NORMAL)
    public void emptyFieldsShouldShowError() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("", "");
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Hata mesajı görüntülenmedi");
    }

    @Test
    @Description("Geçersiz e-posta formatı ile giriş denemesi")
    @Severity(SeverityLevel.MINOR)
    public void invalidEmailFormatShouldShowError() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("gecersiz-email", "Test1234!");
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Hata mesajı görüntülenmedi");
    }

    @Test
    @Description("3 başarısız denemeden sonra hesap kilitlenmeli")
    @Severity(SeverityLevel.CRITICAL)
    public void accountShouldLockAfterThreeFailedAttempts() {
        LoginPage loginPage = new LoginPage();
        for (int i = 0; i < 3; i++) {
            loginPage.login("test@example.com", "yanlis_sifre_" + i);
        }
        Assert.assertTrue(loginPage.getErrorMessage().contains("hesabınız kilitlendi"),
                "Hesap kilitleme mesajı görüntülenmedi");
    }
}
