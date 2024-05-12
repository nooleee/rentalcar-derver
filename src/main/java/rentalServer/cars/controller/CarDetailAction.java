package rentalServer.cars.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalServer.car.module.CarsDao;
import rentalServer.car.module.CarsResponseDto;

public class CarDetailAction extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		
		int code = Integer.parseInt(path.split("/")[1]);
		System.out.println("code : " + code);
		
		
		CarsDao carDao = CarsDao.getInstance();
		CarsResponseDto car = carDao.findCarByCode(code);
		
		System.out.println("차량 : " + car.getName());
		System.out.println("색상 : " + car.getColor());
		
		request.setAttribute("cars", car);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/carView/" + code);
		dispatcher.forward(request, response);
	}
}
