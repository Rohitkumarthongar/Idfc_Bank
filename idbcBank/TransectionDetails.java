package idbcBank;

public class TransectionDetails {
    int transactionid;
    String transactiontype;
    int balance;
    int accno;

    public TransectionDetails(int transactionid, String transactiontype, int balance, int accno) {
        this.transactionid = transactionid;
        this.transactiontype = transactiontype;
        this.balance = balance;
        this.accno = accno;
    }

    @Override
    public String toString() {
        return "TransectionDetails{" +
                "transactionid=" + transactionid +
                ", transactiontype='" + transactiontype + '\'' +
                ", balance=" + balance +
                ", accno=" + accno +
                '}';
    }
}
