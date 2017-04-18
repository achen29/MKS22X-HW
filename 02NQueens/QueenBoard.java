import java.lang.Math;
public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    public QueenBoard(int size){
	board = new int[size][size];
	solve();
    }
    private void addQueen(int x,int y){
	board[x][y] = -2;
	for (int i = 0; i < board[0].length * board[0].length; i ++){
	    if(Math.abs(x - i%board[0].length) ==
	       Math.abs(y - i/board[0].length)||
	       x == i%board[0].length ||
	       y == i/board[0].length){
		board[i%board[0].length][i/board[0].length] ++;
	    }
	}
    }
    private int removeQueen(int x,int y){
	board[x][y] = 1;
	for (int i = 0; i < board[0].length * board[0].length; i ++){
	    if(Math.abs(x - i%board[0].length) ==
	       Math.abs(y - i/board[0].length)||
	       x == i%board[0].length ||
	       y == i/board[0].length){
		board[i%board[0].length][i/board[0].length] --;
	    }
	}
	for(int i = x + 1; i < board[0].length; i ++){
	    if(board[i][y] + i == 0){
		return i;
	    }
	}
	return - 1;
    }
    public void solve(){
	    solveH(0);
    }
    private boolean solveH(int y){
	if(y >= board[0].length){
	    return true;
	}
	for (int x = 0; x < board[0].length; x ++){
	    if(board[x][y] < 0){
		int z = removeQueen(x,y);
		if(z >= 0){
		    addQueen(z,y);
		    return solveH(y+1);
		}
	    }
	    else if (board[x][y] == 0){
		addQueen(x,y);
		return solveH(y+1);
	    }
	}
	if (y == 0){
	    return false;
	}
	return solveH(y-1);	
    }
    public void countSolutions(){
	solutionCount = 0;
	boolean more = solveH(board[0].length);
	while(more){
	    solutionCount ++;
	    more = solveH(board[0].length-1);
	}
    }
    public int getSolutionCount(){
	return solutionCount;
    }
    public String toString(){
	String b = "";
	for (int i = 0; i < board[0].length * board[0].length; i ++){
	    if(i%board[0].length == 0){
		b += "\n";
	    }
	    if(board[i%board[0].length][i/board[0].length] == -1){
		b += "Q ";
	    }
	    else{
		b += "_ ";
	    }
	}
	return b;
    }
    public static void main(String[] args){
		QueenBoard n = new QueenBoard(7);
		System.out.println(n);
		n.countSolutions();
		System.out.println(n.getSolutionCount());
	}
}
