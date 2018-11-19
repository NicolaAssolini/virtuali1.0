
public class Squadra {
	private String name = new String();
	private int att;
	private int cen;
	private int dif;
	private int punti;
	
	public Squadra(String nome, int a, int c, int d) {
		this.name = nome;
		this.att = a;
		this.cen = c;
		this.dif = d;
		this.punti = 0; 
	}
	
	public void aggPunti(int i) {
		if (i == 0)
			punti++;
		else if(i == 1)
			punti += 3;
	}

	public String getName() {
		return this.name;
	}
	
	public int getPoint() {
		return this.punti;
	}
		
	public int att() {
		return att;
	}
	
	public int cen() {
		return cen;
	}
	
	public int dif() {
		return dif;
	}
	
}
