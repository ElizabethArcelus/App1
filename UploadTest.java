import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class UploadTest extends HttpServlet{
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
	
	String Q1 = req.getParameter("Q1");
	String Q1O1 = req.getParameter("Q1O1");
	String Q1O2 = req.getParameter("Q1O2");
	String Q1O3 = req.getParameter("Q1O3");
	String Q1O4 = req.getParameter("Q1O4");
	String Q1A1 = req.getParameter("Q1A1");
	String Q1A2 = req.getParameter("Q1A2");
	String Q1A3 = req.getParameter("Q1A3");
	String Q1A4 = req.getParameter("Q1A4");
	
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
	out.println("<P align=\"center\"><font size=\"+3\"><b> CONGRATULATIONS! </b></font></p>");
	out.println("<P align=\"center\"><font size=\"+3\"><b>You have uploaded a new Test</b></font></p>");
	
	
		
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
