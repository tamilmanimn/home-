package com.smartglossa.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public homeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operation = request.getParameter("operation");
		if (operation.equals("addMember")) {
			int mid = Integer.parseInt(request.getParameter("id"));
			String mname = request.getParameter("name");
			String dob = request.getParameter("dob");
			String mno = request.getParameter("mno");
			JSONObject result = new JSONObject();
			try {
				homeClass home = new homeClass();
				home.addMember(mid, mname, dob, mno);
				result.put("status", 1);

			} catch (Exception e) {
				result.put("status", 0);
				e.printStackTrace();

			}
			response.getWriter().print(result);

		} else if (operation.equals("updateMember")) {
			int mid = Integer.parseInt(request.getParameter("id"));
			String mname = request.getParameter("name");
			String dob = request.getParameter("dob");
			String mno = request.getParameter("mno");
			JSONObject result = new JSONObject();
			try {
				homeClass home = new homeClass();
				home.updateMember(mid, mname, dob, mno);
				result.put("status", 1);
			} catch (Exception e) {
				result.put("status", 0);
				e.printStackTrace();

			}
			response.getWriter().print(result);
		}
		else if(operation.equals("deleteMember")){
			int mid=Integer.parseInt(request.getParameter("id"));
			JSONObject result=new JSONObject();
			try {
				homeClass home=new homeClass();
				home.deleteMember(mid);
				result.put("status",1);
				
			} catch (Exception e) {
				result.put("status",0);
				e.printStackTrace();

			}
			
			response.getWriter().print(result);
		}
		else if(operation.equals("getOne")){
			int mid=Integer.parseInt(request.getParameter("id"));
			JSONObject result=new JSONObject();
			try {
				homeClass home=new homeClass();
				result=home.getOne(mid);
				
			} catch (Exception e) {
				e.printStackTrace();

			}
			response.getWriter().print(result);
		}
		
		else if(operation.equals("getAll")){
			JSONArray result=new JSONArray();
			try {
				homeClass home=new homeClass();
				result=home.getAll();
			} catch (Exception e) {
			   e.printStackTrace();

			}
			response.getWriter().print(result);
		}
		else if(operation.equals("addSalary")){
			int mid=Integer.parseInt(request.getParameter("id"));
			String salary=request.getParameter("salary");
			JSONObject result=new JSONObject();
			try {
				homeClass home=new homeClass();
				home.addSalary(mid, salary);
				result.put("status",1);
				
				
			} catch (Exception e) {
				result.put("status",0);
				e.printStackTrace();

			}
			response.getWriter().print(result);
		}
		else if(operation.equals("updateSalary")){
			int mid=Integer.parseInt(request.getParameter("id"));
			String salary=request.getParameter("salary");
			JSONObject result=new JSONObject();
			try {
				homeClass home=new homeClass();
				home.addSalary(mid, salary);
				result.put("status",1);
				
			} catch (Exception e) {
				result.put("status",0);
				e.printStackTrace();

			}
			response.getWriter().print(result);
		}
		
		else if(operation.equals("deleteSalary")){
			int mid=Integer.parseInt(request.getParameter("id"));
			JSONObject result=new JSONObject();
			try {
				homeClass home=new homeClass();
				home.deleteSalary(mid);
				result.put("status",1);
				
			} catch (Exception e) {
				result.put("status",0);
				e.printStackTrace();

			}
			response.getWriter().print(result);
			
		}
		
		else if(operation.equals("oneSalary")){
			int mid=Integer.parseInt(request.getParameter("id"));
			JSONObject result=new JSONObject();
			try {
				homeClass home=new homeClass();
				result=home.oneSalary(mid);
				
			} catch (Exception e) {
				e.printStackTrace();

			}
			response.getWriter().print(result);
		}
		
		else if(operation.equals("allSalary")){
		    JSONArray result=new JSONArray();
		    try {
		    	homeClass home=new homeClass();
		    	result=home.allSalary();
				
			} catch (Exception e) {
				
				e.printStackTrace();

			}
		    response.getWriter().print(result);
		}
	}

}
