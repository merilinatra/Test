package qa.login;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class InviteNewSC {
    @Test
    public void inviteNewSubCollaborator() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:/automation/geckodriver.exe");
        Configuration.reportsFolder = "C:/automation/screen";

        Login.loginUse();
        CreateProject.addNewProject();
        addNewSC();
        screenshot("sc");
    }

    public static void addNewSC () throws InterruptedException {
        $(By.id("projectNo")).setValue("Number");
        $(By.id("submitBtn")).click();


        //херня, по клику не работает, а так ок. надо запомнить
        $(By.cssSelector("a.btn.btn-default")).pressEnter();
        $(By.id("addProjectMembers")).click();

        $(By.xpath("//img[@src='/images/collaborator_image.png']")).click();
        $(By.xpath("//img[@src='/images/collaborator_image.png']")).click();
        $(By.xpath("//img[@src='/images/collaborator_image.png']")).click();
        $(By.xpath("//div[@id='invite-modal']/div[2]/div/div[2]/div[2]/div[3]/div[4]/button")).click();


        Configuration.timeout=8000;
        $(By.xpath("//input[@id='email-input-0']")).shouldBe().sendKeys(String.format("anastasia.lyutarevich+sc%d@neklo.co",
                System.currentTimeMillis()));
        $(By.xpath("//input[@id='email-input-0']")).pressEnter();
        $(By.xpath("//input[@id='email-input-0']")).sendKeys("m");
        $(By.xpath("//input[@id='name-input-0']")).sendKeys("Test S");
        $(By.xpath("//input[@id='name-input-0']")).pressEnter();
        $(By.xpath("//input[@id='name-input-0']")).sendKeys("C");
        $(By.xpath("//input[@id='company-input-0']")).sendKeys(String.format("Company SC %d",
                System.currentTimeMillis()));

        $(By.xpath("//input[@id='submit']")).click();
        }

}
