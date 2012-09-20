// Shamelessly taken from Liskov's Program Development in Java

public class IntSet {
    // overview: IntSets are unbounded, mutable sets of integers.
    private Vector els; // the rep
    
    // constructors
    public IntSet () {
        // effects: initializes this to be empty
        els = new Vector(); 
    }
    
    // methods 
    public void insert (int x) {
        // modifies this
        // effects: adds x to the elements of this
        Integer y = new Integer(x);
        if (getIndex(y) < 0) {
            els.add(y);
        }
    }
    
    public void remove (int x) {
        //modifies this
        // effects: removes x from this.
        int i = getIndex(new Integer(x));
        if (i < 0) return;
        els.set(i, els.lastElement());
        els.remove(els.size()-1);
    }
    
    public boolean isIn (int x) {
        // effects: returns true if x is in this else returns false
        return getIndex(new Integer(x)) >= 0;
    }
    
    private int getIndex (Integer x) {
        // effects: if x is in this returns index where x appears else returns -1
        for (int i = 0; i < els.size(); i++) {
            if (x.equals(els.get(i))) return i;
        }
        return -1;
    }
    
    public int size () {
        // effects: returns the cardinality of this
        return els.size();
    }
    
    public Vector allEls() {
        // effects: returns a vectory containing the elements of this, each exactly once, in arbitrary order
        return els;
    }
    
    public int choose () throws EmptyException {
        // effects: if this is empty throws EmptyException else returns an arbitrary element of this
        if (els.size() == 0) throw new EmptyException("IntSet.choose");
        return els.lastElement();
    }
}