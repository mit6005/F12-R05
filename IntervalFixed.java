import java.util.Date;

// via ocw, http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-170-laboratory-in-software-engineering-fall-2005/lecture-notes/lec8.pdf

public class IntervalFixed {
    private final Date start, stop;
    private final long duration;

    public IntervalFixed(Date start, Date stop) {
        this.start = new Date(start.getTime());
        this.stop = new Date(stop.getTime());
        duration = stop.getTime() - start.getTime();
    }
    public Date getStart() {
        return new Date(start.getTime());
    }
    public Date getStop() {
        return new Date(stop.getTime());
    }
    public long getDuration() {
        return duration;
    }
}
