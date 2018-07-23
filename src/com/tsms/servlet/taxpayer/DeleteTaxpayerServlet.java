package com.tsms.servlet.taxpayer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.TaxpayerDaoImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DeleteTaxpayerServlet
 */
@WebServlet("/deleteTaxpayerServlet.json")
public class DeleteTaxpayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTaxpayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		String id = request.getParameter("id");
		boolean row = new TaxpayerDaoImpl().deleteTaxpayerById(Integer.parseInt(id));
		JSONObject json = new JSONObject();
		if(row){
			json.put("success", true);
			json.put("msg", "删除成功");
		}else{
			json.put("success", false);
			json.put("msg", "删除失败");
		}
		response.getWriter().println(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
