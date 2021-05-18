
public class Teacher extends Person {

	public Teacher(String firstname, String lastname, int age) {
		super(firstname, lastname, age);
	}

	@Override
	public String toString() {
		return "Teacher [getFirstname()=" + getFirstname() + ", getLastname()=" + getLastname() + ", getAge()="
				+ getAge() + "]";
	}

}
