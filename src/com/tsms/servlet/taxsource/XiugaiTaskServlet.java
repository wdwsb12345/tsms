package com.tsms.servlet.taxsource;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.TaxsourceDaoImpl;
import com.tsms.entity.Taxsource;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class XiugaiTaskServlet
 */
@WebServlet("/XiugaiTaskServlet.json")
public class XiugaiTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XiugaiTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String payerId = request.getParameter("payerId");
		String taskName = request.getParameter("taskName");
		String subOrganId = request.getParameter("subOrganId");
		String approverId = request.getParameter("approverId");
		String executeId = request.getParameter("executeId");
		String executeTime = request.getParameter("executeTime");
		String taskState = request.getParameter("taskState");
		Taxsource ts = new Taxsource(Integer.parseInt(id), Integer.parseInt(payerId), taskName, Integer.parseInt(subOrganId), Integer.parseInt(approverId), Integer.parseInt(executeId), executeTime, taskState);
		JSONObject json=new JSONObject();
		boolean b = new TaxsourceDaoImpl().updateTaxsource(ts);
		if (b) {
			json.put("success",true);
			json.put("msg","修改成功");
		} else {
			json.put("success",false);
			json.put("msg","修改失败");
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
