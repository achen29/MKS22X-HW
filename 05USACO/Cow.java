import java.util.*;
import java.io.*;
public class Cow{
    private String[][]graze;
    private int[][]field;
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

	for(int i = 0; i < N * M; i ++){
	    field[i/M][i%M] = 0;
	}
	field[R1][C1] = 1;
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
	System.out.println(1);
	System.out.println(dank.solve());

    }
}
