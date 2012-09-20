import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

//Taken from lecture notes.
public class TransactionFixed {

	private final int amount;
	private final Calendar date;

	public TransactionFixed(int amount, Calendar date) {
	        this.amount = amount;
	        this.date = (Calendar)date.clone();
	    }
	public int getAmount() {
	        return amount;
	    }
	 public Calendar getDate() {
	        return (Calendar)date.clone();
	    }

	/** @return a transaction of same amount as t, one month later */
	public static TransactionFixed makeNextPayment(TransactionFixed t) {
	    Calendar d = t.getDate();
	    d.add(Calendar.MONTH, 1);
	    return new TransactionFixed (t.getAmount(), d);
	}
	/** @return a list of 12 monthly payments of identical amounts */
	public static List<TransactionFixed> makeYearOfPayments (int amount) {
	    List<TransactionFixed> list = new ArrayList<TransactionFixed> ();
	    Calendar date = new GregorianCalendar ();
	    for (int i=0; i < 12; i++) {
	        list.add (new TransactionFixed (amount, date));
	        date.add (Calendar.MONTH, 1);
	    }
	    return list;
	}
}