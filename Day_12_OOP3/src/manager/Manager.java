package manager;

import java.util.ArrayList;

import grades.Gold;
import grades.Grade;
import grades.Sliver;

public class Manager {
	private ArrayList members = new ArrayList();

	// 오버로딩
	public void addMember(Grade g) {
		this.members.add(g);

	}
	public ArrayList getMembers() {
		return members;
	}
}
