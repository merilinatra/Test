package qa.login;

import org.junit.Test;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.screenshot;

public class SignUp {
    @Test
    public void signUp() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "D:/automation/geckodriver.exe");
        Configuration.reportsFolder = "D:/automation/screen";

        open("http://qa.rakenapp.com/login");

        $(By.id("signupBtn")).click();

        $(By.name("firstName")).setValue("Test");
        $(By.name("lastName")).setValue("User");

        $(By.id("username")).setValue(String.format("rakentesting+qa%s@gmail.com", System.currentTimeMillis()));

        $(By.xpath("(//input[@id='password'])[2]")).clear();
        $(By.xpath("(//input[@id='password'])[2]")).sendKeys("123456");

        $(By.name("phoneNumber")).setValue("123456789");
        $(By.name("name")).setValue(String.format("Neklo Test %s", System.currentTimeMillis()));

        $(By.xpath("//input[@value='Start Free Trial']")).click();

        $(By.xpath("//a[@class='btn btn-warning btn-block']")).followLink();

        $(By.xpath("//button[@id='submitInviteSuccess']")).click();

        $(By.id("query")).setValue("sign up");
        screenshot("signup");
    }

}
