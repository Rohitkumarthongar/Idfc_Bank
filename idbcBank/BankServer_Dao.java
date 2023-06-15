package idbcBank;

import java.sql.*;

public class BankServer_Dao {

    Connection con;
public BankServer_Dao() {

    String url = "jdbc:mysql://localhost:3306/IDBC_BANK_SERVER ";
    String user = "root";
    String password = "ROot";

        try {
            con = DriverManager.getConnection(url,user,password);
            System.out.println("System Connected To Database");
        } catch (SQLException e) {
            System.out.println("Not Connected ");
            e.printStackTrace();
        }
    }

    public void insertCustomer(CustomerDetails customerDetails)
    {
        System.out.println("Apply Neccesory Credentials");
        try{
            PreparedStatement p1 =  con.prepareStatement("insert into customerDetails values (?, ?, ?, ?,?,?,?,?)");

            p1.setInt(1,customerDetails.cutomerId);
            p1.setString(2, customerDetails.firstName);
            p1.setString(3, customerDetails.lastName);
            p1.setInt(4,customerDetails.age);
            p1.setString(5,customerDetails.gender);
            p1.setString(6,customerDetails.phno);
            p1.setString(7,customerDetails.city);
            p1.setString(8,customerDetails.street);

            int rowsAffected = p1.executeUpdate();

            if(rowsAffected >= 0)
                System.out.println("Customer Details added successfully.");
            else
                System.out.println("Failed To Add Customer Details");

        } catch (SQLException e) {
            System.out.println("SQLException " + e);
            e.printStackTrace();
        }
    }

    public void createAccount(Account account,TransectionDetails trans) {
        System.out.println("Creating Account ");
        try {
            PreparedStatement p2=con.prepareStatement("insert into Account values(?,?,?,?,?)");

            p2.setInt(1,account.accNo);
            p2.setInt(2,account.customerId);
            p2.setInt(3,account.amount);
            p2.setString(4,account.accountType);
            p2.setInt(5,account.intrestRate);
            p2.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        PreparedStatement p7 = null;
        try {

//            check
            p7 = con.prepareStatement("insert into TransactionDetails values(?,?,?,?)");
            p7.setInt(1,trans.transactionid);
            p7.setString(2,trans.transactiontype);
            p7.setInt(3,trans.balance);
            p7.setInt(4,trans.accno);

            p7.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deposit(TransectionDetails trans, int accno) {
        try {
            PreparedStatement pd = con.prepareStatement("update Account join TransactionDetails on Account.accNo=transactions.accNo set Account.amount =(Account.amount)+(TransactionDetails.balance) where Account.accNo=?");
            PreparedStatement p3 = con.prepareStatement("insert into TransactionDetails values (?,?,?,?)");


            pd.setInt(1, trans.accno);

            p3.setInt(1, trans.transactionid);
            p3.setString(2, trans.transactiontype);
            p3.setInt(3, trans.balance);
            p3.setInt(4, trans.accno);

            pd.setInt(1, trans.accno);
            int rowsAffected = p3.executeUpdate();
            pd.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Deposit successful.");

            } else
                System.out.println("Not able to deposit.");


        } catch (SQLException e) {
            System.out.println("SQLException " + e);

        }
    }
        public void withdraw(TransectionDetails trans, int accno){

        try {
            PreparedStatement pw = con.prepareStatement("update Account join TransectionDetails on Account.accNo=TransectionDetails.accNo set Account.amount =(Account.amount)-(TransectionDetails.balance) where Account.accNo=?");
            PreparedStatement p3 = con.prepareStatement("insert into TransectionDetails values (?,?,?,?)");
            PreparedStatement p4= con.prepareStatement("select amount from Account where accNo=?");
            int amount22=0;
            p4.setInt(1,accno);

            ResultSet tt= p4.executeQuery();
            while(tt.next()){
                amount22=tt.getInt(1);
            }
            if(amount22>trans.balance){


                p3.setInt(1,trans.transactionid);
                p3.setString(2,trans.transactiontype);
                p3.setInt(3,trans.balance);
                p3.setInt(4,trans.accno);
                pw.setInt(1,accno);
                pw.executeUpdate();
                p3.executeUpdate();
            }else{
                System.out.println("not possible");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        void displaytrans(int accno){
        try {
            PreparedStatement PT=con.prepareStatement("select*from TransectionDetails where accNo=?" );


            PT.setInt(1,accno);
            PT.executeQuery();
            ResultSet TTC= PT.executeQuery();
            while(TTC.next()){
                System.out.println(TTC.getInt(1)+"\t"+TTC.getString(2)+"\t"+ TTC.getInt(3)+"\t"+ TTC.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
