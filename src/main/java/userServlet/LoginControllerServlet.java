package userServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import serviceImpl.loginServiceImpl;
import services.loginServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet("/control")
public class LoginControllerServlet extends HttpServlet
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		loginServices service = new loginServiceImpl(); 
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		
		if(id.equals("LogIn"))
		{
			try
			{
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				int validation = service.signIn(username, password);
				HttpSession session = request.getSession(true);
				session.setAttribute("username", username);
				System.out.println(validation);				
				if(validation==1)
				{
					RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);
				}
				else if(validation==0 || validation==-1)
				{
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					rd.include(request, response);	
					out.println("Invalid username or password");
				}
				else if(validation==-2)
				{
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					rd.include(request, response);	
					out.println("Username and Password length should be greater than 8");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		else if(id.equals("SignUp"))
		{
			try
			{
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String sqn = request.getParameter("sqn");
				String sqa = request.getParameter("sqa");
				HttpSession session = request.getSession(true);
				session.setAttribute("username", username);
				int pass = service.signUp(username, password, sqn, sqa);
				if(pass==1)
				{
					RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);
				}
				else if(pass==-1)
				{
					RequestDispatcher rd = request.getRequestDispatcher("HomeLogin.html");
					rd.include(request, response);
					out.println("username and password length should be 8");
				}
				else if(pass==0)
				{
					RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
					rd.include(request, response);
					out.println("<p style='color:red;'>The Username and Password Already Exist</p>");
					out.println("<p style='color:red;'>Enter a Unique Username and Password</p>");
				}


			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(id.equals("Forget"))
		{
			try
			{
				String username = request.getParameter("username");
				String sqn = request.getParameter("sqn");
				String sqa = request.getParameter("sqa");
				String ForgetPassword = service.forgetPassword(username, sqn, sqa);
				RequestDispatcher rd = request.getRequestDispatcher("Forget.jsp");
				rd.include(request, response);
				if(ForgetPassword=="Invalid")
				{
					out.println("Invalid Username");
				}
				else
				{
					out.println("The username = "+username);
					out.println("The password = "+ForgetPassword);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(id.equals("UpdatePassword"))
		{
			try
			{
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String newPassword = request.getParameter("newPassword");
				String result = service.updatePassword(username, password, newPassword);
				
				if(result=="Invalid")
				{
					RequestDispatcher rd = request.getRequestDispatcher("UpdatePassword.jsp");
					rd.include(request, response);
					out.println("Invalid Username And Password");
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("UpdatePassword.jsp");
					rd.include(request, response);
					out.println("The New Password is Updated Successfully");
					out.println("The Updated Password = "+result);	

				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(id.equals("Delete"))
		{
			try
			{
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				boolean result = service.deleteId(username, password);
				
				if(result)
				{
					RequestDispatcher rd = request.getRequestDispatcher("HomeLogin.html");
					rd.include(request, response);
					out.println("User Deleted Successfully");
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("HomeLogin.html");
					rd.include(request, response);
					out.println("Username Not Found");	
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
