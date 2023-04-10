package customerRegistration.coreJava;

public class Account {

 String accountNumber;
String accountType;
int Balance;
String openedDate;
boolean activeStatus;

    public Account(String accountNumber, String accountType, int balance, String openedDate, boolean activeStatus) {

        this.accountNumber = accountNumber;
        this.accountType = accountType;
        Balance = balance;
        this.openedDate = openedDate;
        this.activeStatus = activeStatus;
    }

    public Account() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public String getAccountType() {
        return accountType;
    }

    public int getBalance() {
        return Balance;
    }

    public String getOpenedDate() {
        return openedDate;
    }


}
