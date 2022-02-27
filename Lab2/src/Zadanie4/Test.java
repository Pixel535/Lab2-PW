package Zadanie4;



public class Test {

	public static void main(String[] args) {
		
		Thread t1 = new Sem(true,0,100);
		Thread t2 = new Sem(true,1,100);
		Thread t3 = new Sem(true,2,100);
		Thread t4 = new Sem(true,3,100);
		Thread t5 = new Sem(true,4,100);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}

}
