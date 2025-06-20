package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import com.Aspects.ObjectProvider;
import com.bean.Account;
import com.serviceImpl.AccServiceImpl;
import com.services.AccountServices;

public class LoginController extends HttpServlet
{
	Connection con;
	String bClass;
	String DaoClass;
	
	public void init()
	{
		//read context and create DB connection 
		String driver = getServletConfig().getServletContext().getInitParameter("driver");
		String url = getServletConfig().getServletContext().getInitParameter("url");
		String username = getServletConfig().getServletContext().getInitParameter("username");
		String password = getServletConfig().getServletContext().getInitParameter("password");
		
         try
         {
        	Class.forName(driver);
        	con = DriverManager.getConnection(url,username,password);
        	System.out.println("Connected to database successfully");
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
         }
         
         //Read config and get names of Bclass and DAO class
         bClass = getServletConfig().getInitParameter("BusinessClass");
         DaoClass = getServletConfig().getInitParameter("DAOClass");
		
	}
       
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
	   AccountServices acc = ObjectProvider.provideBusinessObjects(bClass);

	   ((AccServiceImpl) acc).setInfo(DaoClass,con);
	   PrintWriter out = response.getWriter();
	   HttpSession session = request.getSession(true); //////////
	   
	   //identify the view page and then call app BClass method
	   String id = request.getParameter("id");
	   
	   if(id.equals("OA"))
	   {
		   //Extract the data needed to B.Logic
		   String type = request.getParameter("accType");
		   float amount = Float.parseFloat(request.getParameter("amount"));
		   Account a = acc.openAccount(type, amount);	
		   session.setAttribute("accNo", a.getAccNo());
		   session.setAttribute("accType", a.getAccType());
		   session.setAttribute("accBal", a.getAccBal());

		   //Dispatch the controller to dynamic view
		   RequestDispatcher rd = request.getRequestDispatcher("Acknowledgment.jsp");
		   rd.forward(request, response);
		   
	   }
	   else if(id.equals("DM"))
	   {
		   int AccNo = Integer.parseInt(request.getParameter("accNo"));
		   Float Amount = Float.parseFloat(request.getParameter("amount"));
		   float updatedBal = acc.deposit(AccNo, Amount);
		   
		   if(updatedBal!=0.0f)
		   {
			   session.setAttribute("updatedBal", updatedBal);
			   session.setAttribute("accNo", AccNo);

	           RequestDispatcher rd = request.getRequestDispatcher("AcknowledgementDep.jsp");
			   rd.forward(request, response);  
		   }
		   else
		   {
			   RequestDispatcher rd = request.getRequestDispatcher("Deposit.jsp");
			   rd.include(request, response);
			   out.println("Account Not Found");
		   }
		
	   }
	   else if(id.equals("BE"))
	   {
		   int accNo = Integer.parseInt(request.getParameter("accNo"));
		   String acctype = request.getParameter("accType");
		   Account a = acc.balEnquiry(accNo, acctype);
		   
		   if(a==null)
		   {
			   RequestDispatcher rd = request.getRequestDispatcher("BalEnquiry.jsp");
			   rd.include(request, response); 
			   out.println("Account Not Found");
		   }
		   else
		   {
			   session.setAttribute("accNo", a.getAccNo());
			   session.setAttribute("accType", a.getAccType());
			   session.setAttribute("accBal", a.getAccBal());
			   
			   RequestDispatcher rd = request.getRequestDispatcher("AcknowledgmentBalEnq.jsp");
			   rd.forward(request, response);
		   }

		   
	   }
	   else if(id.equals("WD"))
	   {
		  int accNo  = Integer.parseInt(request.getParameter("accNo"));
		  float amount = Float.parseFloat(request.getParameter("amount"));
		  float newBal = acc.withdraw(accNo, amount);
		  session.setAttribute("newBal", newBal);
		  RequestDispatcher rd = request.getRequestDispatcher("AcknowledgmentwithDraw.jsp");
		  rd.forward(request, response);
	   }
	   else if(id.equals("DA"))
	   {
		   int accNo  = Integer.parseInt(request.getParameter("accNo"));
		   String acctype = request.getParameter("accType");
		   float accBal  = acc.delete(accNo);
		   session.setAttribute("accBal",accBal);
		   RequestDispatcher rd = request.getRequestDispatcher("AcknowledgmentDelete.jsp");
		   rd.forward(request, response);

	   }
   }

}
