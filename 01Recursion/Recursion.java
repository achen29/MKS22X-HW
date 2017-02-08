public class Recursion{
    public static String name(){
	return "Alvin Chen";
    }
    public static double sqrt(double n){
	if(n < 0){
	    return IllegalArgumentException();
	}
	return sqrthelp(n,1);
    }
    public static boolean closeEnough(double m, double n){
	if (m == 0 && n ==0){
	    return true;
	}
	if (m == 0 || n == 0){
	    return false;
	}
	return ((m - n)/m <= 0.00001 && (m-n)/m >= -0.00001);
    }
    public static double sqrthelp(double n, double guess){
	double newguess = (n/guess + guess)/2;
	if (closeEnough(newguess, guess)){
	    return newguess;
	}
	return sqrthelp(n,newguess);
    }
}
