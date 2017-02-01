package qa.login;

import com.codeborne.selenide.Condition;
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

        String name, password;
        name = "anastasia.lyutarevich@neklo.com";
        password = "123456";
        Login.login(name, password);

        CreateProject.addNewProject();
        System.out.print(addNewSC());
        screenshot("sc");
    }

    public static String addNewSC () throws InterruptedException {
        $(By.id("addProjectMembers")).click();

        $(By.xpath("//img[@src='/images/collaborator_image.png']")).click();
        $(By.xpath("//img[@src='/images/collaborator_image.png']")).click();
        $(By.xpath("//img[@src='/images/collaborator_image.png']")).click();
        $(By.xpath("//div[@id='invite-modal']/div[2]/div/div[2]/div[2]/div[3]/div[4]/button")).click();


        Configuration.timeout=8000;
        String email=String.format("anastasia.lyutarevich+sc%d@neklo.co",
                System.currentTimeMillis());
        $(By.xpath("//input[@id='email-input-0']")).shouldBe().sendKeys(email);
        $(By.xpath("//input[@id='email-input-0']")).pressEnter();
        $(By.xpath("//input[@id='email-input-0']")).sendKeys("m");

        $(By.xpath("//input[@id='name-input-0']")).sendKeys("Test S");
        $(By.xpath("//input[@id='name-input-0']")).pressEnter();
        $(By.xpath("//input[@id='name-input-0']")).sendKeys("C");
        $(By.xpath("//input[@id='company-input-0']")).sendKeys(String.format("Company SC %d",
                System.currentTimeMillis()));

        $(By.xpath("//input[@id='submit']")).click();

        $(By.cssSelector("#invite-success-modal > div.modal-dialog")).shouldBe(Condition.visible);
        $(By.cssSelector("#invite-success-modal > div.modal-dialog > div > div.modal-footer > button")).click();
        return email+"m";
        }

}
