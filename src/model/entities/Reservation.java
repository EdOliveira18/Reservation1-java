package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long d = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(d, TimeUnit.MILLISECONDS);
	}
	public void updateDates(Date checkout, Date checkin) {
		Date date = new Date();
		if(checkin.before(date) || checkout.before(date) ) {
			System.out.println("Reservation dates for update must be future dates");
		}
		if(checkout.before(checkin)) {
			System.out.println("Check-out date must be after check-in date");
		}	
		
		this.checkin = checkin;
		this.checkout = checkout;
	}
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkin)
				+ ", check-out: "
				+ sdf.format(checkout)
				+ ", "
				+ duration()
				+ " nights";
	}
}
