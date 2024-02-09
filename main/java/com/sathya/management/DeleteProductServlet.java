package com.sathya.management;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String proId = request.getParameter("proId");
        
        ProductDao dao = new ProductDao();
        
        int deleted = dao.deleteProduct(Integer.parseInt(proId));
        
        if (deleted==1) {
        	request.setAttribute("deleteResult", true);       	
            RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
            dispatcher.forward(request, response);
        	//response.sendRedirect("productList.jsp");
        } else {
            response.sendRedirect("delerror.jsp");
        }
	}
}
