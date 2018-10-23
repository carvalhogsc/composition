package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
		
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double total = 0.0;
		
		for (OrderItem c : items) {
			total += c.subTotal();
		}
		
		return total;
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment :");
		sb.append(sdf1.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client :");
		sb.append(client.getName() + " (");
		sb.append(sdf2.format(client.getBirthDate()) + ") - ");
		sb.append(client.getEmail() + "\n");
		sb.append("Order items: \n");
		for(OrderItem c : items)
		{
			sb.append(c.toString());
		}
		sb.append("Total price :");
		sb.append(String.format("%.2f",total()) + "\n");
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	

}
