package com.dispatcher;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ControllerServlet", "/getEmp", "/getCust", "/getProd"})
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ProductUtil product;
	private CustomerUtil customer;
	private EmployeeUtil employee;

	@Override
	public void init() throws ServletException {
		super.init();
		
		product = new ProductUtil();
		customer = new CustomerUtil();
		employee = new EmployeeUtil();
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		String uri = request.getRequestURI();
		String command = uri.substring(uri.lastIndexOf("/")+1);
		
		if(command == null)
			command = "";
		
		switch(command) {
		
		case "getProd":
			listProducts(request, response);
			break;
		case "getCust":
			listCustomers(request, response);
			break;
		case "getEmp":
			listEmployees(request, response);
			break;
		default:												// Hits if random url is entered
			listProducts(request, response);
		}
		
		
	}


	private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("EMPLOYEES", employee.getEmployees());
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("show-employees.jsp");
		dispatcher.forward(request, response);
	}


	private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("CUSTOMERS", customer.getCustomers());
		RequestDispatcher dispatcher = request.getRequestDispatcher("show-customers.jsp");
		dispatcher.forward(request, response);
		
	}


	private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("PRODUCTS", product.getProducts());
		RequestDispatcher dispatcher = request.getRequestDispatcher("show-products.jsp");
		dispatcher.forward(request, response);
	}
	

	
}
