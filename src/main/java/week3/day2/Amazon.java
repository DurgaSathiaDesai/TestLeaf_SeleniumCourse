package week3.day2;

public class Amazon extends CanaraBank {

	public void cashOnDelivery() {
		System.out.println("Payment Mode is CashOnDelivery!");
	}

	public void upiPayments() {
		System.out.println("Payment Mode is UPI!");
	}

	public void cardPayments() {
		System.out.println("Payment Mode is Card!");
	}

	public void internetBanking() {
		System.out.println("Payment Mode is InternetBanking!");
	}
  
	public static void main(String[] args) {
		
		Amazon amazon = new Amazon();
		amazon.cardPayments();
		amazon.cashOnDelivery();
		amazon.internetBanking();
		amazon.upiPayments();
		amazon.recordPaymentDetails();
		
		System.out.println("\n");
		
		Payments payment = new Amazon();
		payment.cardPayments();
		payment.cashOnDelivery();
		payment.internetBanking();
		payment.upiPayments();
		
		System.out.println("\n");
		
		CanaraBank bank = new Amazon();
		bank.cardPayments();
		bank.cashOnDelivery();
		bank.internetBanking();
		bank.upiPayments();
		bank.recordPaymentDetails();
	}
}
