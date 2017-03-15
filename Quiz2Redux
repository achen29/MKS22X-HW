import java.util.ArrayList;
public class Quiz2Redux{
    public ArrayList<String> combo;
    public static ArrayList<String> combinations (String S){
	ArrayList<String>words = new ArrayList<String>();
	combinationH(S,words);
	return words;
    }
    public static void combinationH(String s, ArrayList<String> words){
	words.add("");
	for(int i = 0; i < s.length(); i ++){
	    int k = words.size();
	    for(int n = 0; n < k; n ++){
		words.add(words.get(n)+ s.charAt(i));
	    }
	}
    } 
    public static void main(String[] args){
        System.out.println(combinations("sadf"));
        System.out.println(combinations("aasdf"));
        System.out.println(combinations("lsad"));
    }

}
