package menu;

public class Menu {
	
	private int id;
	private String menuName;
	private int menuPrice;

	public Menu() {
		super();
	}
	
	public Menu(int id,String menuName, int menuPrice) {
		this.id = id;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	
	

}
