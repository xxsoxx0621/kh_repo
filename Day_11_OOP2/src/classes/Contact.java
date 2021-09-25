package classes;

public class Contact {
	// Contact
			// 숫자 id
			// name
			// 연락처
		
			
			// getter / setter / constructor / default constructor
			
			
			private int id;
			private String name;
			private String tel;
			
			// getter / setter / constructor / default constructor
			
			public void setId(int id){
				this.id  = id;
			}
			
			public int getId() {
				return id;
			}
			
			public void setName(String name){
				this.name  = name;
			}
			
			public String getName() {
				return name;
			}
			public void setTel(String tel){
				this.tel  = tel;
			}
			
			public String getTel() {
				return tel;
			}
			public Contact(int id, String name, String tel) {
				this.id = id;
				this.name = name;
				this.tel = tel;
			}
			
			public Contact() {
				
			}

		}

