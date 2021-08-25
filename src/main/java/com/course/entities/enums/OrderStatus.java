package com.course.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code=code;
	}

	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		for(OrderStatus os : OrderStatus.values()) {
			if (os.getCode() == code) {
				return os;	
			}
		}
		throw new IllegalArgumentException("Não há status referente essa numeração.");

	}

	OrderStatus valueOf(OrderStatus orderStatus) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
