package com.lec.ex03_speakertv;
// �������̽� - static final ����(���)�� �߻�޼ҵ�, ���� (default �޼ҵ�, static �޼ҵ�)
// �۾����� 
public interface Ivolume {
	public void volumeUp(); // ���� ������ 1�� �ø�
	public void volumeUp(int level); // ���� ������ level�� �ø�
	public void volumeDown(); // ���� ������ 1�� ����
	public void volumeDown(int level); // ���� ������ level�� ����
	public default void setMute(boolean mute) { // default �޼ҵ�
		if(mute) {
			System.out.println("����");
		}else {
			System.out.println("��������");
		}
	}
	public static void changeBattery() { // static �޼ҵ�
		System.out.println("�����⸦ ��ȯ�մϴ�");
	}
}
