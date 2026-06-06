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
        loginPage.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Giriş başarısız oldu");
    }

    @Test
    @Description("Yanlış şifre ile giriş denemesi hata mesajı göstermeli")
    @Severity(SeverityLevel.CRITICAL)
    public void invalidPasswordShouldShowError() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("tomsmith", "yanlis_sifre");
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Hata mesajı görüntülenmedi");
    }

    @Test
    @Description("Geçersiz kullanıcı adı ile giriş denemesi")
    @Severity(SeverityLevel.NORMAL)
    public void invalidUsernameShouldShowError() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("gecersiz_kullanici", "SuperSecretPassword!");
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Hata mesajı görüntülenmedi");
    }
}
