package rentalServer.board.module;

import java.sql.Timestamp;

public class BoardResponseDto {
	
	private String title;
	private String contents;
	private int code;
	private String userId;
	private java.sql.Timestamp regDate;
	private java.sql.Timestamp modDate;
	
	
	public BoardResponseDto(String title, String contents, int code, String userId, Timestamp regDate,
			Timestamp modDate) {
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
	public String getUserId() {
		return userId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public java.sql.Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(java.sql.Timestamp regDate) {
		this.regDate = regDate;
	}
	public java.sql.Timestamp getModDate() {
		return modDate;
	}
	public void setModDate(java.sql.Timestamp modDate) {
		this.modDate = modDate;
	}
	
	
}

