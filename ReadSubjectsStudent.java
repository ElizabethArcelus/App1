import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Developed by Tomás Gastaminza

@SuppressWarnings("serial")
public class ReadSubjectsStudent extends HttpServlet {
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
        String IDStudent = req.getParameter("SID");
		
		PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
		out.println("<Head>");
		out.println("<Title>Student Subjects</Title>");
		out.println("</Head>");
		out.println("<TABLE BORDER=0 BORDERCOLOR=\"C40808\"ALIGN=\"Center\">");
		out.println("<TR Height=\"150\"><TD BGCOLOR=\"#C40808\" Width=\"150\"></TD>");
		out.println("<TD BGCOLOR=\"#C40808\"></TD>");
		out.println("<TD BGCOLOR=\"#C40808\"></TD></TR>");
		out.println("<TR Height=\"500\"><TD BGCOLOR=\"#C40808\"></TD>");
		out.println("<TD Weight=\"500\">");
		out.println("<P align=\"center\"><font size=\"+3\"><b> Subjects:  </b></font></p>");
        
                
  
		String sql = "Select Name FROM Subjects , [Student/Subject] WHERE Subjects.IDSubject=[Student/Subject].IDSubject AND [Student/Subject].IDStudent=" + IDStudent;

        System.out.println(sql);

		String var1, var2;
		try {
            Statement statement=connection.createStatement();
	
            ResultSet result = statement.executeQuery(sql);

			while(result.next()) {    
			
				var1=result.getString("Name");

				out.println("<P align=\"center\"><A Href=\"http://localhost:8081/Clicker/StudentSubjectsMenu?StudentID="+IDStudent+"&SubjectName="+var1+"\"> " + var1 + "</A>");
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Resulset: " + sql + " Exception: " + e);
        }
        
        out.println("</TD><TD BGCOLOR=\"#C40808\"></TD></TR>");
		out.println("<TR Height=\"150\"><TD BGCOLOR=\"#C40808\"></TD>");
		out.println("<TD BGCOLOR=\"#C40808\"></TD>");
		out.println("<TD BGCOLOR=\"#C40808\" Width=\"150\"></TD></TR>");
		out.println("</TABLE>");
		out.println("</html>");
        out.close();
    }
}