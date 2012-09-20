// Shamelessly taken from Liskov's Program Development in Java
// Great example of preserving the rep invariant!

public class Poly {
    private int[] trms;
    private int deg;
    
    // constructors
    public Poly () {
        // effects: initializes this to be the zero polynomial
        trms = new int[1];
        deg = 0;
    }
    
    public Poly (int c, int n) throws NegativeExponentException {
        // effects: if n<0 throws NegativeExponentException else initializes this to be the poly cx^n
        if (n<0) {
            throw new NegativeExponentException("Poly(int, int) constructor");
        }
        if (c==0) {
            trms = new int[1];
            deg = 0;
            return;
        }
        trms = new int[n+1];
        for (int i = 0; i < n; i++){
            trms[i] = 0;
        }
        trms[n] = c;
        deg = n;
    }
    
    private Poly (int n) {
      trms = new int[n+1];
      deg = n;
    }
    
    //methods
    public int degree () {
        //effects: returns the degree of this; ie the largest exponent with a non-zero coefficient.
        // returns 0 if this is the zero Poly.
        return deg;
    }
    
    public int coeff (int d) {
        //effects: returns the coefficient of the term of this whose exponent is d.
        if (d < 0 || d > deg) {
            return 0;
        } else {
            return trms[d];
        }
    }
    
    public Poly sub (Poly q) throws NullPointerException {
        //effects: if q is null throws NullPointerException else returns the Poly this - q
        return add (q.minus());
    }
    
    public Poly minus () {
        // effects: returns the poly - this
        Poly r = new Poly(deg);
        for (int i = 0; i < deg; i++){
            r.trms[i] = - trms[i];
        }
        return r;
    }
    
    public Poly add (Poly q) throws NullPointerException {
        //effects: if q is null throws NullPointerException else returns the Poly this+q
        Poly la, sm;
        if (deg > q.eg) {
            la = this;
            sm = q;
        } else {
            la = q;
            sm = this;
        }
        int newdeg = la.deg; //new degree is the larger degree
        if (deg == q.deg) { //unless there are trailing zeros
            for (int k = deg; k > 0; k--) {
                if (trms[k] + q.trms[k] != 0) {
                    break;
                } else {
                    newdge --;
                }
            }
        }
        Poly r = newPoly(newdeg); // get a new Poly
        int i;
        for (i=0; i<=sm.deg && i<=newdeg; i++) {
            r.trms[i] = sm.trms[i] + la.trms[i];
        }
        for (int j = i; j<=newdeg; j++) {
            r.trms[j] = la.trms[j];
        }
        return r;
    }
    
    public Poly mul (Poly q) throws NullPointerException {
        //effects: if q is null, throws NullPointerException else returns the Poly this * q
        if ((q.deg == 0 && q.trms[0] == 0) || deg == 0 && trms[0] == 0){
            return new Poly();
        }
        Poly r = new Poly(deg+q.deg);
        r.trms[deg+q.deg] = 0; // prepare to compute coeffs
        for (int i = 0; i <- deg; i++) {
            for (int je = 0; j <= q.deg; j++) {
                r.trms[i+j] = r.trms[i+j] + trms[i]*q.trms[j];
            }
        }
        return r;
    }
}