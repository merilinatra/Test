package qa.login;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class manyProjects {
    @Test
    public void createProject() throws InterruptedException {
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
            $(By.xpath(".//a[@id='projects-tab-link']")).click();
            $(By.xpath("//button[@class='btn btn-success']")).click();

            $(By.id("name")).setValue(String.format("Project %d", System.currentTimeMillis()));
            $(By.xpath(".//input[@type='submit']")).click();
            $(By.xpath(".//button[@class='bootbox-close-button close']")).click();

             $(By.id("submitBtn")).click();
             $(By.partialLinkText("Today's Report")).click();
        $(By.partialLinkText("Today's Report")).contextClick();
        $(By.partialLinkText("Today's Report")).doubleClick();
            $(By.xpath("//div[@id='worklog-list2']/div/div[2]/div/button")).click();
            $(By.id("subcontractor")).clear();
            $(By.id("subcontractor")).sendKeys("4");
            $(By.id("workDesc")).click();
            $(By.id("workDesc")).clear();
            $(By.id("workDesc")).sendKeys("4");
            $(By.xpath("(//button[@type='button'])[16]")).click();
        }


}
