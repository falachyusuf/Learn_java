package tools;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private Connection con;

    public DbConnection() {
    }

    public Connection getConnection() {
       try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_batm?zeroDateTimeBehavior=convertToNull", "root", "Yusuf280402");
          System.out.println("Database connected");
       } catch (Exception var2) {
          System.out.println("Errror:" + var2.getMessage());
       }
       return this.con;
    }
 }