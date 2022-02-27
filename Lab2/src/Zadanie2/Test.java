package Zadanie2;


public class Test {

	public static void main(String[] args) {
		
		Thread t1 = new Peterson(true,0,100);
		Thread t2 = new Peterson(true,1,100);
		
		t1.start();
		t2.start();

	}

}
