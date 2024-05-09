package rentalServer.user.module;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import rentalServer.util.DBManager;
import rentalServer.util.PasswordCrypto;

public class UserDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// UserDao 객체를 단일 인스턴스로 만들기 위해
	// Singleton Pattern 적용
	
	// 1. 생성자를 private으로
	private UserDao() {
	}
	
	// 2. 단일 인스턴스 생성 (클래스 내부에서)
	private static UserDao instance = new UserDao();
	
	// 3. 단일 인스턴스에 대한 getter
	public static UserDao getInstance() {
		return instance;
	}

	
	public List<UserResponseDto> findUserAll() {
		List<UserResponseDto> list = new ArrayList<UserResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			
			
			// 쿼리할 준비
			String sql = "SELECT id, email, name, birth, gender, phone FROM users";
			this.pstmt = conn.prepareStatement(sql);
			
			// 쿼리 실행
			rs = pstmt.executeQuery();
			
			// 튜플 읽기
			while(rs.next()) {
				// database의 cloumn index는 1부터 시작!
				String id = rs.getString(1);
				String email = rs.getString(2);
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String gender = rs.getString(5);
				String phone = rs.getString(6);
				
				UserResponseDto user = new UserResponseDto(id, email, name, birth, gender, phone);
				list.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public UserResponseDto findUserByIdAndPassword(String id, String password) {
		UserResponseDto user = null;
		
		// 데이터베이스에 있는 암호화된 패스워드 str 를 얻어와
		// PasswordCrypto.decryt(str) 를 통해 
		// 일치여부 확인 후
		// return
		
		try {
			conn = DBManager.getConnection();
			// 쿼리할 준비
			String sql = "SELECT id, email, name, birth, gender, phone, password FROM users WHERE id =?";
			
			UserDao userDao = UserDao.getInstance();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			// 쿼리 실행
			rs = pstmt.executeQuery();
			
			// 튜플 읽기
			if(rs.next()) {
				String email = rs.getString(2);
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String gender = rs.getString(5);
				String phone = rs.getString(6);
				String encryptedPassword = rs.getString(7);
				
				if(PasswordCrypto.decrypt(password, encryptedPassword))
					user = new UserResponseDto(id, email, name, birth, gender, phone);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return user;
	}
	
	public boolean userExists(String id) {
		return findUserById(id) != null;
	}
	
	public UserResponseDto createUser(UserRequestDto userDto) {
		// sql 구문을 쿼리하고
		// 실행한 결과(ResultSet) 을 가져와
		// 성공을 했다면 -> UserResponseDto 객체 생성하여
		// 반환
		
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO users(id, password, gender, name, phone, birth, email) VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			// sql 구문에 맵핑할 값 설정
			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, PasswordCrypto.encrypt(userDto.getPassword()));
			pstmt.setString(3, userDto.getGender());
			pstmt.setString(4, userDto.getName());
			pstmt.setString(5, userDto.getPhone());
			pstmt.setString(6, userDto.getBirth());
			
			String email = userDto.getEmail().equals("") ? null : userDto.getEmail();
			pstmt.setString(7, email);
			
			pstmt.execute();
			
			return findUserByIdAndPassword(userDto.getId(), userDto.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return null;
	}
	
	public UserResponseDto updateUserPassword(UserRequestDto userDto, String newPassword) {
		UserResponseDto user = null;
		
		if(newPassword == null || newPassword.equals("")) {
			return user;
		}
		
		if(findUserByIdAndPassword(userDto.getId(), userDto.getPassword()) == null) {
			return user;
		}
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE users SET password=? WHERE id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, PasswordCrypto.encrypt(newPassword));
			pstmt.setString(2, userDto.getId());
			
			pstmt.execute();
			
			User userVo = findUserById(userDto.getId());
			user = new UserResponseDto(userVo);
			
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return user;
	}
	
	public UserResponseDto updateUserEmail(UserRequestDto userDto) {
		UserResponseDto user = null;
		
		if(findUserByIdAndPassword(userDto.getId(), userDto.getPassword()) == null) {
			return user;
		}
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE users SET email=? WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getEmail());
			pstmt.setString(2, userDto.getId());
			
			pstmt.execute();
			
			user = findUserByIdAndPassword(userDto.getId(), userDto.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return user;
	}
	
	public UserResponseDto updateUserPhone(UserRequestDto userDto) {
		UserResponseDto user = null;
		
		if(findUserByIdAndPassword(userDto.getId(), userDto.getPassword()) == null) {
			return user;
		}
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE users SET phone=? WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getPhone());
			pstmt.setString(2, userDto.getId());
			
			pstmt.execute();
			
			user = findUserByIdAndPassword(userDto.getId(), userDto.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return user;
	}
	
	public boolean deleteUser(UserRequestDto userDto) {
		
		if(findUserByIdAndPassword(userDto.getId(), userDto.getPassword()) == null)
			return false;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "DELETE FROM users WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userDto.getId());
			
			pstmt.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return false;
	}
	
	private User findUserById(String id) {
		User user = null;
		
		try {
			conn = DBManager.getConnection();
			
			// 쿼리할 준비
			String sql = "SELECT id, email, name, birth, gender, phone, reg_date, mod_date FROM users WHERE id=?";
			this.pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			
			// 쿼리 실행
			rs = pstmt.executeQuery();
			
			// 튜플 읽기
			if(rs.next()) {
				String email = rs.getString(2);
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String gender = rs.getString(5);
				String phone = rs.getString(6);
				java.sql.Timestamp regDate = rs.getTimestamp(7);
				java.sql.Timestamp modDate = rs.getTimestamp(8);
				
				user = new User(id, email, name, birth, gender, phone, regDate, modDate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return user;
	}
}
