// via ocw
// has a rep exposure

public class Interval {
    private Þnal Date start, stop;
    private Þnal long duration;
    
    public Interval(Date start, Date stop) {
    	
   /*Bonus question.Ignore.
    * if(start.compareTo(end)>0){
    	throw new IllegalArgumentException();
    }*/
        this.start = start;
        this.stop = stop;
        duration = stop.getTime()-start.getTime();
    }
    public Date getStart() { 
        return start; 
    }
    public Date getStop() { 
        return stop; 
    }
    public long getDuration() { 
        return duration; 
    }
}