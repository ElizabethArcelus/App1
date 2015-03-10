import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

//  Developed by Elizabeth Arcelus

@SuppressWarnings("serial")
public class ViewTakenTest extends HttpServlet{

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
	
    public void doGet(HttpServletRequest req, HttpServletResponse response)
                                          throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

	String SubjectName = req.getParameter("SubjectName");
	String ExamName = req.getParameter("ExamName");
	
	out.println("<html>");
	out.println("<Head>");
	out.println("<Title>Test</Title>");
	out.println("</Head>");
	out.println("<TABLE BORDER=0 BORDERCOLOR=\"C40808\"ALIGN=\"Center\">");
	out.println("<TR Height=\"150\"><TD BGCOLOR=\"#C40808\" Width=\"150\"></TD>");
	out.println("<TD BGCOLOR=\"#C40808\"></TD>");
	out.println("<TD BGCOLOR=\"#C40808\"></TD></TR>");
	out.println("<TR Height=\"500\"><TD BGCOLOR=\"#C40808\"></TD>");
	out.println("<TD Weight=\"500\">");
	out.println("<P align=\"center\"><font size=\"+3\"><b>" + ExamName + "</b></font></p>");
	out.println("<P align=\"center\">Here will Appear the Questions and ");
	out.println("<P align=\"center\">The Answers with the correct Answer Marked");
	out.println("</TD><TD BGCOLOR=\"#C40808\"></TD></TR>");
	out.println("<TR Height=\"150\"><TD BGCOLOR=\"#C40808\"></TD>");
	out.println("<TD BGCOLOR=\"#C40808\"></TD>");
	out.println("<TD BGCOLOR=\"#C40808\" Width=\"150\"></TD></TR>");
	out.println("</TABLE>");
	out.println("</Body>");
	out.println("</html>");
            

    }
}
