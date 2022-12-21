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
		// x,y,z �Ǽ��� ��ǥ���� ������ true ���� �����ϰ� 
		// �׷��� ������ false�� �����ϴ� equals()������
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
		// ��ǥ�� [x��, y��, z��]�� �����ϴ� toString() ������
		return String.format("x�� : %.1f, y�� : %.1f z�� : %.1f", x, y, z);
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
