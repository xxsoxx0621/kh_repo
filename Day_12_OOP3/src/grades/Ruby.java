package grades;

public class Ruby extends Grade{
	
	public Ruby(int id, String name, int point) {
		super(id,name,point);
	}
	@Override
	public double getBonus() {
		return this.getPoint()*0.05;
	}

}
