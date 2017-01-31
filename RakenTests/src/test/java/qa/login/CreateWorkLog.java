package qa.login;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class CreateWorkLog {
    @Test
    public void inviteNewSubCollaborator() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:/automation/geckodriver.exe");
        Configuration.reportsFolder = "C:/automation/screen";

        Login.loginUse();
        CreateProject.addNewProject();
        addNewWorkLog();

        screenshot("sc");
    }

    public static void addNewWorkLog () throws InterruptedException {
        $(By.xpath("//button[@onclick=\"$('#addWorklogLink').click()\"]")).click();
        $(By.id("subcontractor")).setValue(String.format("Work Log %d", System.currentTimeMillis()));
        $(By.id("workerCount")).setValue("2");
        $(By.id("hours")).setValue("8");
        $(By.id("workDesc")).setValue("Description");
        $(By.xpath("(//button[@type='button'])[16]")).click();
        $(By.xpath("(//a[@href=#worklogs-tab])")).click();


    }

}
