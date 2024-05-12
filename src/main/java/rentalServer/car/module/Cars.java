package rentalServer.car.module;

public class Cars {
	private String name;
	private int code;
	private boolean navigation;
	private boolean sunroof;
	private String color;
	private int cataCode;
	
	
	public Cars(String name, int code, boolean navigation, boolean sunroof, String color, int cataCode) {
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


	public int getCode() {
		return code;
	}


	public boolean isNavigation() {
		return navigation;
	}


	public boolean isSunroof() {
		return sunroof;
	}


	public String getColor() {
		return color;
	}


	public int getCataCode() {
		return cataCode;
	}
	
	
	
}
