package model.service;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {

		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {
		double basicQuata = contract.getTotalValue() / months;
		for (int i = 1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);

			double totalQuata = onlinePaymentService.paymentFee(onlinePaymentService.interest(basicQuata, i));

			contract.getInstallments().add(new Installment(dueDate, totalQuata));

		}

		// contract.getInstallments().add(new Installment(LocalDate.of(2018, 05, 25),
		// 206.04));
	}

}
