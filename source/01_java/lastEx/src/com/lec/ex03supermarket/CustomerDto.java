package com.lec.ex03supermarket;

public class CustomerDto {
	private int id;
	private String tel;
	private String cname;
	private int point;
	private int cum_amt;
	private String levelname;
	private int nextbuy;

	public CustomerDto() {
	}

// 입력용
	public CustomerDto(int id, String tel, String cname) {
		this.id = id;
		this.tel = tel;
		this.cname = cname;
	}

// 출력용
	public CustomerDto(int id, String tel, String cname, int point, int cum_amt, String levelname, int nextbuy) {
		this.id = id;
		this.tel = tel;
		this.cname = cname;
		this.point = point;
		this.cum_amt = cum_amt;
		this.levelname = levelname;
		this.nextbuy = nextbuy;
	}

	@Override
	public String toString() {
		return id + "\t" + tel + "\t" + cname + "\t" + point + "\t" + cum_amt + "\t" + levelname + "\t" + nextbuy;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getCum_amt() {
		return cum_amt;
	}

	public void setCum_amt(int cum_amt) {
		this.cum_amt = cum_amt;
	}

	public String getLevelname() {
		return levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	public int getNextbuy() {
		return nextbuy;
	}

	public void setNextbuy(int nextbuy) {
		this.nextbuy = nextbuy;
	}
}

