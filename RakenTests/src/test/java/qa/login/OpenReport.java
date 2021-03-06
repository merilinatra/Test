package qa.login;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class OpenReport {
    @Test
    public void inviteNewSubCollaborator() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:/automation/geckodriver.exe");
        Configuration.reportsFolder = "C:/automation/screen";

        String name, password;
        name = "anastasia.lyutarevich@neklo.com";
        password = "123456";
        Login.login(name, password);

        CreateProject.addNewProject();
        openReport();

        screenshot("sc");
    }

    public static void openReport () {

        $(By.cssSelector("#content > div:nth-child(4) > div:nth-child(2) > div.col-md-4.col-xs-12.mb-md.pull-right " +
                "> div > div > a:nth-child(1)")).click();

    }

}
