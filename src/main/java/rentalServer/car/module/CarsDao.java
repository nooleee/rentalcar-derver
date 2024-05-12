package rentalServer.car.module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rentalServer.util.DBManager;

public class CarsDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private CarsDao() {}
	
	private static CarsDao instance = new CarsDao();
	
	public static CarsDao getInstance() {
		return instance;
	}
	
	public List<CarsResponseDto> findCarsAll() {
		List<CarsResponseDto> list = new ArrayList<CarsResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			
			
			// 쿼리할 준비
			String sql = "SELECT code, name, color, cata_code, navigation, sunroof FROM cars";
			this.pstmt = conn.prepareStatement(sql);
			
			// 쿼리 실행
			rs = pstmt.executeQuery();
			
			// 튜플 읽기
			while(rs.next()) {
				int code = rs.getInt(1);
				String name = rs.getString(2);
				String color = rs.getString(3);
				int cataCode = rs.getInt(4);
				boolean navigation = rs.getBoolean(5);
				boolean sunroof = rs.getBoolean(6);
				
				CarsResponseDto user = new CarsResponseDto(name, code, navigation, sunroof, color, cataCode);
				list.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public CarsResponseDto findCarByCode(int code) {
		CarsResponseDto car = null;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT code, name, color, cata_code, navigation, sunroof FROM cars WHERE code=?";
			
			CarsDao carsDao = CarsDao.getInstance();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString(2);
				String color = rs.getString(3);
				int cataCode = rs.getInt(4);
				boolean navigation = rs.getBoolean(5);
				boolean sunroof = rs.getBoolean(6);
				
				car = new CarsResponseDto(name, code, navigation, sunroof, color, cataCode);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return car;
	}
	
	
}
