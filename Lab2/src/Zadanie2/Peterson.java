package Zadanie2;

import java.util.Random;

public class Peterson extends Thread {

	private int nr;
	private int N;
	private boolean wyb;
	public static volatile boolean[] chce = {true, true};
	public static volatile int czyja_kolej = 1;
	public static volatile char[] znaki = {'-', '+'};
	
	
	Peterson(boolean wyb,int nr, int N){
		super("Peterson-" + nr);
		this.nr = nr;
		this.wyb = wyb;
		this.N = N;
	}
	
	public void run() {
		
		if(wyb == true) {
			char znak = 0;
			if(nr == 0) {
				 znak = znaki[1];
			}
			else if(nr == 1) {
				 znak = znaki[0];
			}
			dzialanieSynchr(znak, nr,N);
		}
		else if(wyb == false) {
			char znak = 0;
			if(nr == 0) {
				 znak = znaki[1];
			}
			else if(nr == 1) {
				 znak = znaki[0];
			}
			dzialanieNiesynchr(znak, nr,N);
		}
		
	}
	
	public void dzialanieSynchr(char znak, int nr, int N) {
		
		if(nr == 0) {
		Random rand = new Random();
		for(int i = 0; i< N; i++) {
			try {
				Thread.sleep(rand.nextInt(10)+1);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		
			chce[0] = false;
			czyja_kolej = 2;
			while(chce[1] == false && czyja_kolej == 2)
			{
				//czekaj
			}
			System.out.println("\nSekcja krytyczna watku: "+ getName() + ", nr powt. = " + i);
			for(int j = 0; j< 100; j++) {
				System.out.print(znak);
			}
			chce[0] = true;
			}
		}
		if(nr == 1) {
			Random rand = new Random();
			for(int i = 0; i< N; i++) {
				try {
					Thread.sleep(rand.nextInt(10)+1);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			chce[1] = false;
			czyja_kolej = 1;
			while(chce[0] == false && czyja_kolej == 1)
			{
				//czekaj
			}
			System.out.println("\nSekcja krytyczna watku: "+ getName() + ", nr powt. = " + i);
			for(int j = 0; j< 100; j++) {
				System.out.print(znak);
			}
			chce[1] = true;
			}
		}
	}
	
	public void dzialanieNiesynchr(char znak, int nr, int N) {
		
		if(nr == 0) {
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
			if(nr == 1) {
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
}
