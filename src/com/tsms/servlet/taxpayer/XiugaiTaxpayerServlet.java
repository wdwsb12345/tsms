package com.tsms.servlet.taxpayer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.TaxpayerDaoImpl;
import com.tsms.entity.Taxpayer;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class XiugaiTaxpayerServlet
 */
@WebServlet("/XiugaiTaxpayerServlet.json")
public class XiugaiTaxpayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XiugaiTaxpayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String payerCode = request.getParameter("payerCode");
		String payerName = request.getParameter("payerName");
		String bizAddress = request.getParameter("bizAddress");
		String bizAddressPhone = request.getParameter("bizAddressPhone");
		System.out.println(bizAddressPhone);
		String taxOrganId = request.getParameter("taxOrganId");
		System.out.println(taxOrganId);
		String industryId = request.getParameter("industryId");
		System.out.println(industryId);
		String bizScope = request.getParameter("bizScope");
		System.out.println(industryId);
		String invoiceType = request.getParameter("invoiceType");
		System.out.println(invoiceType);
		String legalPerson = request.getParameter("legalPerson");
		System.out.println(legalPerson);
		String legalIdCard = request.getParameter("legalIdCard");
		System.out.println(legalIdCard);
		String finaceName = request.getParameter("finaceName");
		System.out.println(finaceName);
		String finaceIdCard = request.getParameter("finaceIdCard");
		System.out.println(finaceIdCard);
		Taxpayer tp = new Taxpayer(Integer.parseInt(id),payerCode,payerName,bizAddress,Integer.parseInt(taxOrganId),Integer.parseInt(industryId),bizScope,invoiceType,legalPerson,legalIdCard,finaceName,finaceIdCard,bizAddressPhone);
		JSONObject json=new JSONObject();
		boolean b = new TaxpayerDaoImpl().updateTaxpayer(tp);
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
