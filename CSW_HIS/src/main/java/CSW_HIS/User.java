package CSW_HIS;

public class User {
	private int id;
	private final String name;
	private final int age;
	private final String address;
	
	public User(int id, String name, int age, String address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
		
}