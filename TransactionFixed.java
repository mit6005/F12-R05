//Taken from lecture notes.
public class Transaction {
	
	private final int amount;
	private final Calendar date;
	
	public Transaction(int amount, Calendar date) {
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
	public static Transaction makeNextPayment(Transaction t) {
	    Calendar d = t.getDate(); 
	    d.add(Calendar.MONTH, 1);
	    return new Transaction (t.getAmount(), d);
	}
	/** @return a list of 12 monthly payments of identical amounts */
	public static List<Transaction> makeYearOfPayments (int amount) {
	    List<Transaction> list = new ArrayList<Transaction> (); 
	    Calendar date = new GregorianCalendar (); 
	    for (int i=0; i < 12; i++) {
	        list.add (new Transaction (amount, date));
	        date.add (Calendar.MONTH, 1);
	    } 
	    return list;
	}
}