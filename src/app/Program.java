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
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		IO.println("Enter cliente data:");
		IO.print("Name: ");
		String name = sc.nextLine();
		IO.print("Email: ");
		String email = sc.nextLine();
		IO.print("Birth date (DD/MM/YYYY): ");
		LocalDate birthDate = LocalDate.parse(sc.next(), fmt);
		sc.nextLine();
		
		Client client = new Client(name, email, birthDate);
		
		IO.println();
		IO.println("Enter order data:");
		IO.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());
		
		IO.print("How many items to this order? ");
		int quantityItens = sc.nextInt();
		
		Order order = new Order(Instant.now(), status, client);
		
		for(int i = 1; i <= quantityItens; i++) {
			
			IO.println("Enter #" + i + " item data:");
			sc.nextLine();
			IO.print("Product name: ");
			String productName = sc.nextLine();
			IO.print("Product price: ");
			Double productPrice = sc.nextDouble();
			IO.print("Quantity: ");
			Integer quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
					
			order.addItem(orderItem);
		}
		
		IO.println();
		IO.println(order);
			
		sc.close();
		
	}

}
