
public class Student extends Person {

	public Student(String firstname, String lastname, int age) {
		super(firstname, lastname, age);
	}

	@Override
	public String toString() {
		return "Student [getFirstname()=" + getFirstname() + ", getLastname()=" + getLastname() + ", getAge()="
				+ getAge() + "]";
	}

}
