import java.util.*;
import java.io.*;
public class Cow{
    private int[][]field;
    private String[][]graze;
    public int N,M,T,R1,C1,R2,C2;
    public Cow (String fileName){
	try {
	    File data = new File(fileName);
	    getInfo(data);
	} catch (Exception e) {
	    System.exit(0);
	}
    }
    private void getInfo (File data) throws FileNotFoundException {
	Scanner skan = new Scanner(data);
	N = Integer.parseInt(skan.next());
	M = Integer.parseInt(skan.next());
	T = Integer.parseInt(skan.next());
	field = new int[N][M];
	graze = new String[N][M];
	for (int i = 0; i < N * M; i ++){
	    field[i/M][i%M] = 0;
	    graze[i/M][i%M] = skan.next();
	}
	R1 = Integer.parseInt(skan.next());
	C1 = Integer.parseInt(skan.next());
	R2 = Integer.parseInt(skan.next());
	C2 = Integer.parseInt(skan.next());
	for(int d = 0; d < T; d ++){
	    for(int i = 0; i < N * M; i ++){
		int n = 0;
		if (i/M + 1 < N){
		n = n + field[i/M + 1][i%M];
		}
		if (i/M - 1 < 0){
		n = n + field[i/M - 1][i%M];
		}
		if (i%M + 1 < M){
		n = n + field[i/M + 1][i%M];
		}
		if (i%M - 1 < 0){
		n = n + field[i/M + 1][i%M];
		}
		if (graze[i/M][i%M].equals("*")){
		    n = 0;
		}
		field[i/M][i%M] = n;
	    }
	}
	
    }
    public int solve(){
	return field[R2][C2];
    }
    public static void main (String[] args) {
	Cow dank = new Cow("input1.txt");
	System.out.println(dank.N);
	System.out.println(dank.M);
	System.out.println(dank.T);
	//System.out.println(dank.solve());

    }
}
