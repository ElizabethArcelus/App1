import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Developed by Elizabeth Arcelus

public class StudentSubjectsMenu extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse response)
                                          throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
	String StudentID = req.getParameter("StudentID");
	String SubjectName = req.getParameter("SubjectName");
	
	out.println("<html>");
	out.println("<Head>");
	out.println("<Title>Student Subjects Menu </Title>");
	out.println("</Head>");
	out.println("<TABLE BORDER=0 BORDERCOLOR=\"C40808\"ALIGN=\"Center\">");
	out.println("<TR Height=\"150\"><TD BGCOLOR=\"#C40808\" Width=\"150\"></TD>");
	out.println("<TD BGCOLOR=\"#C40808\"></TD>");
	out.println("<TD BGCOLOR=\"#C40808\"></TD></TR>");
	out.println("<TR Height=\"500\"><TD BGCOLOR=\"#C40808\"></TD>");
	out.println("<TD Weight=\"500\">");
	out.println("<P align=\"center\"><font size=\"+4\"><b> Subject Options: </b></font></p>");
	
	
	out.println("<P align=\"center\"><A Href=\"http://localhost:8081/Clicker/TakenTestsStudents?StudentID="+StudentID+"&SubjectName="+SubjectName+"\"> Check Previous Tests</A>");
	out.println("<P align=\"center\"><A Href=\"http://localhost:8081/Clicker/CheckResultStudent?StudentID="+StudentID+"&SubjectName="+SubjectName+"\"> Check Taken Tests Results </A>");
	
	
	out.println("</TD><TD BGCOLOR=\"#C40808\"></TD></TR>");
	out.println("<TR Height=\"150\"><TD BGCOLOR=\"#C40808\"></TD>");
	out.println("<TD BGCOLOR=\"#C40808\"></TD>");
	out.println("<TD BGCOLOR=\"#C40808\" Width=\"150\"></TD></TR>");
	out.println("</TABLE>");
	out.println("</Body>");
	out.println("</html>");
            

    }
}
