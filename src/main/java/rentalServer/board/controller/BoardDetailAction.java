package rentalServer.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalServer.board.module.BoardDao;
import rentalServer.board.module.BoardResponseDto;

public class BoardDetailAction extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		
		int code = Integer.parseInt(path.split("/")[1]);
		System.out.println("code : " + code);
		
		
		BoardDao boardDao = BoardDao.getInstance();
		BoardResponseDto board = boardDao.findBoardByCode(code);
		System.out.println("제목 : " + board.getTitle());
		System.out.println("내용 : " + board.getContents());
		System.out.println("작성자 : " + board.getUserId());
			
		request.setAttribute("board", board);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/boardView/" + code);
		dispatcher.forward(request, response);
	}
		
		
}

