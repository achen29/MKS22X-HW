import java.util.*;

public class MyHeap{
    private ArrayList<String> heap;
    private boolean Bool;
    public MyHeap(){
	heap = new ArrayList<String>();
	heap.add("");
	Bool= true;
    }
    public MyHeap(boolean a){
	heap = new ArrayList<String>();
	heap.add("");
        Bool = a;
    }
    public void add(String str){
	heap.add(str);
	pushUp();
    }
    public String remove(){
	String str = peek();
	heap.set(1, heap.remove(heap.size() - 1));
	pushDown();
	return str;
    }
    public String peek(){
	return heap.get(1);
    }
    private void pushUp(){
	int i = heap.size()-1;
	String str = heap.get(i);
	if(Bool){
	    while(i > 1 && str.compareTo(heap.get(i/2))> 0){
		heap.set(i, heap.get(i/2));
		heap.set(i/2, str);
		i = i / 2;
	    }
	}
	else{
	    while(i > 1 && str.compareTo(heap.get(i/2))< 0){
	        heap.set(i, heap.get(i/2));
		heap.set(i/2, str);
		i = i / 2;
	    }
	}
    }
    private void pushDown(){
	int i = 1;
	String str = heap.get(i);
	if(Bool){
	    while(i * 2 <= heap.size() - 1 && str.compareTo(heap.get(i * 2)) <=0
		  && str.compareTo(heap.get(i * 2 + 1)) <=0){
		if(heap.get(i*2).compareTo(heap.get(i*2 + 1)) > 0){
		    heap.set(i,heap.get(i*2 + 1));
		    heap.set(i * 2 + 1, str);
		    i = i * 2 +1;
		}
		else{
		    heap.set(i,heap.get(i * 2));
		    heap.set(i *2, str);
		    i = i * 2;
		}
	    }
	}
	else{
	    while(i * 2 <= heap.size() - 1 && str.compareTo(heap.get(i * 2)) >=0
		  && str.compareTo(heap.get(i * 2 + 1)) >=0){
		if(heap.get(i*2).compareTo(heap.get(i*2 + 1)) < 0){
		    heap.set(i,heap.get(i*2 + 1));
		    heap.set(i * 2 + 1, str);
		    i = i * 2 +1;
		}
		else{
		    heap.set(i,heap.get(i * 2));
		    heap.set(i *2, str);
		    i = i * 2;
		}
	    }
	}
    }
    public String toString(){
	String temp = "";

	for(String str : heap){
	    temp += str + " ";
	}

	return temp;
    }
}
