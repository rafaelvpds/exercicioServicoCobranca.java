package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Entre com os dados do Contrato");
		System.out.print("Número: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), dtf);
		System.out.print("Entre com o valor do contrato: ");
		double totalValue = sc.nextDouble();
		Contract obj = new Contract(number, date, totalValue);

		System.out.print("Entre com o valor da parcela: ");
		int numberInstalment = sc.nextInt();

		ContractService contractService = new ContractService(new PaypalService());

		contractService.processContract(obj, numberInstalment);
		System.out.println();
		System.out.println("Parcelas:");

		for (Installment installment : obj.getInstallments()) {
			System.out.println(installment);
		}

		sc.close();

	}

}
