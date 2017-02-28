public class KnightBoard{
    private int[][]board;
    private int row;
    private int col;
    private String str ="";
    public KnightBoard(int R, int C){
	board = new int[R][C];
	row = R;
	col = C;
	for(int i = 0; i < R * C; i ++){
	    board[i%R][i/R] = 0;
	}
    }
    public void solve(){
	solveH(0,0,1);
    }
    public boolean solveH(int r, int c, int level){
	if(level > row*col){
	    return true;
	}
	if( r >= row ||
	    r < 0 ||
	    c >= col ||
	    c < 0){
	    return false;
	}
	if(board[r][c] != 0){
	    return false;
	}
	board[r][c] = level;
	if (solveH(r + 2,c + 1,level + 1)||
	    solveH(r + 2,c - 1,level + 1)||
	    solveH(r - 2,c + 1,level + 1)||
	    solveH(r - 2,c - 1,level + 1)||
	    solveH(r + 1,c + 2,level + 1)||
	    solveH(r + 1,c - 2,level + 1)||
	    solveH(r - 1,c + 2,level + 1)||
	    solveH(r - 1,c - 2,level + 1)){
	    return true;
	}
	board[r][c] = 0;
	return false;
    }
    public String toString(){
	for(int i = 0; i < row * col; i ++){
	    if(i % row == 0){
		str = str + "\n";
	    }
	    if(board[i%row][i/row]/10 == 0){
		str = str + " ";
	    }
	    str = str + board[i%row][i/row];
	}
	return str;
    }
}
