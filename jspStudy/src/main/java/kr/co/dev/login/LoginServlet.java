package kr.co.dev.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet.do" )
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	response.setContentType("text/html; Charset = UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
    	// 사용자정보 가져오기(세션객체가 있으면 처리, 없으면 null)
    	HttpSession session = request.getSession(false);
    	// 세션정보가 있으면 아이디 패스워드가져오기, 없으면 로그인창이동
    	try {
    		if(session != null) {
    			System.out.println("세션고유아이디" + session.getId());
    			String id = (String)session.getAttribute("id");
    			String pass = (String)session.getAttribute("pass");
   			
    			
    			out.println("<html>");
    			out.println("<body>");
    			out.println("<table border='1' width='300'>");
    			out.println("<tr>");
    			out.println("<td width='300' align='center'>" + id + " 님 로그인 되었습니다.</td>");
    			out.println("</tr>");
    			out.println("<tr>");
    			out.println("<td width='300' align='center'>" + pass + " 님 로그인 되었습니다.</td>");
    			out.println("</tr>");
    			out.println("<tr>");
    			out.println("<td align='center'>");
    			out.println("<a href='/jspStudy/registerServlet.do'>회원가입</a>");
    			out.println("<a href='/jspStudy/logoutServlet.do'>로그아웃</a>");
    			out.println("</td>");
    			out.println("</tr>"); 
    			out.println("</table>");
    			out.println("</body>");
    			out.println("</html>"); 			 			
    		}else {
    			out.println("<html>");
    			out.println("<body>");
    			out.print("<form method='post' action='/jspStudy/loginCheck.do'>");
    			out.println("<table border='1' width='300'>");
    			out.println("<tr>");
    			out.println("<th width='100'>아이디</th>");
    			out.println("<td width='200'>&nbsp;<input type='text' name='id'></td>");
    			out.println("</tr>");
    			out.println("<tr>");
    			out.println("<th width='100'>비번</th>");
    			out.println("<td width='200'>&nbsp;<input type='pass' name='pass'></td>");
    			out.println("</tr>");
    			out.println("<tr>");
    			out.println("<td align='center' colspan='2'>");
    			out.println("<input type='button' value='회원가입' onclick=\"location.href='/jspStudy/registerServlet.do'\">");
    			out.println("<input type='submit' value='로그인'>");
    			out.println("</td>");
    			out.println("</tr>");
    			out.println("</form>");
    			out.println("</table>");
    			out.println("</body>");
    			out.println("</html>");
    		}
    		
    	}catch(Exception e) {
    		System.out.println(e.toString());
    	}finally {
    		if(out != null) {
    			out.close();
    		}
    	}
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
		
	}
	

}
