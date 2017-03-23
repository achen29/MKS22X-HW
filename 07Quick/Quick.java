import java.util.*;

public class Quick{

    public static int part(int[] data, int start, int end){
	Random rundom = new Random();
	int n = (rundom.nextInt(end - start) + rundom.nextInt(end - start) + rundom.nextInt(end - start) + 3 * start) / 3;
	System.out.println(n);
	int[] copy = data.clone();
	int m = copy[n];
	System.out.println(m);
	int left = start;
	int right = end;
	for (int i = 0; i <= end - start; i ++){
	    if (i + start != n){
		if (copy[i + start] > m){
		    data[right] = copy[i + start];
		    right -= 1;
		    System.out.println("R" + right);
		}
		if (copy[i + start] <= m){
		    data[left] = copy[i + start];
		    left += 1;
		    System.out.println("L" + left);
		}
	    }
	}
	data[right] = m;
	System.out.println(right);
	System.out.println(left);
	System.out.println(toString(data));
	return right;
    }

    public static int quickselect(int[] data, int k){
	return quickselectH(data, k, 0, data.length-1);
    }

    private static int quickselectH(int[] data, int k, int start, int end){
	Random Rundom = new Random();
	int n = rundom.nextint(end - start);
	/*
while i<= gt
if a[i] == v
i++
else if a[i] < v;
swap(a,i,lt)
i++
lt++
else 
swap(a,i,gt)
gt--
	 */
	    
    }

    public static void quicksort(int[] data){
	quicksortH(data,0,data.length - 1);
    }

    private static void quicksortH(int[] data, int start, int end){
	if(start < end){
	    int p = part(data,start,end);
	    quicksortH(data,start,p -1);
	    quicksortH(data,p+1,end);
	}
    }

    public static void main(String[] args){
	int[] samp = {10,9,8,5,8,10,2,4,6,12,52,33,2,54,52};
	//part(samp, 0, 5);
	quicksort(samp);
	//System.out.println(quickselect(samp,3));
    }

    public static String toString(int[] data){
	String str = "{ ";
	for(int i = 0; i < data.length; i ++){
	    str += data[i] + " ";
	}
	return str + "}";
    }
}
