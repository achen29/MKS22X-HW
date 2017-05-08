public class ExpressionTree{
    
    private char op;
    private double value;
    private ExpressionTree left,right;

    public ExpressionTree(double val){
	value = val;
	op = '~';
    }
    
    public ExpressionTree(char oper, ExpressionTree left,ExpressionTree right){
	op = oper;
	this.left = left;
	this.right = right;
    }
    
    private double getValue(){
	return value;
    }
    private char getOp(){
	return op;
    }
    private ExpressionTree getLeft(){
	return left;
    }
    private ExpressionTree getRight(){
	return right;
    }

    private boolean isOp(){
	return right != null && left != null;
    }
    private boolean isValue(){
	return !isOp();
    }
    public String toString(){
	if (isValue()){
	    return getValue() + "";
	}
        else{
	    return "(" + getLeft() + " " + getOp() + " " + getRight() + ")";
	}
    }
    public String toStringPostfix(){
	if (isValue()){
	    return getValue() + "";
	}
        return getLeft().toStringPostfix() + " " + getRight().toStringPostfix() + " " + getOp();
    }
    public String toStringPrefix(){
	if (isValue()){
	    return getValue() + "";
	}
        return getOp() + " " + getLeft().toStringPrefix() + " " + getRight().toStringPrefix();
    }
    public double evaluate(){
	if(isValue()){
	    return getValue();
	}
	if (getOp() == '%'){
	    return getLeft().evaluate() % getRight().evaluate();
	}
        if (getOp() == '/'){
	    return getLeft().evaluate() / getRight().evaluate();
	}
        if (getOp() == '*'){
	    return getLeft().evaluate() * getRight().evaluate();
	}
        if (getOp() == '-'){
	    return getLeft().evaluate() - getRight().evaluate();
	}
        return getLeft().evaluate() + getRight().evaluate();
	
    }

}
