package com.lec.ex03_point.copy;
// x, y / infoPrint(좌표 x=2, y=1을 콘솔에 출력)
public class Point3D extends Point {
	private int z;
	public Point3D(int x, int y, int z) {
		super(x,y);
		System.out.println("매개변수 있는 Point3D 생성자 함수 - x, y, z 값 초기화");
//		setX(x); // private라 this. 불가능
//		setY(y);
		this.z = z;
	}
	@Override
	public String infoPrint() {
	//	System.out.println("좌표 x=" + getX() + ", y=" + getY() +", z=" + z);
		return super.infoPrint() + ", z=" + z;
	}
	// infoPrint를 override : 좌표 x=2, y=1, z=1(super.infoPrint 이용)
//	public void infoPrint3D() {
//		System.out.println("좌표 x=" + getX() + ", y=" + getY() +", z=" + z);
//	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}
