import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Developed by Ana Calona
public class DeleteUser extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                                          throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
	
	out.println("<html>");
	out.println("<Head>");
	out.println("<Title> Delete User</Title>");
	out.println("</Head>");
		out.println("<TABLE BORDER=0 BORDERCOLOR=\"C40808\"ALIGN=\"Center\">");
		out.println("<TR Height=\"15%\"><TD BGCOLOR=\"#C40808\" Width=\"15%\"></TD>");
		out.println("<TD BGCOLOR=\"#C40808\"></TD>");
		out.println("<TD BGCOLOR=\"#C40808\"></TD></TR>");
		out.println("<TR Height=\"70%\"><TD BGCOLOR=\"#C40808\"></TD>");
		out.println("<TD Weight=\"70%\">");
		out.println("<P align=\"Center\"><font size=\"+2\"><b> Delete User </b></font></p>");
			out.println("<FORM action=\"DeleteUserFromDB\" method=\"GET\">");    				
			out.println("<P align=\"Center\"> Is the User you are going to delete a Professor or a Student? </p>");
			out.println("<P Align=\"Center\"><INPUT TYPE=radio NAME=\"button\" VALUE=\"1\">Student");
			out.println("<P Align=\"Center\"><INPUT TYPE=radio NAME=\"button\"  VALUE=\"2\">Professor");
			out.println("<P Align=\"Center\"> ID: <INPUT TYPE=\"text\" NAME=\"ID\">");
			out.println("<P Align=\"Center\"> Name: <INPUT TYPE=\"text\" NAME=\"Name\">");
			out.println("<P Align=\"Center\"> Last Name: <INPUT TYPE=\"text\" NAME=\"LastName\">");
			out.println("<P Align=\"Center\"> <A Href=\"ListOfUsersToDelete\">Want to Check the entire list?</A>");
			out.println("<P Align=\"Center\"><INPUT TYPE=\"submit\" VALUE=\"Send\">");
			out.println("<INPUT TYPE=\"reset\"  VALUE=\"Reset\"></P>");
			out.println("</FORM>");
		out.println("</TD><TD BGCOLOR=\"#C40808\"></TD></TR>");
		out.println("<TR Height=\"15%\"><TD BGCOLOR=\"#C40808\"></TD>");
		out.println("<TD BGCOLOR=\"#C40808\"></TD>");
		out.println("<TD BGCOLOR=\"#C40808\" Width=\"15%\"></TD></TR>");
		out.println("</TABLE>");
	out.println("</Body>");
	out.println("</html>");
            
    }
}