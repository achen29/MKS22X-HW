public class Merge{
    public static void mergesort(int[]ary){
	int[] mn = mergeH(ary, 0, ary.length - 1);
	for (int i = 0; i < ary.length; i ++){
	    ary[i] = mn[i];
	}
    }
    private static int[] mergeH(int[] ary, int start, int end){
	if (start == end){
	    int[] m = {ary[start]};
	    return m;
	}
	int[] m = mergeH(ary, start, (start + end) / 2);
        int[] n = mergeH(ary, (start + end) / 2 + 1, end);
        int[] mn = sort(m, n);
        return mn;
	//crdt w tiff chen during class lab
    }
    private static int[] sort(int[] m, int [] n){
	int m1 = 0;
	int n1 = 0;
	int mn1 = 0;
	int[] mn = new int[m.length + n.length];
	while (m1 < m.length && n1 < n.length){
	    if (m[m1] > n[n1]){
		mn[mn1] = n[n1];
		n1++;
	    }
	    else{
		mn[mn1] = m[m1];
		m1++;
	    }
	    mn1++;
	}
	if(m1 == m.length){
	    for(int i = n1; i < n.length; i ++){
		mn[mn1] = n[i];
		mn1 ++;
	    }
	}
	else{
	    for(int i = m1; i < m.length; i ++){
		mn[mn1] = m[i];
		mn1 ++;
	    }
	}
	return mn;
    }
    private static String toString(int[] ary){
        String str = "{";
        for (int i = 0; i < ary.length; i ++){
	    if(i != 0){
		str += ",";
	    }
	    str += ary[i];
        }
        return str + "}";
    }
    public static void main(String[] args){
        int[] one = {1,3,4,5,6,7,7,7,8,8,8,8,8,8,8,8,9};
	int[] two = {2,4,5};
	
        System.out.println(toString(sort(one, two)));
	int[] data = {1,6,3,5,632,3,5,69,7,0,8,78,4,5,6,5,4,77,9,8,7,8,65,5,6,4,53,6,5,8,7,60,9,8,7,0,9,8,7,9,6,78,3};
        mergesort(data);
        System.out.println(toString(data));
    }
}
