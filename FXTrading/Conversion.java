package hello;
import java.util.*;
public class Conversion {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		Conversion object = new Conversion();
		object.trade();
	}
	private int t=0;
	private String customerName;
	private String currencyPair;
	private double amount;
	public Conversion() {
		this.t=t;
		this.customerName = customerName;
		this.currencyPair = currencyPair;
		this.amount = amount;
		this.rate = rate;
	}
	public Conversion(int t, String customerName, String currencyPair, double amount, double rate) {
		this.t=t;
		this.customerName = customerName;
		this.currencyPair = currencyPair;
		this.amount = amount;
		this.rate = rate;
	}
	double rate=66.00;
	ArrayList<Conversion> list = new ArrayList<>() ;
	public void displayconversion()
	{
		System.out.printf("%d         %-8s         %-8s           NR%-10.2f     %.2f %n",
			               t,                 customerName, currencyPair,amount,    rate);
		trade();
	}
	  void trade()
	 {
		 System.out.println("Options");
	     System.out.println("1.Book Trade");
		System.out.println("2.Print Trade");
		System.out.println("3.Exit");
		System.out.println("Enter the option");
		int n;
		 n= sc.nextInt();
		switch(n)
		{
		case 1:
			booktrade();
			
			break;
		case 2:
			printtrade();
			break;
		case 3:
			exit();
			break;
		default :
			System.out.println("Ivalid option");
			System.out.println();
			trade();
		}
    }
	 void booktrade()
	{
		sc.nextLine();
	   System.out.println("Enter the Customer Name ");
	   customerName =sc.nextLine();
	   System.out.println("Enter Currency Pair ");
	   currencyPair =sc.nextLine();
	   while(!currencyPair.equals("USDINR"))
	   {
		   System.out.println("Enter the valid currencypair");
		   currencyPair =sc.nextLine();
	   }
	   System.out.println("Enter the amount to transfer ");
	   amount =sc.nextInt();
	   double total=amount*rate;
	   sc.nextLine();
	   System.out.println("Do you want to get Rate:");
	   String check=sc.nextLine();
	   if(check.equalsIgnoreCase("yes"))
		   System.out.println("You are transferring INR "+total+"to "+ customerName+ "(Assuming the rate was "+rate+")");
	   System.out.println("Do you want to Book/Cancel this trade");
	   String s= sc.nextLine();
	   if(s.equalsIgnoreCase("Book"))
	   {
		   t++;
		   System.out.println("Trade for USDINR has been booked with rate 85.25.The amount of Rs "+total+" will be transferred in 2 working days to "+ customerName);
		   list.add(new Conversion (t,currencyPair,customerName,amount,rate));
		   trade();
	   }else if(s.equalsIgnoreCase("CANCEL"))
	   {
		   System.out.println("Trade is Canceled");
		   trade();
	   }else {
		   System.out.println("Invalid Option");
		   trade();
	   }   
	}
	 void printtrade()
	{
		if(t==0)
		{
			System.out.println("No trades have been booked yet");
			trade();
		}else {
			System.out.println("TradeNo  CurrencyPair  CustomerName          Amount          Rate");
			for(Conversion list: list)
			{
			  list.displayconversion();
			}
		}
	}
	 void exit()
	{
		System.out.println("Prompt user for confirmation");
		System.out.println("Do you really want to exit(y/n)");
		sc.nextLine();
		String c=sc.nextLine();
		if(c.equalsIgnoreCase("y"))
		{
			System.out.println("Bye- have a good day");

		}else {
			trade();
		}
	}	
}


