package classes;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MenuDTO {
	
	private int id;
	private String name;
	private int price;
	// sql로 import
	private Date reg_date;
	
	public MenuDTO() {}
	
	public MenuDTO(int id, String name, int price , Date reg_date) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.reg_date = reg_date;
		
	}
	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDateString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		return sdf.format(reg_date);
		
	}
}
