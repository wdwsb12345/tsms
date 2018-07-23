package com.tsms.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tsms.dao.impl.LoginUserDaoImpl;
import com.tsms.entity.User;
import com.tsms.util.EncryptUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet.json")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String captcha = request.getParameter("captcha");
		Object validate = request.getSession().getAttribute("validate");
		HttpSession session = request.getSession();
		JSONObject json = new JSONObject();
		if (validate.toString().equalsIgnoreCase(captcha)){
			User u = new LoginUserDaoImpl().getLoginUserByName(username);
			if (u.getUsername() != null) {
				String pwd = EncryptUtil.encryptMD5(password+u.getSalt());
				if (pwd.equals(u.getPassword())) {
					session.setAttribute("username", username);
					session.setAttribute("password", password);
					json.put("msg", "登陆成功");
					json.put("success", true);
					response.addCookie(new Cookie("username", username));
//					response.addCookie(new Cookie("password", password));
				} else {
					json.put("msg", "密码有误");
					json.put("success", false);
				}
			} else {
				json.put("msg", "账号有误");
				json.put("success", false);
			}
		} else {
			json.put("msg", "验证码有误");
			json.put("success", false);
		}
		response.getWriter().append(json.toString());
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
