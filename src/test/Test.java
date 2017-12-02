package test;

public class Test {

	final int a;

	public Test() {
		a = 7;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getA());

	}

	public static int getA() {
		final int a = 10;

		return a;
	}

}
