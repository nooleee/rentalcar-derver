package rentalServer.user.module;

import rentalServer.user.module.User;

public class UserResponseDto {
	
	private String id;
	private String email;
	private String name;
	private String birth;
	private String gender;
	private String phone;
	
	public UserResponseDto(String id, String email, String name, String birth, String gender, String phone) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
	}
	public UserResponseDto(String id, String password, String email, String name, String birth, String gender,
			String phone) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
	}
	
	public UserResponseDto(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.name = user.getName();
		this.birth = user.getBirth();
		this.gender = user.getGender();
		this.phone = user.getPhone();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}