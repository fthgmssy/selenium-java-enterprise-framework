package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By emailInput    = By.id("email");
    private final By passwordInput = By.id("password");
    private final By loginButton   = By.cssSelector("button[type='submit']");
    private final By errorMessage  = By.cssSelector(".error-message");
    private final By welcomeText   = By.cssSelector(".dashboard-welcome");

    @Step("E-posta ve şifre ile giriş yapılıyor: {email}")
    public LoginPage login(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
        click(loginButton);
        return this;
    }

    @Step("Hata mesajı alınıyor")
    public String getErrorMessage() {
        return getText(errorMessage);
    }

    @Step("Giriş başarılı mı kontrol ediliyor")
    public boolean isLoginSuccessful() {
        return isDisplayed(welcomeText);
    }

    public boolean isErrorDisplayed() {
        return isDisplayed(errorMessage);
    }
}
