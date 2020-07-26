



import java.util.ArrayList;
import java.util.List;

class Cart {
	 
	List<Item> items;
	public Cart() {
		this.items=new ArrayList<Item>();
	}
	public void addItem(Item item) {
		this.items.add(item);
	}
	public void removeItem(Item item) {
		this.items.remove(item);
	}
	public double calculateTotal() {
		double sum=0;
		for(Item item:items) {
			sum+=item.getPrice();
		}
		return sum;
	}
	public void payAmount(Payment type) {
		double amount = calculateTotal();
		type.pay(amount);
	}
}

class CreditCard implements Payment{
	
	private String nameOfTheCardholder;
	private String cardNumber;
	private String cvvCode;
	private String dateOfExpiry;
	
	public CreditCard(String nameOfTheCardholder,String cardNumber,String cvvCode,String dateOfExpiry) {
		this.cardNumber=cardNumber;
		this.cvvCode=cvvCode;
		this.dateOfExpiry=dateOfExpiry;
		this.nameOfTheCardholder=nameOfTheCardholder;
	}
	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub
		System.out.println("amount paid using Credit card  account number: ********3115:\n"+ amount);
	}

}
class Item {
private String barCode;
private double price;
public Item(String barCode,double price) {
	this.barCode=barCode;
	this.price=price;
}
public String getBarCode() {
	return barCode;
}
public double getPrice() {
	return price;
}
}

 interface Payment {
public void pay(double amount);
}


class UPI implements Payment {
	private String upiId;
	private String pin;

	public UPI(String upiId,String pin) {
		this.pin=pin;
		this.upiId=upiId;
	}
	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub
		System.out.println("amount Paid with UPI id: ****3072:\n" + amount);
		
	}

}
class StrategyPattern {
public static void main(String[] args) {
	Cart cart = new Cart();
	Item item1 = new Item("897807",45.5);
	Item item2 = new Item("73062",55);
	cart.addItem(item1);
	cart.addItem(item2);
	cart.payAmount(new CreditCard("Anirudh","81354678793115","234","12/27"));
	cart.payAmount(new UPI("8978073072@apl","2020"));
}
}