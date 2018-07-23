package com.tsms.servlet.taxpayer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.TaxpayerDaoImpl;
import com.tsms.entity.Taxpayer;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AddTaxpayerServlet
 */
@WebServlet("/AddTaxpayerServlet.json")
public class AddTaxpayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaxpayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String payerCode = request.getParameter("payerCode");
		String payerName = request.getParameter("payerName");
		String bizAddress = request.getParameter("bizAddress");
		String bizAddressPhone = request.getParameter("bizAddressPhone");
		String taxOrganId = request.getParameter("taxOrganId");
		String industryId = request.getParameter("industryId");
		String bizScope = request.getParameter("bizScope");
		String invoiceType = request.getParameter("invoiceType");
		String legalPerson = request.getParameter("legalPerson");
		String legalIdCard = request.getParameter("legalIdCard");
//		String legalMobile = request.getParameter("legalMobile");
		String finaceName = request.getParameter("finaceName");
		String finaceIdCard = request.getParameter("finaceIdCard");
//		String finaceMobile = request.getParameter("finaceMobile");
		String legalIdCardImageURL = request.getParameter("legalIdCardImageURL");
		String finaceIdCardImageURL = request.getParameter("finaceIdCardImageURL");
//		String taxerName = request.getParameter("taxerName");
//		String taxerIdCard = request.getParameter("taxerIdCard");
//		String taxerMobile = request.getParameter("taxerMobile");
//		String taxerIdCardImageURL = request.getParameter("taxerIdCardImageURL");
		String userId = request.getParameter("userId");
		String recordDate = request.getParameter("recordDate");
//		String removeState = request.getParameter("removeState");
		Taxpayer tp = new Taxpayer(1,payerCode,payerName,bizAddress,Integer.parseInt(taxOrganId), Integer.parseInt(industryId), bizScope,invoiceType,legalPerson,legalIdCard,null,legalIdCardImageURL,finaceName,finaceIdCard,null,finaceIdCardImageURL,null,null, null, null, bizAddressPhone,recordDate, Integer.parseInt(userId), 0);
		boolean b = new TaxpayerDaoImpl().addTaxpayer(tp);
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
