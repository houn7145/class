package com.lec.ex03_point.copy;
// x, y / infoPrint(��ǥ x=2, y=1�� �ֿܼ� ���)
public class Point3D extends Point {
	private int z;
	public Point3D(int x, int y, int z) {
		super(x,y);
		System.out.println("�Ű����� �ִ� Point3D ������ �Լ� - x, y, z �� �ʱ�ȭ");
//		setX(x); // private�� this. �Ұ���
//		setY(y);
		this.z = z;
	}
	@Override
	public String infoPrint() {
	//	System.out.println("��ǥ x=" + getX() + ", y=" + getY() +", z=" + z);
		return super.infoPrint() + ", z=" + z;
	}
	// infoPrint�� override : ��ǥ x=2, y=1, z=1(super.infoPrint �̿�)
//	public void infoPrint3D() {
//		System.out.println("��ǥ x=" + getX() + ", y=" + getY() +", z=" + z);
//	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}
