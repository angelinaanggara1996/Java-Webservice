package org.Test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WebServ
 */
@WebServlet("/WebServ")
public class WebServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebServ(){
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fid=request.getParameter("fid");
		//String fname=request.getParameter("fname");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center><h1>WELCOME!!</h1></center><hr>");
		if(fid.trim().equals(""))//|| fname.trim().equals(""))
		{
			out.println("<meta http-equiv='refresh' content='3;URL=index.html'>");//三秒內把網頁refresh
			out.println("<p style='color:red;'>Please input your id or name correctly!</p>");
		}
		else {
			Connection conn=null;
	        try {
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=erppd", "sa", "123");

	            if(conn!=null) {
	                System.out.print("Database Successfully connected");
	                Statement statement = conn.createStatement();
	                String queryString = "select * from dbo.PERSON";
	                ResultSet rs = statement.executeQuery(queryString);
	                while (rs.next()) {
	                   //System.out.println(rs.getString(1));
	                   String g = rs.getString(1).trim();
	                	if(fid.equals(g)) {
	                		out.println("<center><p style='color:red;'>BELLOOOOOO</p></center>");
	                		out.println("<center>My Name is : <b>"+ rs.getString(2) +"</b></center>");
	                		out.println("<center>Address is : <b>"+ rs.getString(3) +"</b></center>");
	                	}
	                }

	            }
	            else
	            	System.out.println("Database not connected");
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			//out.print("<center><h1>WELCOME!!</h1></center><hr>");
			//out.print("<center>My Id is : <b>"+ fid +"</b></center>");
			//out.print("<center>My Name is : <b>"+ fname +"</b></center>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}
