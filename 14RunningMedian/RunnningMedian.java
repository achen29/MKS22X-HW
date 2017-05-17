public class RunningMedian{
    private MyHeap max,min;
    private int maxs,mins;

    public RunningMedian(){
	max = new MyHeap();
	min = new MyHeap(false);
	max, min = 0;
    }

    public double getMedian(){
	if(mins == max){
	    if(mins == 0){
		return 0;
	    }
	    return (max.peak() + min.peak)/2;
	}
	if(maxs > mins){
	    return max.peak();
	}
	return min.peak();
    }
    
    public void add(int n) {
	if (n > getMedian()){
	    min.add(n);
	    mins ++;
	}
	else{
	    if (n < getMedian()){
		max.add(n);
		maxs ++;
	    }
	    else{
		if(mins > max){
		    max.add(n);
		    maxs ++
		}
		else{
		    min.add(n);
		    mins++;
		}
	    }
	}
	if(math.abs(min - max) > 1){
	    if(mins > maxs){
		max.add(min.remove());
		max ++;
		min--;
	    }
	    else{
		min.add(max.remove());
		max--;
		min++;
	    }
	}
    }
}
