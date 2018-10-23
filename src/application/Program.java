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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Client data: ");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String emailClient = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDateClient = sdf.parse(sc.nextLine());
		
		Client client = new Client(nameClient, emailClient, birthDateClient);
		
		System.out.println("Enter Order data: ");
		System.out.print("Status: ");
		String statusOrder = sc.nextLine();
		
		OrderStatus status = OrderStatus.valueOf(statusOrder);
			
		Order order = new Order(new Date(), status, client);
		System.out.print("How many item to this order? ");
		int quantityItems = sc.nextInt();
		
		
		for(int i = 1 ; i <= quantityItems; i++) {
			sc.nextLine();
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String nameProduct = sc.nextLine();
			System.out.print("Product price: ");
			double priceProduct = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantityProduct = sc.nextInt();
			
			Product product = new Product(nameProduct, priceProduct);
			OrderItem orderItem = new OrderItem(quantityProduct, product);
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY");
		System.out.println(order);
		
		
		
		
		sc.close();
	}

}
