package sun.ajaxJava.practice.jqueryAjax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jqueryAjax")
public class JqueryAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int i=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8"); 
		String name=null;
		name = "Hello "+request.getParameter("user");
		if(request.getParameter("user").toString().equals("")){
			i++;
			name="Please enter your name";
			for(int cou=0; cou<i; cou++)
				name+="!";
			if(i>3){
				i=0;
				name="void";
			}
		}
		out.print(name); //this text is going there in #welcometext
//			out.append("Served at: ").append(request.getContextPath());
	}

}
