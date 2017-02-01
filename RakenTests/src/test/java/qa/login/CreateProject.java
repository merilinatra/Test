package qa.login;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class CreateProject {
    @Test
    public void createProject() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:/automation/geckodriver.exe");
        Configuration.reportsFolder = "C:/automation/screen";

        String name, password;
        name = "anastasia.lyutarevich@neklo.com";
        password = "123456";
        Login.login(name, password);

        addNewProject();

        $(By.className("modal-title")).exists();
        screenshot("project");
    }

    public static void addNewProject (){
        //open projects tab
        $(By.xpath(".//a[@id='projects-tab-link']")).click();
        $(By.xpath(".//a[@id='projects-tab-link']")).click();
        $(By.xpath("//button[@class='btn btn-success']")).click();

        $(By.id("name")).setValue(String.format("Project %d", System.currentTimeMillis()));
        $(By.xpath(".//input[@type='submit']")).click();
        $(By.xpath(".//button[@class='bootbox-close-button close']")).click();

        $(By.id("projectNo")).setValue("Number");
        $(By.id("submitBtn")).click();
        //херня, по клику не работает, а так ок. надо запомнить
        $(By.cssSelector("a.btn.btn-default")).pressEnter();

    }

}
