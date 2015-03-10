import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Developed By Tomás Gastaminza

public class NewTest extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse response)
                                          throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
	
    String ProfessorID = req.getParameter("ProfessorID");
	
	out.println("<html>");
	out.println("<Head>");
	out.println("<Title>New Test</Title>");
	out.println("</Head>");
	out.println("<TABLE BORDER=0 BORDERCOLOR=\"C40808\"ALIGN=\"Center\">");
	out.println("<TR Height=\"150\"><TD BGCOLOR=\"#C40808\" Width=\"150\"></TD>");
	out.println("<TD BGCOLOR=\"#C40808\"></TD>");
	out.println("<TD BGCOLOR=\"#C40808\"></TD></TR>");
	out.println("<TR Height=\"500\"><TD BGCOLOR=\"#C40808\"></TD>");
	out.println("<TD Weight=\"500\">");
	out.println("<P align=\"center\"><font size=\"+3\"><b>Insert in the following Test </b></font></p>");
	out.println("<P align=\"center\"><font size=\"+3\"><b>the questions to be answered</b></font></p>");
	
	out.println("<FORM method=\"GET\" action=\"ReadSubjectsProfessor\">");	
	
	out.println("Question 1.<INPUT NAME=\"Q1\" size=\"50\" > "); 	
	out.println("<P \"><INPUT TYPE=\"radio\" NAME=\"Q1O1\"> Answer 1: <INPUT NAME=\"Q1A1\" size=\"20\" ></p> ");  		
	out.println("<P \"><INPUT TYPE=\"radio\" NAME=\"Q1O2\"> Answer 2: <INPUT NAME=\"Q1A2\" size=\"20\" ></p> ");  		
	out.println("<P \"><INPUT TYPE=\"radio\" NAME=\"Q1O3\"> Answer 3: <INPUT NAME=\"Q1A3\" size=\"20\" ></p> ");  		
	out.println("<P \"><INPUT TYPE=\"radio\" NAME=\"Q1O4\"> Answer 4: <INPUT NAME=\"Q1A4\" size=\"20\" ></p> ");  		
	out.println("<P \"><INPUT TYPE=\"HIDDEN\" NAME=\"PID\" VALUE="+ProfessorID+"></p> ");  		
	
		
	out.println("<P align=\"center\"><input type=\"submit\" value=\"Go to Menu\">&nbsp;&nbsp;&nbsp;");
	out.println("<INPUT type=\"reset\" name=\"resetButton\" value=\"Reset\"></P>");
	
	out.println("</FORM>");
	
	
	out.println("</TD><TD BGCOLOR=\"#C40808\"></TD></TR>");
	out.println("<TR Height=\"150\"><TD BGCOLOR=\"#C40808\"></TD>");
	out.println("<TD BGCOLOR=\"#C40808\"></TD>");
	out.println("<TD BGCOLOR=\"#C40808\" Width=\"150\"></TD></TR>");
	out.println("</TABLE>");
	out.println("</Body>");
	out.println("</html>");
            

    }
}

