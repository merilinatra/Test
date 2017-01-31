package qa.login;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class SignReport {
    @Test
    public void inviteNewSubCollaborator() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:/automation/geckodriver.exe");
        Configuration.reportsFolder = "C:/automation/screen";

        Login.loginUse();
        CreateProject.addNewProject();
        signReport();

        screenshot("sr");
    }

    public static void signReport () {
        $(By.cssSelector("#content > div:nth-child(4) > ul > li:nth-child(6)")).click();
        $(By.cssSelector("#signature-pad > div > canvas")).click();
        $(By.id("verifyButton")).click();
    }

}
