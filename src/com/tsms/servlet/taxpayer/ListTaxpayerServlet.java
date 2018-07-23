package com.tsms.servlet.taxpayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.TaxpayerDaoImpl;
import com.tsms.entity.Taxpayer;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ListTaxpayerServlet
 */
@WebServlet("/ListTaxpayerServlet.json")
public class ListTaxpayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTaxpayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		
		String pageNo = request.getParameter("page");
		String pageSize = request.getParameter("rows");
		String payerCode = request.getParameter("payerCode");
		String payerName = request.getParameter("payerName");
		
		TaxpayerDaoImpl td = new TaxpayerDaoImpl();
		List<Map<String, String>> list = td.getAllTaxpayers(payerCode,payerName,Integer.parseInt(pageNo), Integer.parseInt(pageSize));
		int total = td.listAllTaxpayersByPageCount();
		JSONObject json = new JSONObject();
		PrintWriter out = response.getWriter();
		if (list.size() < 0 || list == null) {
			return;
		}
		json.put("rows", JSONArray.fromObject(list));
		json.put("total", total);
		out.write(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
