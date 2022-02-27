package Zadanie1;

import java.util.Random;

public class Dekker extends Thread {
	
	private int nr;
	private int N;
	public boolean wyb;
	public static volatile boolean[] chce = {true, true};
	public static volatile int czyja_kolej = 1;
	public static volatile char[] znaki = {'-', '+'};

	Dekker(boolean wyb,int nr, int N){
		super("Dekker-" + nr);
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
			dzialanieNiesynchr(znak, nr, N);
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
			while(chce[1] == false) {
				if(czyja_kolej == 2) {
					chce[0] = true;
					while(czyja_kolej == 2);
					chce[0] = false;
				}
			}
			System.out.println("\nSekcja krytyczna watku: "+ getName() + ", nr powt. = " + i);
			for(int j = 0; j< 100; j++) {
				System.out.print(znak);
			}
			
			chce[0] = true;
			czyja_kolej = 2;
			
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
				while(chce[0] == false) {
					if(czyja_kolej == 1) {
						chce[1] = true;
						while(czyja_kolej == 1);
						chce[1] = false;
					}
				}
				System.out.println("\nSekcja krytyczna watku: "+ getName() + ", nr powt. = " + i);
				for(int j = 0; j< 100; j++) {
					System.out.print(znak);
				}
				chce[1] = true;
				czyja_kolej = 1;
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
