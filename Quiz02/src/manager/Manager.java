package manager;

import java.util.ArrayList;

import menu.Menu;

public class Manager {

	ArrayList<Menu> menu = new ArrayList<>();

	// 메뉴 저장
	public void addMenu(Menu menu) {
		this.menu.add(menu);
	}

	//메뉴 출력
	public ArrayList<Menu> getMenu(){
		return this.menu;

	}

	public void deleteMenu(int id) {
//		for(Menu m : menu) {
			// Concreate
			// CopyOnWriteArrayList
			
			ArrayList<Menu> tmp = new ArrayList<>();

			//			if(m.getId() == id) {
			//				menu.remove(m);
			//				// System.out.println(id + "번 "+ m.getMenuName()+ "메뉴를 삭제 했습니다.");
			//				break;
			//			}

			for(Menu m: menu) {
				if(m.getId()== id) {
					tmp.add(m);
				}
			}
			
			for(Menu m : tmp) {
				menu.remove(m);
			}
		}

	}

