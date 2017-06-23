public class USACO{

	public USACO(){}

	public int bronze(String fileName){
		Bronze x = new Bronze(fileName);
		return x.solve()*72*72;
	}

	public int silver(String fileName){
		Silver x = new Silver(fileName);
		return x.solve();
	}

}
