package Zadanie3;


public class Test {

	public static void main(String[] args) {
		
		Thread t1 = new Lamport(true,0,100);
		Thread t2 = new Lamport(true,1,100);
		Thread t3 = new Lamport(true,2,100);
		Thread t4 = new Lamport(true,3,100);
		Thread t5 = new Lamport(true,4,100);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
	}

}
