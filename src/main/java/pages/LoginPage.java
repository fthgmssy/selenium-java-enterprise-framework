package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton   = By.cssSelector("button[type='submit']");
    private final By errorMessage  = By.id("flash");
    private final By successMessage = By.id("flash");

    @Step("Kullanıcı adı ve şifre ile giriş yapılıyor: {username}")
    public LoginPage login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
        return this;
    }

    @Step("Mesaj alınıyor")
    public String getFlashMessage() {
        return getText(successMessage);
    }

    @Step("Giriş başarılı mı kontrol ediliyor")
    public boolean isLoginSuccessful() {
        return getCurrentUrl().contains("/secure");
    }

    public boolean isErrorDisplayed() {
        return isDisplayed(errorMessage) && getFlashMessage().contains("invalid");
    }
}
