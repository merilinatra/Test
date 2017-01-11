package qa.login;

import org.junit.Test;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.screenshot;

public class BannerLink {
    @Test
    public void bannerLink() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "D:/automation/geckodriver.exe");
        Configuration.reportsFolder = "D:/automation/screen";
        open("http://qa.rakenapp.com/login");

        $(By.name("username")).setValue("anastasia.lyutarevich@neklo.com");
        $(By.name("password")).setValue("123456");
        $(By.xpath(".//input[@class='btn btn-warning']")).click();
        $(By.xpath(".//a[@class='btn btn-warning banner-tell-me-more-btn']")).click();

        screenshot("dashboard");
    }

}
