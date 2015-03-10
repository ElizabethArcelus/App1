import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Developed by Mikel Puig
public class AddNewUser extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                                          throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
	
	out.println("<html>");
	out.println("<Head>");
	out.println("<Title>AddNewUser</Title>");
	out.println("</Head>");
		out.println("<TABLE BORDER=0 BORDERCOLOR=\"C40808\"ALIGN=\"Center\">");
		out.println("<TR Height=\"150\"><TD BGCOLOR=\"#C40808\" Width=\"150\"></TD>");
		out.println("<TD BGCOLOR=\"#C40808\"></TD>");
		out.println("<TD BGCOLOR=\"#C40808\"></TD></TR>");
		out.println("<TR Height=\"500\"><TD BGCOLOR=\"#C40808\"></TD>");
		out.println("<TD Weight=\"500\">");
		out.println("<P align=\"Center\"><font size=\"+2\"><b>Add New User </b></font></p>");
			out.println("<FORM action=\"InsertUserIntoDB\" method=\"GET\">");   								//Remember web.xml
			out.println("<P align=\"Center\"> Is the User a Professor or a Student? </p>");
			out.println("<P Align=\"Center\"><INPUT TYPE=radio NAME=\"button\" VALUE=\"1\">Student");
			out.println("<P Align=\"Center\"><INPUT TYPE=radio NAME=\"button\"  VALUE=\"2\">Professor");
			out.println("<P Align=\"Center\"> Name <input type=\"text\" name=\"Name\">");
			out.println("<P Align=\"Center\"> Last Name <input type=\"text\" name=\"LastName\">");
			out.println("<P Align=\"Center\"> E-mail <input type=\"text\" name=\"Email\">");
			out.println("<P Align=\"Center\"><INPUT type=\"submit\" name=\"SubmitButton\" value=\"Send\">");
			out.println("<INPUT type=\"reset\" name=\"ResetButton\" value=\"Reset\"></P>");
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