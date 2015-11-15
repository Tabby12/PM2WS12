package aufgabenblatt2;

/**
 * Repraesentiert Kontrollthreads fuer Simulierte Autorennen. Fuehrt mit bestimmter Wahrscheinlichkeit
 * Rennabbrueche herbei
 * @author Lennart Hartmann
 * @version 14.11.2015
 *
 */
public class Rennabbruch extends Thread{
	/**
	 * Die kontrollierte Rennstrecke
	 */
	Rennstrecke strecke;
	
	public Rennabbruch(Rennstrecke strecke) {
		this.strecke=strecke;
	}
	
	/**
	 * Die Rennabbruchsteuerung
	 */
	@Override
	public void run(){
		while(Math.random() < 0.9){
			
			System.err.println("pruefe Abbruchbedingung");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
//				break;
//				e.printStackTrace();
				this.interrupt();
			}
		}
		strecke.brecheRennenAb();
	}
}
