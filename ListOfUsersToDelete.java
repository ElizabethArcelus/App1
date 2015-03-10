import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Developed by Ana Calona
@SuppressWarnings("serial")
public class ListOfUsersToDelete extends HttpServlet {
    Connection connection;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url="jdbc:odbc:Clicker";
            connection=DriverManager.getConnection(url); 
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        res.setContentType("text/html");
        PrintWriter toClient = res.getWriter();
		String IUser = req.getParameter("button");
		
        toClient.println("<!DOCTYPE HTML>");
        toClient.println("<html>");
        toClient.println("<head><title>Users</title></head>");
        toClient.println("<body>");
        toClient.println("<FORM action=\"DeleteUserFromDB\" method=\"GET\">");
		
		if (IUser =="1") {
		
		toClient.println("<h2>List of Students</h2>");
        toClient.println("<table border='1'>");
		String sql = "SELECT IDStudent, Name, LastName FROM Students";
        System.out.println(sql);
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
			int Counter=1;
            while(result.next()) {
                toClient.println("<tr>");
				toClient.println("<td><input type=\"checkbox\" name=\"option" + Counter + "\" value=\"User" + result.getString("IDStudent") + "\">");
                toClient.println("<td>" + result.getString("IDStudent") + "</td>");
                toClient.println("<td>" + result.getString("Name") + "</td>");
                toClient.println("<td>" + result.getString("LastName") + "</td>");
                toClient.println("</tr>");
				Counter++;
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Resulset: " + sql + " Exception: " + e);
        }
		}
		else if (IUser =="2") {
		
		toClient.println("<h2>List of Professors</h2>");
        toClient.println("<table border='1'>");
		String sql = "SELECT IDProfessor, Name, LastName FROM Professors";
        System.out.println(sql);
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
			int Counter=1;
            while(result.next()) {
                toClient.println("<tr>");
				toClient.println("<td><input type=\"checkbox\" name=\"option" + Counter + "\" value=\"User" + result.getString("IDProfessor") + "\">");
                toClient.println("<td>" + result.getString("IDProfessor") + "</td>");
                toClient.println("<td>" + result.getString("Name") + "</td>");
                toClient.println("<td>" + result.getString("LastName") + "</td>");
                toClient.println("</tr>");
				Counter++;
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Resulset: " + sql + " Exception: " + e);
        }		
		
        toClient.println("</table>");
		toClient.println("</FORM>");
        toClient.println("</body>");
        toClient.println("</html>");
        toClient.close();
    }
   }
}
