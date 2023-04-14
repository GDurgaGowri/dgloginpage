package cscorner;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n=request.getParameter("t1");
		String pwd=request.getParameter("t2");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		if(n.equals("cscorner")&&pwd.equals("secret")) {
			HttpSession hs=request.getSession();
			hs.setAttribute("uname",n);
			response.sendRedirect("success.html");
		}
		else {
			out.println("<font color=red size=14 face=verdana>Sorry! Username or password incorrect...Try Again</font>");
			RequestDispatcher rd=request.getRequestDispatcher("input.html");
			rd.include(request, response);
		}
		
	}

}
