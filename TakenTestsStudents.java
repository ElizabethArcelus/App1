import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

//  Developed by Elizabeth Arcelus

@SuppressWarnings("serial")
public class TakenTestsStudents extends HttpServlet {
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
        String StudentID = req.getParameter("StudentID");
		String SubjectName = req.getParameter("SubjectName");
		
		PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
		out.println("<Head>");
		out.println("<Title>Taken tests list</Title>");
		out.println("</Head>");
		out.println("<TABLE BORDER=0 BORDERCOLOR=\"C40808\"ALIGN=\"Center\">");
		out.println("<TR Height=\"150\"><TD BGCOLOR=\"#C40808\" Width=\"150\"></TD>");
		out.println("<TD BGCOLOR=\"#C40808\"></TD>");
		out.println("<TD BGCOLOR=\"#C40808\"></TD></TR>");
		out.println("<TR Height=\"500\"><TD BGCOLOR=\"#C40808\"></TD>");
		out.println("<TD Weight=\"500\">");
		out.println("<P align=\"center\"><font size=\"+3\"><b> Taken tests list:  </b></font></p>");
        
                
        String sql = "Select DISTINCT Exams.Name FROM [Exams],[Exams/Student/Subjects], [Student/Subject], Subjects WHERE [Exams/Student/Subjects].IDSubject=[Student/Subject].IDSubject and [Student/Subject].IDSubject=Subjects.IDSubject and [Exams/Student/Subjects].IDExam=Exams.IDExam AND [Exams/Student/Subjects].IDStudent LIKE '"+StudentID+"'  AND Subjects.Name LIKE '" +SubjectName+ "'";
		System.out.println(sql);
		String var = "";
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
			
            while(result.next()) {  
			
			var=result.getString("Name");
			
			//System.out.println
			
			out.println("<P align=\"center\"><A Href=\"http://localhost:8081/Clicker/ViewTakenTest?SubjectName="+SubjectName+"&ExamName="+ var +"\"> " + var + "</A>"); 
			
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