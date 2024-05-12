package rentalServer.board.module;

import java.sql.Timestamp;

public class BoardRequestDto {
	
	private String title;
	private String contents;
	private int code;
	private String user_id;
	private java.sql.Timestamp regDate;
	private java.sql.Timestamp modDate;
	
	public BoardRequestDto() {
		
	}
	
	public BoardRequestDto(String title, String contents, int code, String user_id, Timestamp regDate,
			Timestamp modDate) {
		super();
		this.title = title;
		this.contents = contents;
		this.code = code;
		this.user_id = user_id;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	
	public BoardRequestDto(String title, String contents, String user_id) {
		super();
		this.title = title;
		this.contents = contents;
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
