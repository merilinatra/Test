package qa.login;

import org.junit.Test;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.screenshot;

public class Login {
    @Test
    public void login() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "D:/automation/geckodriver.exe");
        Configuration.reportsFolder = "D:/automation/screen";

        loginUse();
    }

    public void loginUse(){
        open("http://qa.rakenapp.com");

        $(By.name("username")).setValue("anastasia.lyutarevich@neklo.com");
        $(By.name("password")).setValue("123456");
        $(By.xpath(".//input[@class='btn btn-warning']")).click();

        $(By.xpath(".//button[@class='close']")).click();

        $(By.id("query")).setValue("test");
        screenshot("dashboard");
    }
}
