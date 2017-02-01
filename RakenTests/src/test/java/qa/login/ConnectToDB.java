package qa.login;

import java.sql.*;
import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
    @Test
    public void connect() throws InterruptedException {
        String sql, result_id, result;
        sql = "SELECT user_id, username FROM users";
        result_id = "user_id";
        result = "username";

        connectToDB(sql, result_id, result);
    }

    public static void connectToDB(String sql, String result_id, String result) throws InterruptedException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Connection conn = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:2828/raken", "raken_dev", "4DrocPhinAn");
            System.out.print("connect");
            Statement stmt = null;
            stmt = conn.createStatement();

            System.out.print("sql");
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int id  = rs.getInt(result_id);
                String first = rs.getString(result);
                //Display values
                System.out.print("ID: " + id + "\n");
                System.out.print(", name: " + first);
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

    }

}
