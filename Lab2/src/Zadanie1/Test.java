package Zadanie1;

public class Test {

	public static void main(String[] args) {
		
		Thread t1 = new Dekker(false,0,100);
		Thread t2 = new Dekker(false,1,100);
		
		t1.start();
		t2.start();

	}

}
