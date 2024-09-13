/**
   Review Project
   using chapter 1-5
   to make a bank account that get user information
   then calculate the monthly fees and total, and display the total in the account(s)
**/
import java.util.Scanner;
public class BankAccount
{
   public static void main(String[]args)
   {
      //variables
      int accountNum = 0, choice = 0;
      String customerName = "", accountType = "", enterAgain = "";
      double accountBlanace = 0.0, monthlyFee = 0.0;
     
     // ask users bank account number
      accountNum = getAccountNum();
      System.out.println();
     // ask users account type 
      choice = getAccountType();
      if(choice == 1)
      {
         accountType = "Checking";
      }
      if (choice == 2)
      {
         accountType = "Savings";
      }
      System.out.println();
     // ask customer(user) name
      customerName = getName();
      System.out.println();
   
     // ask for the account balance
      accountBlanace = getBalance();
      System.out.println();
   
     // Calcuate The monthly fee for the user account 
      monthlyFee = calcFees(choice, accountBlanace);
      System.out.println();
   
     // display the account information 
      displayInfo (accountNum, accountType, customerName, accountBlanace, monthlyFee);
      System.out.println();
   
      //loop the code again if the user have another account
      
      System.out.print("Do you wish to enter information for another account? (Y/N): ");
      Scanner keyboard = new Scanner(System.in);
      enterAgain = keyboard.nextLine();
      while(!(enterAgain.equalsIgnoreCase("N")))
      {
         // ask users bank account number
         accountNum = getAccountNum();
         System.out.println();
         
         // ask users account type 
         choice = getAccountType();
         if(choice == 1)
         {
            accountType = "Checking";
         }
         if (choice == 2)
         {
            accountType = "Savings";
         }
         System.out.println();
         // ask customer(user) name
         customerName = getName();
         System.out.println();
      
         // ask for the account balance
         accountBlanace = getBalance();
         System.out.println();
      
       // Calcuate The monthly fee for the user account 
         monthlyFee = calcFees(choice, accountBlanace);
         System.out.println();
      
         // display the account information 
         displayInfo (accountNum, accountType, customerName, accountBlanace, monthlyFee);
         System.out.println();
         
         System.out.print("Do you wish to enter information for another account? (Y/N): ");
         enterAgain = keyboard.nextLine();
      
      }
      
   
   }//body
   /**
      get user accoutn number
      @return returns the account number
   **/
   public static int getAccountNum()
   {
      
      Scanner keyboard = new Scanner(System.in);
      int number;
      System.out.print("Please enter the Account Number: ");
      number = keyboard.nextInt();
      return number;
   }
   
   /**
      get user selected account type from the menu promp
      @return returns the account type 
   **/
   public static int getAccountType()
   {
      Scanner keyboard = new Scanner(System.in);
      int choice;
      
      System.out.print("1.Checking\n2.Savings\n\nSelect an Account Type from the menu above: ");
      choice = keyboard.nextInt();
      while(choice < 1 || choice > 2)
      {
         System.out.print("PLease select between 1 or 2: ");
         choice = keyboard.nextInt();
      }
      return choice;
   }
   
   /**
      get customer/user name
      @return return the customer's name
   **/
   public static String getName()
   {
      Scanner keyboard = new Scanner(System.in);
      String name;
      System.out.print("Please enter the Customer's Name: ");
      name = keyboard.nextLine();
      return name;
   }
   
   /**
      get the account balance 
      wont take if that balance is not negative
      @return return the account balance
   **/
   public static double getBalance()
   {
      Scanner keyboard = new Scanner(System.in);
      double balance;
      System.out.print("Please enter the Account Balance: ");
      balance = keyboard.nextDouble();
      while(balance < 0)
      {
         System.out.print("Error! Please enter the amount greater than 0: ");
         balance = keyboard.nextDouble();
      }
      return balance;
   }
   
   /**
      determine the monthly fees
      @parm
      @return
   **/
   public static double calcFees(int choice, double balance)
   {
      //saving dont have monthly fees cheking has 0.1 percent
      final double CHECKING_FEES = 0.001;
      final double SAVING_FEES = 0.0 ;
      
      double fees = 0.0;
      
      if (choice == 1)//checking
      {
         fees = balance * CHECKING_FEES;
      }
      if (choice == 2)//saving
      {
         fees = balance * SAVING_FEES;
      }
      
      return fees;
   }
   
   /**
      displays
         account numbers, account type, customer name, balance and monthly fees
   **/
   public static void displayInfo (int numb, String type, String name, double balance, double fees)
   {
      System.out.println("Account Number: " + numb);
      System.out.println("Account Type: "+ type);
      System.out.println("Customer Name: "+ name);
      System.out.printf("Account Balance: $%,.2f \n",balance);
      System.out.printf("Monthly Fee: $%,.2f \n",fees);
   }
   
}// main public class