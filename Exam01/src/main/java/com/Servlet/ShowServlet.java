package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBS.ConnectionFactory;
import Film.FilmDaoImpl;


public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 显示界面逻辑实现
		try {
			Connection conn = ConnectionFactory.getInstance().makeConnection(); // 加载驱动
			FilmDaoImpl fd = new FilmDaoImpl();
			ResultSet rs = fd.get(conn);
			req.setAttribute("result",rs);
			RequestDispatcher rd  = req.getRequestDispatcher("/show.jsp");
			rd.forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
