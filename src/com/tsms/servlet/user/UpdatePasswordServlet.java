package com.tsms.servlet.user;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.LoginUserDaoImpl;
import com.tsms.dao.impl.UserDaoImpl;
import com.tsms.entity.User;
import com.tsms.util.EncryptUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UpdatePasswordServlet
 */
@WebServlet("/UpdatePasswordServlet.json")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		User u = new LoginUserDaoImpl().getLoginUserByName(username);
		JSONObject json=new JSONObject();
		String password = u.getPassword(); 
		String opwd = EncryptUtil.encryptMD5(oldPassword+u.getSalt());
		String newpwd = EncryptUtil.encryptMD5(newPassword+u.getSalt());
		if (opwd.equals(password)) {
			boolean b = new LoginUserDaoImpl().updateUser(username,newpwd);
			if (b) {
				json.put("msg", "修改完成");
				json.put("success", true);
			} else {
				json.put("msg", "修改失败");
				json.put("success", false);
			}
		} else {
			json.put("msg", "修改失败，密码输入错误");
			json.put("success", false);
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
