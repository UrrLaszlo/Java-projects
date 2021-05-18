
public class Main {

	public static void main(String[] args) {
		
		Box<String> box = new Box<>("blue box");
		boolean empty = box.isEmpty();
		System.out.println(empty ? "A doboz �res" : "A doboz nem �res");
		box.put("labda");
		box.put("asztal");
		
		Box<Integer> anotherBox =new Box("green box");
		anotherBox.put(42);
		
		String text = box.get();
		System.out.println(text);
		
		Integer number = anotherBox.get();
		System.out.println(number);
	}

}
