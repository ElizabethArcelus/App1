import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

//  Developed by Elizabeth Arcelus

@SuppressWarnings("serial")
public class PreviousTestsProfessor extends HttpServlet {
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
        String ProfessorID = req.getParameter("ProfessorID");
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
        
                
        String sql = "Select DISTINCT Exams.Name FROM [Exams],[Exams/Professor/Subjects], [Professor/Subject], Subjects WHERE [Exams/Professor/Subjects].IDSubject=[Professor/Subject].IDSubject and [Professor/Subject].IDSubject=Subjects.IDSubject and [Exams/Professor/Subjects].IDExam=Exams.IDExam AND [Exams/Professor/Subjects].IDProfessor LIKE '"+ProfessorID+"'  AND Subjects.Name LIKE '" +SubjectName+ "'";
		System.out.println(sql);
		String var = "";
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
			
            while(result.next()) { 			
	
			var=result.getString("Name");
			
			if (var==null){
			
			out.println("<P align=\"center\">Here will Appear the Questions and ");
			
			else{
			
			out.println("<P align=\"center\"><A Href=\"http://localhost:8081/Clicker/ViewTakenTest?SubjectName="+SubjectName+"&ExamName="+ var +"\"> " + var + "</A>"); 
			}
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