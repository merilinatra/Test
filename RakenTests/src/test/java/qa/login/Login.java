package qa.login;

import org.junit.Test;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.screenshot;

public class Login {
    @Test
    public void login() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:/automation/geckodriver.exe");
        Configuration.reportsFolder = "C:/automation/screen";

        String name, password;
        name = "anastasia.lyutarevich@neklo.com";
        password = "123456";

        login(name, password);

        screenshot("dashboard");
    }

    public static void login(String name, String password) throws InterruptedException {
        open("https://qa.rakenapp.com");

        $(By.name("username")).setValue(name);
        $(By.name("password")).setValue(password);
        $(By.xpath(".//input[@class='btn btn-warning']")).click();

        //close banner
        $(By.xpath(".//button[@class='close']")).click();
        $(By.id("query")).click();
        $(By.id("query")).setValue("test");

    }

}
