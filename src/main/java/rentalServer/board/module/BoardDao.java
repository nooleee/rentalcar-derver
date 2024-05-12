package rentalServer.board.module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rentalServer.util.DBManager;

public class BoardDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private BoardDao() {
		
	}
	
	private static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	
	public List<BoardResponseDto> findBoardAll() {
		List<BoardResponseDto> list = new ArrayList<BoardResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			
			
			// 쿼리할 준비
			String sql = "SELECT title, code, contents, user_id, reg_date, mod_date FROM board";
			this.pstmt = conn.prepareStatement(sql);
			
			// 쿼리 실행
			rs = pstmt.executeQuery();
			
			// 튜플 읽기
			while(rs.next()) {
				// database의 cloumn index는 1부터 시작!
				String title = rs.getString(1);
				int code = rs.getInt(2);
				String contents = rs.getString(3);
				String user_id = rs.getString(4);
				java.sql.Timestamp regDate = rs.getTimestamp(5);
				java.sql.Timestamp modDate = rs.getTimestamp(6);
				
				BoardResponseDto board = new BoardResponseDto(title, contents, code, user_id, regDate, modDate);
				list.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	
	public List<BoardResponseDto> findBoardWriteId(String userId) {
		List<BoardResponseDto> list = new ArrayList<BoardResponseDto>();
		
		try {
			conn = DBManager.getConnection();
			
			
			// 쿼리할 준비
			String sql = "SELECT  user_id, title, code, contents, reg_date, mod_date FROM board WHFER user_id=?";
			this.pstmt = conn.prepareStatement(sql);
			
			// 쿼리 실행
			rs = pstmt.executeQuery();
			
			// 튜플 읽기
			while(rs.next()) {
				String user_id = rs.getString(1);
				if(user_id.equals(userId)) {
					// database의 cloumn index는 1부터 시작!
					String title = rs.getString(2);
					int code = rs.getInt(3);
					String contents = rs.getString(4);
					java.sql.Timestamp regDate = rs.getTimestamp(5);
					java.sql.Timestamp modDate = rs.getTimestamp(6);
					
					BoardResponseDto board = new BoardResponseDto(title, contents, code, user_id, regDate, modDate);
					list.add(board);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public BoardResponseDto findBoardById(String userId) {
		BoardResponseDto board = null;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT user_id, title, code, contents, reg_date, mod_date FROM board WHERE code=?";
			
			BoardDao boardDao = BoardDao.getInstance();
			System.out.println("user : " + userId);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString(2);
				int code = rs.getInt(3);
				String contents = rs.getString(4);
//				String user_id = rs.getString(4);
				java.sql.Timestamp reg_date = rs.getTimestamp(5);
				java.sql.Timestamp mod_date = rs.getTimestamp(6);
				
				board = new BoardResponseDto(title, contents, code, userId, reg_date, mod_date);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return board;
	}
	
	public BoardResponseDto findBoardByCode(int code) {
		BoardResponseDto board = null;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT code, user_id, title,  contents, reg_date, mod_date FROM board WHERE code=?";
			
			BoardDao boardDao = BoardDao.getInstance();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String userId = rs.getString(2);
				String title = rs.getString(3);
				String contents = rs.getString(4);
				java.sql.Timestamp reg_date = rs.getTimestamp(5);
				java.sql.Timestamp mod_date = rs.getTimestamp(6);
				
				board = new BoardResponseDto(title, contents, code, userId, reg_date, mod_date);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return board;
	}
	
	public BoardResponseDto createBoard(BoardRequestDto boardDto) {
		
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO board(title, contents, user_id) VALUES(?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardDto.getTitle());
			pstmt.setString(2, boardDto.getContents());
			pstmt.setString(3, boardDto.getUser_id());
			
			pstmt.execute();
			
			return findBoardById(boardDto.getUser_id());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return null;
	}
	
	public BoardResponseDto updateBoardTilte(BoardRequestDto boardDto, String newTitle) {
		BoardResponseDto board = null;
		
		if(findBoardById(boardDto.getUser_id()) == null) {
			return board;
		}
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE board SET title=? WHERE user_id=? AND code=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newTitle);
			pstmt.setString(2, boardDto.getUser_id());
			pstmt.setInt(3, boardDto.getCode());
			
			pstmt.execute();
			
			board = findBoardById(boardDto.getUser_id());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return board;
	}
	
	public BoardResponseDto updateBoardContents(BoardRequestDto boardDto, String newContents) {
		BoardResponseDto board = null;
		
		if(findBoardById(boardDto.getUser_id()) == null) {
			return board;
		}
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE board SET contents=? WHERE user_id=? AND code=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newContents);
			pstmt.setString(2, boardDto.getUser_id());
			pstmt.setInt(3, boardDto.getCode());
			
			pstmt.execute();
			
			board = findBoardById(boardDto.getUser_id());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return board;
	}
	
	
	public boolean deleteBoard(BoardRequestDto boardDto) {
		
		if(findBoardById(boardDto.getUser_id()) == null)
			return false;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "DELETE FROM board WHERE user_id=? AND code=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardDto.getUser_id());
			pstmt.setInt(2, boardDto.getCode());
			
			pstmt.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return false;
	}
	
}
