package com.Servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBS.ConnectionFactory;
import Film.Film;
import Film.FilmDao;
import Film.FilmDaoImpl;


public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmDao filmDao = new FilmDaoImpl();

	public InsertServlet() {
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
		int film_id;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			film_id = Integer.parseInt(request.getParameter("film_id"));
			Film film = new Film(film_id, request.getParameter("title"), request.getParameter("description"));
			filmDao.insert(conn, film);
			rd = request.getRequestDispatcher("/jsp/index.jsp");
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
