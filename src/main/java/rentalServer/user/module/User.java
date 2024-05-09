package rentalServer.user.module;

import java.security.Timestamp;

public class User {

	private String id;
	private String password;
	private String email;
	private String name;
	private String birth;
	private String gender;
	private String phone;
	private java.sql.Timestamp regDate;
	private java.sql.Timestamp modDate;

	public User(String id, String email, String name, String birth, String gender,
			String phone, java.sql.Timestamp regDate, java.sql.Timestamp modDate) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		this.regDate = regDate;
		this.modDate = modDate;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getBirth() {
		return birth;
	}

	public java.sql.Timestamp getRegDate() {
		return regDate;
	}

	public java.sql.Timestamp getModDate() {
		return modDate;
	}

	public String getGender() {
		return gender;
	}

	public String getPhone() {
		return phone;
	}


}