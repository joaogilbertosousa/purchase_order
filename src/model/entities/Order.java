package model.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import model.enums.OrderStatus;

public class Order {
	
	private Instant moment;
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
	}

	public Order(Instant moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
				
	public List<OrderItem> getItem() {
		return items;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
}
