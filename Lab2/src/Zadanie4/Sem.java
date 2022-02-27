package Zadanie4;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Sem extends Thread{

	private int nr;
	private boolean wyb;
	private int N;
	public static Semaphore sem = new Semaphore(1);
	public static char[] znaki = {'-', '+', '*', '%', '='};
	
	public Sem(boolean wyb, int nr, int N){
		super("Sem-" + nr);
		this.nr = nr;
		this.wyb = wyb;
		this.N = N;
	}
	


	public void run() {
		
		if(wyb == true) {
			char znak = 0;
			if(nr == 0) {
				 znak = znaki[0];
			}
			else if(nr == 1) {
				 znak = znaki[1];
			}
			else if(nr == 2) {
				 znak = znaki[2];
			}
			else if(nr == 3) {
				 znak = znaki[3];
			}
			else if(nr == 4) {
				 znak = znaki[4];
			}
			dzialanieSynchr(znak, nr, N);
		}
		else if(wyb == false) {
			char znak = 0;
			if(nr == 0) {
				 znak = znaki[0];
			}
			else if(nr == 1) {
				 znak = znaki[1];
			}
			else if(nr == 2) {
				 znak = znaki[2];
			}
			else if(nr == 3) {
				 znak = znaki[3];
			}
			else if(nr == 4) {
				 znak = znaki[4];
			}
			dzialanieNiesynchr(znak, nr, N);
		}
	}
	
	public void dzialanieSynchr(char znak, int nr, int N) {
		Random rand = new Random();
		for(int i = 0; i< N; i++) {
			try {
				Thread.sleep(rand.nextInt(10)+1);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			try {
			sem.acquire();
			System.out.println("\nSekcja krytyczna watku: "+ getName() + ", nr powt. = " + i);
			for(int j = 0; j< 100; j++) {
				System.out.print(znak);
			}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			sem.release();
			}
	}
	public void dzialanieNiesynchr(char znak, int nr, int N) {
		
		
		Random rand = new Random();
		for(int i = 0; i< N; i++) {
			try {
				Thread.sleep(rand.nextInt(10)+1);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			System.out.println("\nSekcja krytyczna watku: "+ getName() + ", nr powt. = " + i);
			for(int j = 0; j< 100; j++) {
				System.out.print(znak);
			}
		}
		
	}
	
}
