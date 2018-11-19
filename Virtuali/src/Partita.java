import java.util.Random;

public class Partita {
	private static final int e = 44;
	private Squadra casa;
	private Squadra ospt;
	private int[] pnt = new int[2];
	private int t = 0;
	private int stato;
	private boolean possesso;
	
	private static Random rnd = new Random();

	public Partita(Squadra casa, Squadra ospt) {
		this.casa = casa;
		this.ospt = ospt;
		pnt[0] = 0;
		pnt[1] = 0;
	}

	public void giocoT() {
		int futuro;
		
		stato = 1;
		t++;
		if(t == 1)
			possesso = true;
		else
			possesso = false;
		for(int i=0; i<e; i++) {
			futuro = nextStato(stato);
			if(stato>futuro || (stato == 0 && stato == futuro))
				changePoss();
			stato = futuro;
		}
	}
	
	private int nextStato(int status) {
		Squadra palla;
		Squadra nopll;
		
		if(possesso) {
			palla = casa;
			nopll = ospt;
		}
		else {
			nopll = casa;
			palla = ospt;
		}
			
		switch(status) {
			case 0:
				return checkAct(100*palla.dif()+20*palla.cen(), 50*nopll.att()+5*nopll.cen(), status);
			case 1:
				return checkAct(20*palla.dif()+100*palla.cen()+20*palla.att(), 10*nopll.att()+90*nopll.cen()+30*nopll.dif(), status);
			case 2:
				return checkAct(70*palla.cen()+90*palla.att(), 60*nopll.cen()+90*nopll.dif(), status);
			case 3:
				return checkAct(50*palla.cen()+100*palla.att(), 30*nopll.cen()+100*nopll.dif(), status);
			default:
				return checkGoal(100*palla.att(), 100*nopll.dif());
		}
	}
	
	private int checkAct(int palla, int nopll, int status) {
		int stallo;
		
		if(status != 0)
			stallo = ((palla+nopll)/10)*4;
		else
			stallo = 0;
		int azione = rnd.nextInt(palla+nopll+stallo);
		if(azione>=nopll+stallo)
			return status+1;
		else if(azione>=stallo)
				return 0;
		else
			return status;
	}
	
	private int checkGoal(int attaccante, int portiere) {
		int tiro = rnd.nextInt(attaccante+portiere);
		
		if(tiro>portiere) {
			goal();
			return 1;
		}
		else
			return 0;
	}
	
	private void goal() {
		if(possesso)
			pnt[0]++;
		else
			pnt[1]++;
	}
	
	private void changePoss() {
		if(possesso)
			possesso = false;
		else
			possesso = true;
	}
		
	public int gioco(int palla, int nopalla) {
		return 1;
	}
		
	public Squadra getCasa() {
		return casa;
	}
	
	public Squadra getOspt() {
		return ospt;
	}
	
	public int[] getPunti() {
		return pnt;
	}
	
	public String toString() {
		if(t == 0)
			return casa.getName() + "-" + ospt.getName();
		else
			return casa.getName() + " " + pnt[0] + "-" + pnt[1] + " " + ospt.getName();
	}
}