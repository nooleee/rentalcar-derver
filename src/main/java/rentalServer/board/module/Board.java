package rentalServer.board.module;

import java.sql.Timestamp;

public class Board {

	private String title;
	private String contents;
	private int code;
	private String userId;
	private java.sql.Timestamp regDate;
	private java.sql.Timestamp modDate;
	
	
	public Board(String title, String contents, int code, String userId, Timestamp regDate, Timestamp modDate) {
		super();
		this.title = title;
		this.contents = contents;
		this.code = code;
		this.userId = userId;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	
	
	public String getTitle() {
		return title;
	}
	public String getContents() {
		return contents;
	}
	public int getCode() {
		return code;
	}
	public String getUser_id() {
		return userId;
	}
	public java.sql.Timestamp getRegDate() {
		return regDate;
	}
	public java.sql.Timestamp getModDate() {
		return modDate;
	}
	
}
