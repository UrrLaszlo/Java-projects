
public class Box<T> {

	private String name;
	private T object;

	public Box(String name) {
		this.name = name;
	}

	public T get() {
		if (isEmpty()) {
			System.out.println("A doboz üres");
			return null;
		} else {
			T temp = object;
			object = null;
			System.out.println("Kivéve a '" + name + "' nevû dobozból");
			return temp;
		}
	}

	public void put(T objectToPut) {
		if (isEmpty()) {
			this.object = objectToPut;
			System.out.println("Elhelyezve a '" + name + "' nevû dobozban");
		} else {
			System.out.println("A(z) '" + name + "' nevû doboz nem üres");
		}
	}

	public boolean isEmpty() {
		return object == null;
	}

	public boolean isFull() {
		return !isEmpty();
	}
}
