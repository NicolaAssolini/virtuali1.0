import java.io.IOException;
import java.util.Scanner;

public class MainTest {
	public static void main(String[] args) throws IOException {
		Squadra[] squadre = new Squadra[20];
		int s;
		
		squadre = creaSquadre();
		Calendario c = new Calendario(squadre);
		s = menù();
		System.out.println(s);
//		System.out.println(c);
//		System.out.println();
		System.out.println("si");
		System.in.read();
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.println("si");
/*		for(int j=1; j<20; j++) {
			for(int i=1; i<11; i++) {
				c.getMatch(j,i).giocoT();
				System.out.println(c.getMatch(j,i));
				c.getMatch(j,i).giocoT();
				System.out.println(c.getMatch(j,i) + "\n");
			}
			System.out.println("---------------------------------------------------------");
		}
*/
	}
	
	private static Squadra[] creaSquadre() {
		Squadra[] squadre = new Squadra[20]; 
		
		for (int i=0; i<20; i++) {
			if(i%3==0)
				squadre[i] = new Squadra(("S" + "_forte"),85,90,85);
			else if(i%3 == 1)
				squadre[i] = new Squadra(("S" + "_media"),80,80,80);
			else
				squadre[i] = new Squadra(("S" + "_scarsa"),70,75,70);
		}
		
		return squadre;
	}
	
	private static int menù() {
		Scanner scan = new Scanner(System.in);
		System.out.println("scelta");
		return scan.nextInt();
	}
}
