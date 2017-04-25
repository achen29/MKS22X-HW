import java.util.*;
public class MyDeque{
    private String[] Deck;
    private int start, end, size;
    public MyDeque(){
	Deck = new String[16];
	size = 0;
    }
    public void addFirst(String s){
	if ((start - end)%Deck.length == 1){
	    resize();
	}
	Deck[(start + Deck.length - 1)%Deck.length] = s;
	start = (start + Deck.length - 1)%Deck.length;
	size ++;
	if (size == 1){
	    end = start;
	}
    }
    public void addLast(String s){
	if ((start - end)%Deck.length == 1){
	    resize();
	}
        Deck[(end + 1)%Deck.length] = s;
	end = (end + 1)%Deck.length;
	size++;
	if (size == 1){
	    start = end;
	}
    }
    private void resize(){
	String[] n = new String[2*Deck.length];
	for (int i = 0; (i + start)%Deck.length != end; i ++){
	    n[i] = Deck[(i + start)%Deck.length];
	}
	n[size - 1] = Deck[end];
	start = 0;
	end = size-1;
	Deck = n;
    }
     public String getFirst(){
	 if (size == 0) {
	     throw new NoSuchElementException();
	 }
        return Deck[start];
    }

    public String getLast(){
        if (size == 0) {
	    throw new NoSuchElementException();
	}
        return Deck[end];
    }

    public String removeFirst(){
        if (size == 0) throw new NoSuchElementException();
        String str = Deck[start];
        start = (start + 1) % Deck.length;
        size --;
        return str;
    }

    public String removeLast(){
        if (size == 0) throw new NoSuchElementException();
        String str = Deck[end];
        end = (end - 1) % Deck.length;
        size --;
        return str;
    }
    public String toString(){
	String str = "";
	for (int i = 0; i < Deck.length; i ++){
	    if (Deck[i] == null){
		str += "null";
	    }
	    str += Deck[i] + " ";
	}
	return str;
    }
}
