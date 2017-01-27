package qa.login;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class InviteNewTeamMemberInTeam {
    @Test
    public void inviteNewTeamMemberInTeam() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:/automation/geckodriver.exe");
        Configuration.reportsFolder = "C:/automation/screen";

        Login.loginUse();
        addNewTM();
        screenshot("tm");
    }

    public static void addNewTM (){
        //open team tab
        $(By.xpath(".//a[@id='team-tab-link']")).click();
        $(By.xpath("//button[@id='addTeamMemberButton']")).click();


        $(By.xpath("//input[@id='email-input-0']")).sendKeys(String.format("anastasia.lyutarevich+%d@neklo.co",
                System.currentTimeMillis()));
        $(By.xpath("//input[@id='email-input-0']")).pressEnter();
        $(By.xpath("//input[@id='email-input-0']")).sendKeys("m");
        $(By.xpath("//input[@id='name-input-0']")).sendKeys("Test User");

        $(By.xpath("//input[@id='submit']")).click();

        $(By.xpath("//button[@id='invite-new-members-btn']")).click();
    }

}
