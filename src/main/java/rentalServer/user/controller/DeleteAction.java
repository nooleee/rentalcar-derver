package rentalServer.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalServer.user.module.UserDao;
import rentalServer.user.module.UserRequestDto;
import rentalServer.user.module.UserResponseDto;

/**
 * Servlet implementation class DeleteUserFormAction
 */
public class DeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		UserDao userDao = UserDao.getInstance();
		HttpSession session = request.getSession();

		UserResponseDto user = (UserResponseDto) session.getAttribute("user");

		String id = user.getId();
		String password = request.getParameter("password");

		// 패스워드가 일치하면 -> 삭제 처리
		UserRequestDto userDto = new UserRequestDto();

		userDto.setId(id);
		userDto.setPassword(password);
		boolean result = userDao.deleteUser(userDto);

		if(result) {
			response.sendRedirect("/");
		} else {
			response.sendRedirect("/delete");
		}
	}

}
