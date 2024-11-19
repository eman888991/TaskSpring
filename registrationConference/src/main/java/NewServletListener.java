
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */

/**
 * Web application lifecycle listener.
 *
 * @author dell
 */
public class NewServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
          Connection con = null;
        Statement stmt;
        ResultSet rs;
                //connect to my sql data base
        String URL = "jdbc:mysql://localhost:3306/PERSONS?useSSL=false&serverTimezone=UTC";

        String USER = "root";
        String PASSWORD = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            sce.getServletContext().setAttribute("conn", conn);
           
        } catch (Exception ex) {
            
        }
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
