import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

//Developed by Mikel Puig
// Comments: In the future, it will be compared if the users in the database and the ones being introduced are not the same to make sure there are no repetitions.
// Comments: It is better to make sure first that inserting data in the data base works properly.

@SuppressWarnings("serial")
public class InsertUserIntoDB extends HttpServlet {
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
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
		
		String SUser= req.getParameter("button");
		int IUser = Integer.parseInt(SUser);
		
		// Generate Password
		String key = "0123456789abcdefghijklmnopqrstuvwxyz";
		int length = 8;
		String Password = "";
		for (int i = 0; i < length; i++) {
		 Password+=(key.charAt((int)(Math.random() * key.length())));
		} 
	   //
	   // 1 = Student , 2 = Professor
	   //
		if (IUser ==1) {
		
				String sql = "INSERT INTO Students (Name, LastName, Email, Password) VALUES (";
				sql +=  "'" + req.getParameter("Name") + "'";
				sql +=  ", '" + req.getParameter("LastName") + "'";
				sql +=  ", '" + req.getParameter("Email") + "'";
				sql +=  ", '" + Password + "')";
				System.out.println("Insert sql: " + sql);
				try{
				Statement statement = connection.createStatement();
				statement.executeUpdate(sql);
				} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Resulset: " + sql + " Exception: " + e);
				}
			
		} else if (IUser ==2) {

				String sql = "INSERT INTO Professors (Name, LastName, Email, Password) VALUES (";	
				sql +=  "'" + req.getParameter("Name") + "'";
				sql +=  ", '" + req.getParameter("LastName") + "'";
				sql +=  ", '" + req.getParameter("Email") + "'";
				sql +=  ", '" + Password + "')";
				System.out.println("Insert sql: " + sql);
				try{
				Statement statement = connection.createStatement();
				statement.executeUpdate(sql);
				} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Resulset: " + sql + " Exception: " + e);
				}
				
		}
		
		// Html to show the inserted User
		out.println("<!DOCTYPE HTML>");
		out.println("<html>");
		out.println("<Head>");
		out.println("<Title>Insert User into DB</Title>");
		out.println("</Head>");
		out.println("<TABLE BORDER=0 BORDERCOLOR=\"C40808\"ALIGN=\"Center\">");
		out.println("<TR Height=\"150\"><TD BGCOLOR=\"#C40808\" Width=\"150\"></TD>");
		out.println("<TD BGCOLOR=\"#C40808\"></TD>");
		out.println("<TD BGCOLOR=\"#C40808\"></TD></TR>");
		out.println("<TR Height=\"500\"><TD BGCOLOR=\"#C40808\"></TD>");
		out.println("<TD Weight=\"500\">");
		
			// 1 = Student , 2 = Professor
			if (IUser ==1) {
				out.println("<P align=\"Center\"><font size=\"+2\"><b> New Student Inserted </b></font></p>");
				out.println("<TABLE BORDER=\"1\"><TR><TD> Name </TD><TD> LastName </TD><TD> Email </TD><TD> Password </TD></TR>");
				out.println("<TR><TD> " + req.getParameter("Name") + " </TD><TD> " + req.getParameter("LastName") + " </TD><TD> " + req.getParameter("Email") + " </TD><TD> " + Password + " </TD></TR>");
				out.println("</TABLE>");
			} else if (IUser ==2) {
				out.println("<P align=\"Center\"><font size=\"+2\"><b> New Professor Inserted </b></font></p>");
				out.println("<TABLE BORDER=\"1\"><TR><TD> Name </TD><TD> LastName </TD><TD> Email </TD><TD> Password </TD></TR>");
				out.println("<TR><TD> " + req.getParameter("Name") + " </TD><TD> " + req.getParameter("LastName") + " </TD><TD> " + req.getParameter("Email") + " </TD><TD> " + Password + " </TD></TR>");
				out.println("</TABLE>");
			} 
		out.println("<A Href=\"http://localhost:8081/ClickerMikel/AddNewUser\"> Add Another User</A>");
		out.println("<A Href=\"http://localhost:8081/ClickerMikel/ClickerAdmin.html\"> Main Menu </A>");
		out.println("</TD><TD BGCOLOR=\"#C40808\"></TD></TR>");
		out.println("<TR Height=\"150\"><TD BGCOLOR=\"#C40808\"></TD>");
		out.println("<TD BGCOLOR=\"#C40808\"></TD>");
		out.println("<TD BGCOLOR=\"#C40808\" Width=\"150\"></TD></TR>");
		out.println("</TABLE>");
		out.println("</Body>");
		out.println("</html>");
		out.close();

	}
}