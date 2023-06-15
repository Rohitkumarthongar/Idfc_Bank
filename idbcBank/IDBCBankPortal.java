package idbcBank;

import java.util.Random;
import java.util.Scanner;

public class IDBCBankPortal {
    public static void main(String[] args){
        BankServer_Dao dao=new BankServer_Dao();

        Scanner scan=new Scanner(System.in);
        Random Rc=new Random();

        System.out.println("Enter 1 To Create a Bank Account");
        System.out.println("Enter 2 for Transaction");
        int choice= scan.nextInt();

        switch (choice)
        {
            case 1:
                System.out.println("Enter your Id(CustomerId(Digits)) : ");
                int cutomerId = scan.nextInt();

                System.out.println("Enter your Full Name : ");
                String firstname = scan.next();

                System.out.println("Enter your lastname : ");
                String lastname = scan.next();

                System.out.println("Enter your age: ");
                int age = scan.nextInt();

                System.out.println("gender");
                String gender=scan.next();

                System.out.println("phonenumber");
                String phno= scan.next();

                System.out.println("city");
                String city =scan.next();

                System.out.println("street");
                String street =scan.next();

                CustomerDetails customer = new CustomerDetails(cutomerId, firstname, lastname, age,gender,phno,city,street);
                dao.insertCustomer(customer);


                System.out.println("account no");
                int accno= scan.nextInt();

                System.out.println("Enter amount");
                int amount = scan.nextInt();
                System.out.println("account type ");
                String accounttype = scan.next();

                System.out.println("intrest");
                int intrest = scan.nextInt();



                Account acc = new Account(accno,amount,accounttype,intrest,cutomerId);
                System.out.println("transactionid");
                int transactionid= Rc.nextInt();

                System.out.println("transacction type");
                String transactiontype = scan.next();
                int balance =amount;



                TransectionDetails trans=new TransectionDetails(transactionid,transactiontype,balance,accno);

                dao.createAccount(acc, trans);

                break;
            case 2:
                String choice2= scan.next();
                if(choice2.equalsIgnoreCase("deposite")){
                    System.out.println("enter account number");
                    int accountnumber=scan.nextInt();
                    System.out.println("transaction id");
                    int transid= Rc.nextInt();

                    System.out.println("transacction type");
                    String transaction = scan.next();
                    System.out.println("enter amount");
                    int amount1= scan.nextInt();


                    TransectionDetails trans2=new TransectionDetails(transid,transaction,amount1,accountnumber);
                    dao.deposit(trans2,accountnumber);
                }
                else if (choice2.equalsIgnoreCase("withdraw")){
                    System.out.println("enter aaccountnumber");
                    int accountnumber=scan.nextInt();
                    System.out.println("transaction id ");
                    int transid= Rc.nextInt();

                    System.out.println("transacction type");
                    String transaction = scan.next();
                    System.out.println("enter amount");
                    int amount1= scan.nextInt();


                    TransectionDetails trans3=new TransectionDetails(transid,transaction,amount1,accountnumber);
                    dao.withdraw(trans3,accountnumber);
                }
                break;
        }
        System.out.println("do you wANT to see transaction details");

        String choice3= scan.next();
        if(choice3.equalsIgnoreCase("yes")){
            System.out.println("enter your account number");
            int acc= scan.nextInt();
            if(choice3.equalsIgnoreCase("yes")){
                dao.displaytrans(acc);
            }}
    }
    }
