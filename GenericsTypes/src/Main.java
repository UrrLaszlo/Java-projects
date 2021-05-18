
public class Main {

	public static void main(String[] args) {
		
		Box<String> box = new Box<>("blue box");
		boolean empty = box.isEmpty();
		System.out.println(empty ? "A doboz üres" : "A doboz nem üres");
		box.put("labda");
		box.put("asztal");
		
		Box<Integer> anotherBox =new Box("green box");
		anotherBox.put(42);
		
		String text = box.get();
		System.out.println(text);
		
		Integer number = anotherBox.get();
		System.out.println(number);
		
		
		Person person = new Person("Elek", "Teszt", 32);
		Student student = new Student("Jakab", "Gipsz", 42);
		Person goodStudent = new Student("Béla", "Kiss", 19);
		Person teacher = new Teacher("Ilona", "Nagy", 50);
		System.out.println(person);
		System.out.println(student);
		System.out.println(goodStudent);
		System.out.println(teacher);
		
		Box<Person> box2 = new Box<>("magic box");
		box2.put(person);
		Person person2 = box2.get();
		System.out.println(person2);
		
		box2.put(student);
	}

}
