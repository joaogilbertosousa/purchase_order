package app;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;

public class Program {
	
	void main() {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		IO.println("Enter cliente data:");
		IO.print("Name: ");
		String name = sc.nextLine();
		IO.print("Email: ");
		String email = sc.nextLine();
		IO.print("Birth date (DD/MM/YYYY): ");
		LocalDate birthDate = LocalDate.parse(sc.next(), fmt1);
		sc.nextLine();
		
		Client client = new Client(name, email, birthDate);
		
		IO.println();
		IO.println("Enter order data:");
		IO.print("Status: ");
		String orderStatus = sc.nextLine();
		
		IO.print("How many items to this order? ");
		int quantityItens = sc.nextInt();
		
		Order order = new Order(Instant.now(), OrderStatus.valueOf(orderStatus));
		
		for(int i = 1; i <= quantityItens; i++) {
			
			IO.println("Enter #" + i + " item data:");
			sc.nextLine();
			IO.print("Product name: ");
			String nameProduct = sc.nextLine();
			IO.print("Product price: ");
			Double priceProduct = sc.nextDouble();
			
			Product prod = new Product(nameProduct, priceProduct);
			
			IO.print("Quantity: ");
			Integer quantityProduct = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantityProduct, prod.getPrice());
			
			order.addItem(orderItem);
						
		}
		
		IO.println(fmt2.format(order.getMoment().atZone(ZoneId.systemDefault())));
		IO.println(order.getStatus());
		IO.println(client.getName() + " " + fmt1.format(client.getBirthDate()) + " - " + client.getEmail());
			
		
		sc.close();
		
	}

}
