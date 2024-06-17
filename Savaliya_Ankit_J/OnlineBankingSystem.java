package TempProject;
import java.util.Scanner;

class AcountDetails {
    static Scanner sc = new Scanner(System.in);

    String[][] details = new String[1][3];
    String[] transcations = new String[10];
    int i = 0 ;

    int balance ;

    public void name() {
        System.out.print("Enter Name : ");
        details[0][0] = sc.next();
    }

    public void aadhar() {
        System.out.print("Enter Aadhar Number : ");
        String aadhar = sc.next();
        details[0][1] = aadhar;
        while (details[0][1].length() != 12) {
            System.out.print("Please Enter Valid aadhar Number : ");
            details[0][1] = sc.next();
        }
    }

    public void mobile() {
        System.out.print("Enter Mobile Number : ");
        details[0][2] = sc.next();
        while (details[0][2].length() != 10) {
            System.out.print("Please Enter Valid Mobile Number : ");
            details[0][2] = sc.next();
        }
    }

    public void setBalance(){
        System.out.print("Enter Initial Balance : ");
        balance = sc.nextInt();
    }

    public void displayDetails() {
        System.out.println("Account Details : \n\n");
        System.out.println("Name : " + details[0][0]);
        System.out.println("Aadhar Number : " + details[0][1]);
        System.out.println("Mobile Number : " + details[0][2]);
        System.out.println("Balance : " + balance + "\n\n");
    }

    public void deleteAccount() {
        details[0][0] = null;
        details[0][1] = null;
        details[0][2] = null;
        balance = 0;
        System.out.println("Account has been successfully deleted....\n\n");
    }

    public void fundTransfer(int Money,String Details){
        balance -= Money ;
        transcations[i++] = "Money : " + Money + " Account Number : " + Details ;
    }

    public void payBills(int Money , String Details){
        balance -= Money ;
        transcations[i++] = "Money : " + Money + " Account Number : " + Details ;
    }

    public void depositMoney(int Money){
        balance += Money ;
        transcations[i++] = "Money : " + Money + " Account Number : " + null ;
    }

    public void TransactionHistory(){
        for(String str : transcations){
            System.out.println(str);
        }
    }

}

public class OnlineBankingSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AcountDetails ac = new AcountDetails();

        System.out.println("\n\nWelcome To Bank : \n\n");

        while (true) {

            System.out.println("1. create Bank Account... ");
            System.out.println("2. Account management...");
            System.out.println("3. Transaction History...");
            System.out.println("4. Fund Transfer...");
            System.out.println("5. Bill Payments...");
            System.out.println("6. Deposit Money...");
            System.out.println("7. Security Measures...");
            System.out.println("8. Exit...");

            System.out.print("\n\nPlease Select What you want to do ? : ");
            int select = sc.nextInt();

            switch (select) {

                case 1 :
                    System.out.println("Sure : \n");
                    ac.name();
                    ac.aadhar();
                    ac.mobile();
                    ac.setBalance();
                    System.out.println("\nAccount has been successfully Created....");
                    System.out.println("Thank You...\n");
                    break;

                case 2 :
                    if (ac.details[0][0] == null) {
                        System.out.println("\n\nPlease create an account first.\n\n");
                    } else {
                        System.out.println("Sure : \n");
                        System.out.println("\n\n1. Edit Name...");
                        System.out.println("2. Edit Aadhar Number...");
                        System.out.println("3. Edit Mobile Number...");
                        System.out.println("4. Delete Account...");
                        System.out.println("5. Display Account Details...");

                        System.out.print("\nWhat you Want to Do ? : ");
                        int select2 = sc.nextInt();
                        switch (select2) {
                            case 1 :
                                ac.name();
                                break;

                            case 2 :
                                ac.aadhar();
                                break;

                            case 3 :
                                ac.mobile();
                                break ;

                            case 4 :
                                ac.deleteAccount();
                                break;

                            case 5:
                                ac.displayDetails();
                                break;
                        }
                    }
                    break;

                case 3 :
                    if (ac.details[0][0] == null) {
                        System.out.println("\n\nPlease create an account first.\n\n");
                    } else {
                        ac.TransactionHistory();
                    }
                    break;


                case 4 :
                    if (ac.details[0][0] == null) {
                        System.out.println("\n\nPlease create an account first.\n\n");
                    } else {
                        System.out.print("Enter Fund You want to Transfer : ");
                        int fund = sc.nextInt();
                        while (fund > ac.balance) {
                            System.out.print("Enter Amount Less Then : " + ac.balance + " : ");
                            fund = sc.nextInt();
                        }
                        System.out.print("Enter Fund Account Number : ");
                        String fundDetails = sc.next();
                        while (fundDetails.length() != 12) {
                            System.out.print("Enter Valid Account Number : ");
                            fundDetails = sc.next();
                        }
                        ac.fundTransfer(fund, fundDetails);
                    }
                    break;

                case 5:
                    if (ac.details[0][0] == null) {
                        System.out.println("\n\nPlease create an account first.\n\n");
                    } else {
                        System.out.print("Enter Details of billing : ");
                        String billDetails = sc.next();
                        System.out.print("Enter Amount You want to Pay : ");
                        int bill = sc.nextInt();
                        while (bill > ac.balance) {
                            System.out.print("Enter Amount Less Then : " + ac.balance + " : ");
                            bill = sc.nextInt();
                        }
                        ac.payBills(bill, billDetails);
                    }
                    break ;

                case 6 :
                    if (ac.details[0][0] == null) {
                        System.out.println("\n\nPlease create an account first.\n\n");
                    } else {
                        System.out.print("Enter Amount to be Added : ");
                        int amount = sc.nextInt();
                        ac.depositMoney(amount);
                    }
                    break ;

                case 7 :
                    System.out.println("Here Are Bank Security Measures : ");
                    System.out.println("1. Trust on reliable sources");
                    System.out.println("2. Implement the Use of Multi-Factor Authentication.");
                    System.out.println("3. Make use of Complex Passwords.");
                    System.out.println("4. Prevent the use of Public WIFI and switch off PC when not in use");
                    System.out.println("5. Install Antivirus");
                    System.out.println("6. Install various payment alternatives \n");
                    break ;

                case 8 :
                    System.out.println("Exiting...");
                    sc.close();
                    System.out.println("\n\n\nThank You...\n");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}