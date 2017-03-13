import java.util.*;
import java.io.*;

public class Lake {

    public int R, C, E, N;
    private int[][] lake;
    public String[] orders;

    public Lake (String fileName) {
	try {
	    File data = new File(fileName);
	    getInfo(data);
	} catch (Exception e) {
	    //System.out.println("dank");
	    System.exit(0);
	}
	
    }


    private void getInfo (File data) throws FileNotFoundException {
	
	Scanner skan = new Scanner(data);
	R = Integer.parseInt(skan.next());
	C = Integer.parseInt(skan.next());
	E = Integer.parseInt(skan.next());
	N = Integer.parseInt(skan.next());
	lake = new int[R][C];
	for(int i = 0; i < R; i++){
	     for (int count = 0; count < C; count++) {
		lake[i][count] = Integer.parseInt(skan.next());
	    }
	}
	for(int i = 0; i < N; i ++){
	    stomp(Integer.parseInt(skan.next()),Integer.parseInt(skan.next()),Integer.parseInt(skan.next()));
	}

    }
    private void stomp(int r, int c, int p){
	int row = r - 1;
	int r1 = 0;
	if (R - row < 3){
	    r1 = R - row;
	}
	else{
	    r1 = 3;
	}
	int col = c - 1;
	int c1 = 0;
	if (C - col < 3){
	    c1 = C - col;
	}
	else{
	    c1 = 3;
	}
	int highest = 0;
	for(int i = 0; i < (r1)*(c1); i ++){
	    if (lake[i/(c1) + row][i%(c1) + col] > highest){
		highest = lake[i/(c1) + row][i%(c1) + col];
	    }
	}
	highest = highest - p;
	for(int i = 0; i < (r1)*(c1); i ++){
	    if (lake[i/(c1) + row][i%(c1) + col] > highest){
		lake[i/(c1) + row][i%(c1) + col] = highest;
	    }
	}
	
    }
    private int solve(){
	int sol = 0;
	for(int i = 0; i < R * C; i++){
	    if (lake[i/C][i%C] < E){
		sol = sol + E - lake [i/C][i%C];
	    }
	}
	return sol;
    }

    public String toString () {
	String str = "";
	for (int[] ary : lake) {
	    for (int num : ary) {
		str += num + " ";
	    }
	    str += "\n";
	}
	return str;
    }

    public static void main (String[] args) {
	
	Lake dank = new Lake("input.txt");
	System.out.println(dank.solve()* 72 * 72);

    }
}
