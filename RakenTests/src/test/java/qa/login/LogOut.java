package qa.login;

import org.junit.Test;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.screenshot;

public class LogOut {
    @Test
    public void login() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:/automation/geckodriver.exe");
        Configuration.reportsFolder = "C:/automation/screen";

        String name, password;
        name = "anastasia.lyutarevich@neklo.com";
        password = "123456";
        Login.login(name, password);

        logOut();
     }

    public static void logOut() throws InterruptedException {
        $(By.cssSelector("#navbar-main > ul.nav.navbar-nav.navbar-right > li:nth-child(2) > a")).click();
        $(By.name("username")).click();
        screenshot("logout");
    }
}
