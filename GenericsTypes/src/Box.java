
public class Box<T> {

	private String name;
	private T object;

	public Box(String name) {
		this.name = name;
	}

	public T get() {
		if (isEmpty()) {
			System.out.println("A doboz �res");
			return null;
		} else {
			T temp = object;
			object = null;
			System.out.println("Kiv�ve a '" + name + "' nev� dobozb�l");
			return temp;
		}
	}

	public void put(T objectToPut) {
		if (isEmpty()) {
			this.object = objectToPut;
			System.out.println("Elhelyezve a '" + name + "' nev� dobozban");
		} else {
			System.out.println("A(z) '" + name + "' nev� doboz nem �res");
		}
	}

	public boolean isEmpty() {
		return object == null;
	}

	public boolean isFull() {
		return !isEmpty();
	}
}
