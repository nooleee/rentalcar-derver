package rentalServer.car.module;

public class CarsResponseDto {
	private String name;
	private int code;
	private boolean navigation;
	private boolean sunroof;
	private String color;
	private int cataCode;
	
	public CarsResponseDto(String name, int code, boolean navigation, boolean sunroof, String color, int cataCode) {
		super();
		this.name = name;
		this.code = code;
		this.navigation = navigation;
		this.sunroof = sunroof;
		this.color = color;
		this.cataCode = cataCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isNavigation() {
		return navigation;
	}

	public void setNavigation(boolean navigation) {
		this.navigation = navigation;
	}

	public boolean isSunroof() {
		return sunroof;
	}

	public void setSunroof(boolean sunroof) {
		this.sunroof = sunroof;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCataCode() {
		return cataCode;
	}

	public void setCataCode(int cataCode) {
		this.cataCode = cataCode;
	}
	
	
	
}
