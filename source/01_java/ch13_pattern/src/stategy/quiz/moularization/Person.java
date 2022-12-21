package stategy.quiz.moularization;

import strategy.quiz.interfaces.GetImpl;
import strategy.quiz.interfaces.JobImpl;

public class Person {

	private String id;
	private String name;
	private GetImpl get;
	private JobImpl job;

	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public void get() {
		get.get();
	}

	public void job() {
		job.Job();
	}

	public void print() {
		System.out.print("(ID)" + id + "(¿Ã∏ß)" + name);
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGet(GetImpl get) {
		this.get = get;
	}

	public void setJob(JobImpl job) {
		this.job = job;
	}
}
