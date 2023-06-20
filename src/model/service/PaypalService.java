package model.service;

public class PaypalService implements OnlinePaymentService {
	@Override
	public double interest(double amount, int mounth) {

		return amount + (amount * 0.01) * mounth;
	}

	@Override
	public double paymentFee(double amount) {

		return amount + amount * 0.02;
	}

}
