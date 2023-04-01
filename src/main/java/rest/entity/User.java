package rest.entity;

public class User {
	private String Name;
	private Integer Salary;
	
	public User() {
		super();
	}
	
	public User(String Name, Integer Salary) {
		this.Name = Name;
		this.Salary = Salary;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public Integer getSalary() {
		return Salary;
	}

	public void setSalary(Integer Salary) {
		this.Salary = Salary;
	}
	
	
}
