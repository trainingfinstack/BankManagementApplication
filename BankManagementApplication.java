package customerRegistration.coreJava;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BankManagementApplication {
    static ArrayList<Customer>customerList=new ArrayList<>();
    static ArrayList<Account>accountList=new ArrayList<>();
    static int i=0;

    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("Please select an option:");
            System.out.println("1. Register a new customer");
            System.out.println("2. Show customer details");
            System.out.println("3. Customer Account Creation");
            System.out.println("4. Customer Account Details");
            System.out.println("5. Exit");
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("Customer Added with Customer id " + registerCustomer());
                    break;
                case 2:
                    System.out.println("Enter Customer Id");
                    int c_id=sc.nextInt();
                    showCustomerDetails(c_id);
                    break;
                case 3:
                    System.out.println("Enter Customer Id");
                    int customerId=sc.nextInt();
                    if(customerId>i)
                    {
                        System.out.println("Enter Valid Customer Id");
                    }
                        else {
                        System.out.println("Account Added with Account id " +  createAccount(customerId));
                    }
                        break;
                case 4:
                    System.out.println("Enter Customer Id");
                    int cust_id=sc.nextInt();
                    showAccountDetails(cust_id);
                    break;
                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    private static int registerCustomer() {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Name");
        String name=sc.nextLine();
        System.out.println("Enter Age");
        int age=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Mobile");
        String mobile=sc.nextLine();

        Customer customer=new Customer(++i,name,age,mobile) ;

        customerList.add(customer);
        return i;
    }

    private static void showCustomerDetails(int customer_Id) {

        for(Customer customer:customerList)
        {
            if(customer_Id==customer.getId())
            {
                System.out.println("Customer Id:" + customer.getId());
                System.out.println("Name:" + customer.getName());
                System.out.println("Age: " + customer.getAge());
                System.out.println("Mobile: " + customer.getMobileNumber());
                System.out.println();
                System.out.println();
            }
            else
            {
                System.out.println("Enter valid  customer Id");
            }
        }
    }

    private static String createAccount(int customerId) {
        String accountNumber=CreateAccountNumber();
        String now=setDate().toString();
        System.out.println("Which Type of Account you want (current/saving/salary)  ");
        Scanner sc=new Scanner(System.in);
        String x=sc.nextLine();
        System.out.println("Enter Deposit Amount");
        int n=sc.nextInt();
           Account account=new Account(customerId,accountNumber,x,n,now,true);
           accountList.add(account);
           return accountNumber;
    }
    private static void showAccountDetails(int cust_Id) {

        for(Account account:accountList)
        {
            if(cust_Id== account.getId()) {
                System.out.println("Account Number:" + account.getAccountNumber());
                System.out.println("Account Type:" + account.getAccountType());
                System.out.println("opened Date: " + account.getOpenedDate());
                System.out.println("Balance: " + account.getBalance());
                System.out.println();
            }
            else
            {
                System.out.println("Enter Valid Customer Id");
            }
        }
    }

    private static String CreateAccountNumber() {
        LocalDateTime now = LocalDateTime.now();
        Random rand = new Random();
        int randomNum = rand.nextInt(9999);
        String a = now.toString().replaceAll("[^0-9]", "");
        String accountNumber=a.substring(0,16)+String.format("%04d", randomNum);
        return accountNumber;
    }
    public static LocalDateTime setDate()
    {
        LocalDateTime now = LocalDateTime.now();
        return now;
    }
}