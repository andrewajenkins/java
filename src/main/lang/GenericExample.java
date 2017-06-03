package main.lang;

public class GenericExample<KeyType, DataType> {

	private final KeyType key;
	private final DataType data;

	public GenericExample(KeyType key, DataType data) {
		this.key = key;
		this.data = data;
	}

	public KeyType getKey() {
		return key;
	}

	public DataType getData() {
		return data;
	}

	public String toString() {
		return key + " " + data;
	}

	public static <E> E printHashCode(E e) {
	    System.out.println(e.hashCode());
	    return e;
	}

	public static void main(String[] args) {
		int key = 6;
		String data = "hi";
		GenericExample<Integer, String> ge = new GenericExample<Integer, String>(key, data);
		System.out.println(ge);
	}
}