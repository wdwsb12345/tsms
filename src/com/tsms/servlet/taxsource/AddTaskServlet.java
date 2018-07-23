package com.tsms.servlet.taxsource;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.TaxpayerDaoImpl;
import com.tsms.dao.impl.TaxsourceDaoImpl;

/**
 * Servlet implementation class AddTaskServlet
 */
@WebServlet("/AddTaskServlet.json")
public class AddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		String payerCode = request.getParameter("payerCode");
		if (id != null) {
			Map<String, String>map = new TaxpayerDaoImpl().getTaxpayerById(Integer.parseInt(id));
			if(map.size()<0||map==null){
				return;
			}
			request.setAttribute("map", map);
			request.getRequestDispatcher("manage/jsp/addTask.jsp").forward(request, response);
		} else if (payerCode != null) {
			Map<String, String> map = new TaxsourceDaoImpl().getTaxsourceByName(payerCode);
			if(map.size()<0||map==null){
				return;
			}
			request.setAttribute("map", map);
			request.getRequestDispatcher("manage/jsp/addTask.jsp").forward(request, response);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
