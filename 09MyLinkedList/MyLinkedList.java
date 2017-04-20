import java.util.*;

public class MyLinkedList{

    private class LNode{
	LNode next,prev;
	int value;
	public LNode(int value){
	    next = null;
	    prev = null;
	    this.value = value;
	}
	public String toString(){
	    return value+"";
	}
    }
    private class MyLinkedListIterator implements Iterator<Integer>{
	int index;
	MyLinkedList MLL;
	public MyLinkedListIterator(MyLinkedList list){
	    index = 0;
	    MLL = list;
	}
	public boolean hasNext(){
	    return MLL.size() < index;
	}
	public Integer next(){
	    if(!hasNext()){
		throw new NoSuchElementException();
	    }
	    index++;
	    return MLL.get(index - 1);
	}
	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
    LNode head,tail;
    int size;
    
    public MyLinkedList(){
	size = 0;
    }
    public int size(){
	return size;
    }   
    private LNode getNthNode(int n){
	if(n < 0 || n > size){
	    throw new IndexOutOfBoundsException();
	}
	LNode cur;
	if(n > size/2){
	    cur = tail;
	    for(int i = size; i - 1 > n; i--){
		cur = cur.prev;
	    }
	}
	else{
	    cur = head;
	    for(int i = 0; i < n; i++){
		cur = cur.next;
	    }
	}
	return cur;
    }

    private void addAfter(LNode location, LNode toBeAdded){
	if(location == tail){
	    tail.next = toBeAdded;
	    toBeAdded.prev = tail;
	    tail = toBeAdded;
	}
	else{
	    toBeAdded.prev = location;
	    toBeAdded.next = location.next;
	    location.next = toBeAdded;
	    toBeAdded.next.prev = toBeAdded;
	}
    }

    private void remove(LNode target){
	if(size == 1){
	    head = null;
	    tail = null;
	}
	else if(head == target){
	    head = head.next;
	    head.prev = null;
	}
	else if(tail == target){
	    tail = tail.prev;
	    tail.next = null;
	}
	else{
	    target.prev.next = target.next;
	    target.next.prev = target.prev;
	}
	size--;
    }

    public String toString(){
	String str = "[";
	
	if(size == 0){
	     return "[]";
	}
	else{
	    LNode cur = head;	    
	    for(int i = 0; i < size; i++){
		str += cur.toString();
		cur = cur.next;
	    }
	}
	return str + "]";
    }

    public boolean add(int value){
	add(size, value);
	return true;
    }

    public int get(int index){
	return getNthNode(index).value;
    }

    public int set(int index, int value){
	if(index >= size){
	    throw new IndexOutOfBoundsException();
	}
	int val = getNthNode(index).value;
        getNthNode(index).value = value;
	return val;
    }

    public int indexOf(int value){
	LNode cur = head;
	for (int i = 0; i < size; i++){
	    if (cur.value == value){
		return i;
	    }
	}
	return -1;
    }

    public int remove(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	int value = get(index);
	remove(getNthNode(index));
	return value;
    }

    public void add(int index,int value){
	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}

	LNode LN = new LNode(value);

	if(size == 0){
	    head = LN;
	    tail = LN;
	}
	else if(index == 0){
	    head.prev = LN;
	    LN.next = head;
	    head = LN;
	}
	else if(index == size){
	    addAfter(tail, LN);
	}
	else{
	    addAfter(getNthNode(index-1), LN);
	}
	size++;
    }
    
}
