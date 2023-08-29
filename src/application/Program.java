package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;



public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (dd/MM/yyyy): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		Integer n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			System.out.println("Enter #" + (i + 1) + " item data: ");
			System.out.print("Product name: ");
			String nameP = sc.next();
			System.out.print("Product prices: ");
			Double priceP = sc.nextDouble();
			
			Product product = new Product(nameP, priceP);
			
			System.out.print("Quantity: ");
			Integer quantityP = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantityP, priceP, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);
		
		sc.close();
	}

}
