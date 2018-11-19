
public class Calendario {
	private Partita[][] calendario = new Partita[38][10];
	
    public Calendario(Squadra[] squadre){
        int numero_squadre = squadre.length;
        int giornate = numero_squadre - 1;
        Squadra[] casa = new Squadra[numero_squadre /2];
        Squadra[] trasferta = new Squadra[numero_squadre /2];
     
        for (int i=0; i<numero_squadre/2; i++) {
            casa [i] = squadre[i]; 
            trasferta[i] = squadre[numero_squadre - 1 - i]; 
        }
        for (int i=0; i<giornate; i++) {
            if (i % 2 == 0) {
                for (int j=0; j<numero_squadre/2; j++)
                	calendario[i][j] = new Partita(casa[j], trasferta[j]); 
            }
            else {
                for (int j=0; j<numero_squadre/2; j++)
                	calendario[i][j] = new Partita(trasferta[j], casa[j]);
            }
            Squadra pivot = casa [0];    		   
            Squadra riporto = trasferta[trasferta.length - 1];
    		trasferta = shiftRight(trasferta, casa[1]);
            casa = shiftLeft(casa, riporto);
            casa[0] = pivot ;
        }
        for (int i=0; i<giornate; i++) {
        	for (int j = 0; j < numero_squadre /2 ; j++)
            	calendario[i+giornate][j] = new Partita(calendario[i][j].getOspt(), calendario[i][j].getCasa());
        }
        
    }
    
    private Squadra[] shiftLeft(Squadra[] data, Squadra add) {
    	Squadra[] temp = new Squadra[data.length];
		for (int i = 0; i < data.length-1; i++) {
			temp[i] = data[i + 1];
		}
		temp[data.length - 1] = add;
		return temp;
	}

	private Squadra[] shiftRight(Squadra[] data, Squadra add) {
		Squadra[] temp = new Squadra[data.length];
		for (int i = 1; i < data.length; i++) {
			temp[i] = data[i - 1];
		}
		temp[0] = add;
		return temp;
	}
	
	public Partita getMatch(int i, int j) {
		return calendario[i-1][j-1];
	}

	public String toString() {
		String r = "";
        for (int i=0; i<calendario.length; i++) {
        	r += "\n"+(i+1)+"^ Giornata\n";
        	for (int j=0; j<calendario[0].length; j++)
        		r += j+1 + " " + calendario[i][j] + "\n";
        }
        return r;
	}
}
	
