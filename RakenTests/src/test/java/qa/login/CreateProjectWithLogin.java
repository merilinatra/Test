package qa.login;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class CreateProjectWithLogin {
    @Test
    public void createProjectWithLogin() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:/automation/geckodriver.exe");
        Configuration.reportsFolder = "C:/automation/screen";

        Login.loginUse();
        addNewProject();

        $(By.className("modal-title")).exists();
        screenshot("project");
    }

    public static void addNewProject (){
        //open projects tab
        $(By.xpath(".//a[@id='projects-tab-link']")).click();

        $(By.xpath("//button[@class='btn btn-success']")).click();

        $(By.id("name")).setValue(String.format("Project %d", System.currentTimeMillis()));
        $(By.xpath(".//input[@type='submit']")).click();
    }

}
