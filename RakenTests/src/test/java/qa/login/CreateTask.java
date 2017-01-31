package qa.login;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class CreateTask {
    @Test
    public void inviteNewSubCollaborator() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:/automation/geckodriver.exe");
        Configuration.reportsFolder = "C:/automation/screen";

        Login.loginUse();
        CreateProject.addNewProject();
        addNewTask();

        screenshot("sc");
    }

    public static void addNewTask () {
        $(By.cssSelector("#content > div:nth-child(4) > ul > li:nth-child(5)")).click();
        $(By.linkText("Add Task")).click();
        $(By.id("add_task_modal_assinee_name")).click();
        $(By.id("add_task_modal_assinee_name")).clear();
        $(By.id("add_task_modal_assinee_name")).sendKeys("Alura Mugwort");
        $(By.id("desc")).setValue("Description");

        $(By.id("add_task_modal_assinee_name")).click();
        try {
            $(By.cssSelector("#add_task_form > div:nth-child(3) > div > span > div > div > div")).click();
        } catch (NoSuchElementException e) {
            $(By.id("add_task_modal_assinee_name")).click();
            e.printStackTrace();
        }



        $(By.id("add_task_modal_submit")).click();
       


    }

}
