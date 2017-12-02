package test;

public class Singleton {
	private static Singleton instance;

	Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
			System.out.println("hi!");
		}
		System.out.println("hello!");
		return instance;
	}
}