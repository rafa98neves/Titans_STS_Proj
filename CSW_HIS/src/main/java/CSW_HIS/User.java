package CSW_HIS;

import java.sql.Date;

public class User {
	private long id;
	private final String name;
	private final int age;
	private final String address;
	
	public User(long id, String name, int age, String address) {
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

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
		
}