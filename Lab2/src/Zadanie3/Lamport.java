package Zadanie3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Lamport extends Thread {

	private int nr;
	private boolean wyb;
	private int N;
	public static volatile boolean[] wybieranie = {false,false,false,false,false};
	public static volatile Integer[] numerek = {0,0,0,0,0,};
	public static volatile char[] znaki = {'-', '+', '*', '%', '='};
	
	Lamport(boolean wyb, int nr, int N){
		super("Lamport-" + nr);
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
			dzialanieSynchr(znak,nr,N);
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
			dzialanieNiesynchr(znak,nr,N);
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
			
			wybieranie[nr] = true;
			numerek[nr] = Collections.max(Arrays.asList(numerek))+1;
			wybieranie[nr] = false;
			for(int j = 0; j<numerek.length; j++) {
				while(wybieranie[j]) {
					//czekaj
				}
				while(numerek[j] != 0 && (numerek[j] < numerek[nr])) {
					//czekaj
				}
				if(numerek[j] == numerek[nr]) {
					while(numerek[j] != 0 && j<(nr)) {
						//czekaj
					}
				}
			}
			System.out.println("\nSekcja krytyczna watku: "+ getName() + ", nr powt. = " + i);
			for(int j = 0; j< 100; j++) {
				System.out.print(znak);
			}
			numerek[nr] = 0;
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
	

