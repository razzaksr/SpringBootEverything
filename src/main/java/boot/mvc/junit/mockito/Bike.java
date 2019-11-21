package boot.mvc.junit.mockito;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="bikes")
public class Bike implements Serializable
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bid;
	private String model;
	private int price, milage;
	
	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bike(String model, int price, int milage) {
		super();
		this.model = model;
		this.price = price;
		this.milage = milage;
	}
	public Bike(Integer bid, String model, int price, int milage) {
		super();
		this.bid = bid;
		this.model = model;
		this.price = price;
		this.milage = milage;
	}
	@Override
	public String toString() {
		return "Bike [bid=" + bid + ", model=" + model + ", price=" + price + ", milage=" + milage + "]";
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMilage() {
		return milage;
	}
	public void setMilage(int milage) {
		this.milage = milage;
	}
}
