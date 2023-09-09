package com.IshwaryaR.FXTrading;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("Fxtrade")
class Conversion {
	private String customerName;
	private String currencyPair;
	private double amount;
	private String duplicate1;
	private String duplicate2;
	private String decision;
	private String drate;
	private int tradenumber=0;
	public Conversion() {
	}
	public Conversion( String customerName, String currencyPair, double amount,String drate,int tradenumber) {
		
		this.customerName = customerName;
		this.currencyPair = currencyPair;
		this.amount = amount;
		this.drate=drate;
		this.tradenumber=tradenumber;
		
	}
	public int getTradenumber() {
		return tradenumber;
	}
	public void setTradenumber(int tradenumber) {
		this.tradenumber = tradenumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCurrencyPair() {
		return currencyPair;
	}
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public String getDrate() {
		return drate;
	}
	public void setDrate(String drate) {
		this.drate = drate;
	}
	@Override
	public String toString() {
		return "Conversion [customerName=" + customerName + ", currencyPair=" + currencyPair + ", amount=" + amount
				+ ", duplicate1=" + duplicate1 + ", duplicate2=" + duplicate2 + ", decision=" + decision + ", drate="
				+ drate + ",tradenumber=" + tradenumber + "]";
	}
	ArrayList<Conversion> list = new ArrayList<>() ;
	@PostMapping("booktrade")
	public String receivetrade(@RequestBody Conversion con )
	{
		con.booktrade(con);
		list.add(con);
		tradenumber++;
		return "Trade Booked\n" + con.view();
	}
	 public void booktrade(Conversion con )
	{
		
		if(getDrate().equalsIgnoreCase("Yes"))
		{
			duplicate1="You are transferring INR "+getAmount()*66.0+"to"+ getCustomerName()+"(Assuming the rate was66.0)";
		}else {
			duplicate1="";
		}
		if(getDecision().equalsIgnoreCase("BOOK"))
		{
			duplicate2="Trade for USDINR has been booked with rate 66.0.The amount of Rs"+getAmount()*66.0+" will be transferred in 2 working days to"+ getCustomerName();
		}else {
			duplicate2="";
		}
	}
	 public String view()
	 {
		 return duplicate1+"\n" +duplicate2;
	 }
	 @GetMapping("printtrade")
	 public ArrayList<Conversion> getTrades()
	 {
		 return list;
	 }		   
	
}



    