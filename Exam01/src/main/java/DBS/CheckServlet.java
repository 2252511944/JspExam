package DBS;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * ������д�������ݿ���߼�
 * */
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CheckUserService cku = new CheckUserService(); // 
       
    public CheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		System.out.println(userName);
		RequestDispatcher rd = null;
		String forward = null;
		if(userName == null){
			request.setAttribute("msg", "�û�Ϊ��");
			rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}else{
			User user = new User();
			user.setName(userName);
			boolean bool = cku.check(user);
			if(bool){
				forward = "/index.jsp";
			}else{
				request.setAttribute("msg", "�û���");
				forward = "/error.jsp";
			}
			rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}
	}

}
