package idbcBank;

public class Account {
    int accNo;
    int amount;
    String accountType;
    int intrestRate;
    int customerId;


    public Account(int accNo, int amount, String accountType, int intrestRate, int customerId) {
        this.accNo = accNo;
        this.amount = amount;
        this.accountType = accountType;
        this.intrestRate = intrestRate;
        this.customerId = customerId;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getIntrestRate() {
        return intrestRate;
    }

    public void setIntrestRate(int intrestRate) {
        this.intrestRate = intrestRate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accNo=" + accNo +
                ", amount=" + amount +
                ", accountType='" + accountType + '\'' +
                ", intrestRate=" + intrestRate +
                ", customerId=" + customerId +
                '}';
    }
}
