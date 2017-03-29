Public class MyLinkedList{
    private int size;
    private Node start;
    public class LNode{
	private int val;
	private Node next;
	public LNode(int value){
	    val = value;
	}
	public Lnode(int value, Node nxt){
	    next = nxt;
	}
    }
    public MyLInkedList(){
	size = 0;
	start = null;
    }
    public void add(int a){
	Node m = start;
	for (int i = size; i > 0; i --){
	    m = m.next;
	}
	m.next = a;
	a.next = null;
	size ++;
    }
    public int size(){
	return size;
    }
}
