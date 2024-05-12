package rentalServer.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalServer.board.module.BoardDao;
import rentalServer.board.module.BoardResponseDto;


public class BoardAction extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao boardDao = BoardDao.getInstance();
		List<BoardResponseDto> boardList = boardDao.findBoardAll();
		
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/boardlist");
		dispatcher.forward(request, response);
	}
}
