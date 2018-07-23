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
 * Servlet implementation class AddPostTaskServlet
 */
@WebServlet("/AddPostTaskServlet.json")
public class AddPostTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPostTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String taskName = request.getParameter("taskName");
		String subOrganId = request.getParameter("subOrganId");
		String approverId = request.getParameter("approverId");
		String executeId = request.getParameter("executeId");
		String executeTime = request.getParameter("executeTime");
		String taskState = request.getParameter("taskState");
		String payerId = id;
		Taxsource ts = new Taxsource(Integer.parseInt(payerId), taskName, Integer.parseInt(subOrganId), Integer.parseInt(approverId), Integer.parseInt(executeId), executeTime, taskState);
		boolean b = new TaxsourceDaoImpl().addTaxsource(ts);
		JSONObject json = new JSONObject();
		if (b) {
			json.put("success", true);
			json.put("msg", "添加成功");
		} else {
			json.put("success", false);
			json.put("msg", "添加失败");
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
