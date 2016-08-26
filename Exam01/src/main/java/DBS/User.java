package DBS;

public class User extends IdEntity {
	
	private String first_name;

	public String getName() {
		return first_name;
	}
	public void setName(String name) {
		this.first_name = name;
	}
	
}
