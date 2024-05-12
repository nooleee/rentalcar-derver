package rentalServer.cars.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalServer.car.module.CarsDao;
import rentalServer.car.module.CarsResponseDto;

public class CarAction extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarsDao carDao = CarsDao.getInstance();
		List<CarsResponseDto> carList = carDao.findCarsAll();
		
		request.setAttribute("carList", carList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/carlist");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
