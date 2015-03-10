import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Developed By Ana Calona

public class Welcome extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                                          throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
	
    String Sbutton = request.getParameter("button"); // Here we'll get the name through the username in Clicker.html
	///String UserID = request.getParameter("NID");
	int Ibutton = Integer.parseInt(Sbutton);
	
	String Sbutton2 = request.getParameter("button2");
	int Ibutton2 = Integer.parseInt(Sbutton2);
	 
	 
	out.println("<html>");
	out.println("<Head>");
	out.println("<Title>Welcome</Title>");
	out.println("</Head>");
	out.println("<TABLE BORDER=0 BORDERCOLOR=\"C40808\"ALIGN=\"Center\">");
	out.println("<TR Height=\"150\"><TD BGCOLOR=\"#C40808\" Width=\"150\"></TD>");
	out.println("<TD BGCOLOR=\"#C40808\"></TD>");
	out.println("<TD BGCOLOR=\"#C40808\"></TD></TR>");
	out.println("<TR Height=\"500\"><TD BGCOLOR=\"#C40808\"></TD>");
	out.println("<TD Weight=\"500\">");
	out.println("<P align=\"center\"><font size=\"+4\"><b>Welcome</b></font></p>");
	
	if (Ibutton == 2 && Ibutton2== 1) {
	
	out.println("<P align=\"center\"> Your ID is </A>"); // This will later on read an ID from a DataBase
	
	
	} else if (Ibutton == 2 && Ibutton2==2) {	
	
	out.println("<P align=\"center\"> Sign In  </A>");
	out.println("<FORM method=\"GET\" action=\"ReadSubjectsProfessor\">");
	out.println("<P Align=\"Center\"><B> ID Number: </B><INPUT NAME=\"PID\"><P>");
	out.println("<P Align=\"Center\"><INPUT type=\"submit\" name=\"SubmitButton\" value=\"Send\">");
	out.println("<INPUT type=\"reset\" name=\"ResetButton\" value=\"Reset\"></P>");
    out.println("</FORM>");
	
	
	
	} else if (Ibutton ==1 && Ibutton2==1) {
	
	out.println("<P align=\"center\"> Your ID is </A>");
	
	} else if (Ibutton==1 && Ibutton2==2) { 
	
	out.println("<P align=\"center\"> Sign In  </A>");
	out.println("<FORM method=\"GET\" action=\"ReadSubjectsStudent\">");
	out.println("<P Align=\"Center\"><B> ID Number: </B><INPUT NAME=\"SID\"><P>");
	out.println("<P Align=\"Center\"><INPUT type=\"submit\" name=\"SubmitButton\" value=\"Send\">");
	out.println("<INPUT type=\"reset\" name=\"ResetButton\" value=\"Reset\"></P>");
    out.println("</FORM>");
	
	}
	
	out.println("</TD><TD BGCOLOR=\"#C40808\"></TD></TR>");
	out.println("<TR Height=\"150\"><TD BGCOLOR=\"#C40808\"></TD>");
	out.println("<TD BGCOLOR=\"#C40808\"></TD>");
	out.println("<TD BGCOLOR=\"#C40808\" Width=\"150\"></TD></TR>");
	out.println("</TABLE>");
	out.println("</Body>");
	out.println("</html>");
            

    }
}
