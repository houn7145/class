package com.lec.ex04_object;

public class Point3D implements Cloneable {
	private double x;
	private double y;
	private double z;
	public Point3D() {
	}
	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public boolean equals(Object obj) { 
		// x,y,z 실수의 좌표값이 같으면 true 값을 리턴하고 
		// 그렇지 않으면 false를 리턴하는 equals()재정의
		if(obj!=null && getClass() == obj.getClass()) {
			Point3D other = (Point3D)obj;
			boolean xChk = x == other.x;
			boolean yChk = y == other.y;
			boolean zChk = z == other.z;
			return xChk && zChk && yChk;
		}
		return false;
	}
	@Override
	public String toString() {
		// 좌표값 [x값, y값, z값]을 리턴하는 toString() 재정의
		return String.format("x값 : %.1f, y값 : %.1f z값 : %.1f", x, y, z);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}

}
