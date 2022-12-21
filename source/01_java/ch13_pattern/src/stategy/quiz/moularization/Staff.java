package stategy.quiz.moularization;

import strategy.quiz.interfaces.GetSalary;
import strategy.quiz.interfaces.JobMng;

public class Staff extends Person {
	private String part;

	public Staff(String id, String name, String part) {
		super(id, name);
		this.part = part;
		setGet(new GetSalary());
		setJob(new JobMng());
	}

	@Override
	public void print() {
		super.print();
		System.out.println("(ºÎ¼­)" + part);
	}
}
