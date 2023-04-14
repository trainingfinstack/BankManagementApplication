package customerRegistration.coreJava.src.main.com.tutorial.projectwithMaven;

import customerRegistration.coreJava.src.main.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class BankManagementApplication {
    static SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
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

                    showCustomerDetails();
                    break;
                case 3:
                    System.out.println("Enter Customer Id");
                    int customerId = sc.nextInt();

                        System.out.println("Account Added with Account id " + createAccount(customerId));
                    break;
                case 4:
                    showAccountDetails();
                    break;
                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
        sessionFactory.close();
    }

    private static int registerCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name");
        String name = sc.nextLine();
        System.out.println("Enter Age");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Mobile");
        String mobile = sc.nextLine();

        Customer c1 = new Customer();
        c1.setAge(age);
        c1.setMobile(mobile);
        c1.setName(name);
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(c1);
        tx.commit();
        return c1.getId();
    }

    private static void showCustomerDetails() {
        System.out.println("Enter Customer Id");
        Scanner sc=new Scanner(System.in);
        int customer_Id = sc.nextInt();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Customer customer = session.get(Customer.class,customer_Id);
        System.out.println(customer);
        tx.commit();

    }

    private static String createAccount(int customerId) {
        String accountNumber = createAccountNumber();
        String now = setDate().toString();
        System.out.println("Which Type of Account you want (current/saving/salary)  ");
        Scanner sc = new Scanner(System.in);
        String accountType = sc.nextLine();
        System.out.println("Enter Deposit Amount");
        int depositAmount = sc.nextInt();
        Account a1 = new Account();
        a1.setBalance(depositAmount);
        a1.setAccountNumber(accountNumber);
        a1.setAccountType(accountType);
        a1.setCustomerid(customerId);
        a1.setOpenedDate(now);
        a1.setActiveStatus(true);
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(a1);
        tx.commit();

        return accountNumber;
    }

    private static void showAccountDetails() {
        System.out.println("Enter Customer Id");
        Scanner sc=new Scanner(System.in);
        int customer_Id = sc.nextInt();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Account account = session.get(Account.class,customer_Id);
        System.out.println(account);
        tx.commit();


    }

    private static String createAccountNumber() {
        LocalDateTime now = LocalDateTime.now();
        Random rand = new Random();
        int randomNum = rand.nextInt(9999);
        String a = now.toString().replaceAll("[^0-9]", "");
        String accountNumber = a.substring(0, 16) + String.format("%04d", randomNum);
        return accountNumber;
    }

    public static LocalDateTime setDate() {
        LocalDateTime now = LocalDateTime.now();
        return now;
    }

}