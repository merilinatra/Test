package qa.login;

import org.junit.Test;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.screenshot;

public class NewUserCases {
    @Test
    public void newUserCases() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:/automation/geckodriver.exe");
        Configuration.reportsFolder = "C:/automation/screen";


        screenshot("dashboard");
    }

    public static void login(String name, String password) throws InterruptedException {


    }

}
