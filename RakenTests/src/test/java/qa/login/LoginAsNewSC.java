package qa.login;

import java.sql.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.By;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginAsNewSC {
    @Test
    public void newUserCases() throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:/automation/geckodriver.exe");
        Configuration.reportsFolder = "C:/automation/screen";

        String name, password;
        name = "anastasia.lyutarevich@neklo.com";
        password = "123456";
        Login.login(name, password);
        CreateProject.addNewProject();
        String invitation_code = findInvite(InviteNewSC.addNewSC());
        LogOut.logOut();
        loginAsNewSC(invitation_code);
    }

    public static String findInvite(String email) throws InterruptedException {
        System.out.println(email);
        String invitation_code_result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Connection conn = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:2828/raken", "raken_dev", "4DrocPhinAn");
            Statement stmt = null;
            stmt = conn.createStatement();
            String sql = String.format("SELECT invitation_code, email FROM invite  where email=\"%s\"",
                    email);

             ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                System.out.print("while");
                //Retrieve by column name
                String invitation_code  = rs.getString("invitation_code");
                String email_result = rs.getString("email");
                //Display values
                System.out.print("invitation_code: " + invitation_code);
                invitation_code_result=invitation_code;
                System.out.print(", email: " + email_result);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        System.out.println(invitation_code_result);
        return invitation_code_result;
    }
    public static void loginAsNewSC(String invitation_code) throws InterruptedException {
        Configuration.timeout=20000;
        System.out.println("invitation_code" + invitation_code);
        open("https://qa.rakenapp.com/invite/accept-invite/" + invitation_code);
        $(By.id("newPassword")).setValue("123456");
        $(By.id("submitPasswordForm")).click();

        $(By.id("phone")).shouldBe(Condition.visible).click();
        $(By.id("phone")).setValue("123456789");
        $(By.id("submit")).click();
        $(By.id("submitInviteSuccess")).shouldBe(Condition.visible).click();
        $(By.id("query")).shouldBe(Condition.visible);
    }
    }
