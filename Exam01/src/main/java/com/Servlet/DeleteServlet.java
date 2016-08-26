package com.Servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import DBS.ConnectionFactory;
import Film.FilmDao;
import Film.FilmDaoImpl;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmDao filmDao = new FilmDaoImpl();

	public DeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		RequestDispatcher rd = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			filmDao.delete(conn, request.getParameter("film_id"));
			rd = request.getRequestDispatcher("/show.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}

	}

}
