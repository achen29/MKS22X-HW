import java.util.Stack;
public class StackCalc {
    
    public static double eval(String s){
	String[] str = s.split(" ");
	Stack<String> stryng = new Stack<String>();
	for(int i = 0; i< str.length; i ++){
	    if(isOp(str[i])){
		String n = stryng.pop();
		String m = stryng.pop();
		stryng.push(Oper(n,m,str[i]));
	    }
	    else{
		stryng.push(str[i]);
	    }
	}
	return Double.parseDouble(stryng.pop());
    }

    private static boolean isOp(String s) {
	return s.equals("%") ||
	       s.equals("/") ||
	       s.equals("*") ||
	       s.equals("-") ||
	       s.equals("+");
    }
    
    private static String Oper(String b, String a, String op) {
	Double thetaa = Double.parseDouble(a);
	Double thetab = Double.parseDouble(b);
	if (op.equals("%")) {
	    return "" + (thetaa%thetab);
	}else if (op.equals("/")){
	    return "" + (thetaa/thetab);
	}else if (op.equals("*")){
	    return "" + (thetaa*thetab);
	}else if (op.equals("-")){
	    return "" + (thetaa-thetab);
	}else{
	    return "" + (thetaa+thetab);
	}
    }
}
