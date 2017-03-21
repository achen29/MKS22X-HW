import java.util.*;
import java.io.*;
public class Silver{
    private int[][]field;
    private String[][]graze;
    public int N,M,T,R1,C1,R2,C2;
    public Silver (String fileName){
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
	    if(i%M ==0){
		String temp = skan.next();
		for (int n = 0; n < M; n ++){
		    graze[i/M][n] = temp.substring(n, n + 1);
		    //System.out.println(n);
		    //System.out.println(temp.substring(n,n+1));
		}
	    }
	}
	R1 = Integer.parseInt(skan.next());
	//System.out.println(R1);
	C1 = Integer.parseInt(skan.next());
	//System.out.println(C1);
	R2 = Integer.parseInt(skan.next());
	//System.out.println(R2);
	C2 = Integer.parseInt(skan.next());
	//System.out.println(C2);
	//System.out.println(T);
	field[R1-1][C1-1] = 1;
	for(int d = 0; d < T; d ++){
	    for(int i = 0; i < N * M; i ++){
		if ( (i/M + i%M)% 2 == (d + R1 - 1)%2){
		    if (i/M + 1 < N){
		        if(!graze[i/M + 1][i%M].equals("*")){
				field[i/M + 1][i%M] += field[i/M][i%M];
			    }
		    }
		    // System.out.println("1");
		    if (i/M - 1 >= 0){
			if(!graze[i/M - 1][i%M].equals("*")){
				field[i/M - 1][i%M] += field[i/M][i%M];
			    }
		    }
		    // System.out.println("2");
		    if (i%M + 1 < M){
		        if(!graze[i/M][i%M + 1].equals("*")){
				field[i/M][i%M + 1] += field[i/M][i%M];
			    }
		    }
		    // System.out.println("3");
		    if (i%M - 1 >= 0){
			if(!graze[i/M][i%M - 1].equals("*")){
				field[i/M][i%M - 1] += field[i/M][i%M];
			    }
		    }
		    //System.out.println("4");
		    field[i/M][i%M] = 0;
		}
	    }
	}
	
    }
    public String toString () {
	String str = "";
	for (int[] ary : field) {
	    for (int num : ary) {
		str += num + " ";
	    }
	    str += "\n";
	}
	return str;
    }
    public int solve(){
	return field[R2-1][C2-1];
    }
    public static void main (String[] args) {
	Silver dank = new Silver("input1.txt");
	System.out.println(dank.toString());
	System.out.println(dank.N);
	System.out.println(dank.M);
	System.out.println(dank.T);
	System.out.println(dank.solve());
	System.out.println("*".equals(dank.graze[0][0]));

    }
}
