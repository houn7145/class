package com.lec.ex03_speakertv;

public class Speaker implements Ivolume{
	private int volumeLevel;
	private final int MAX_VOLUME = 50;
	private final int MIN_VOLUME = 2; 
	public Speaker() {
		volumeLevel = 10;
	}
	@Override
	public void volumeUp() { // ������ 1�� ����
		if(volumeLevel < MAX_VOLUME) {
			volumeLevel++;
			System.out.println("����Ŀ ������ 1��ŭ �÷� ���� ������ : " + volumeLevel);
		}else {
			System.out.println("����Ŀ ������ �ִ�ġ("+ MAX_VOLUME +")���� �ø��� ���߽��ϴ�");
		}
	}

	@Override
	public void volumeUp(int level) {
		if(volumeLevel+level < MAX_VOLUME) {
			volumeLevel +=level; // = volumeLevel + level;
			System.out.println("����Ŀ ������ "+ level + "��ŭ �÷� ���� ������ : " + volumeLevel);
		}else {
			int tempLevel = MAX_VOLUME - volumeLevel; // 50 - 47
			volumeLevel = MAX_VOLUME;
			System.out.println("����Ŀ ������ " + tempLevel + "��ŭ �÷� �ִ� �����Դϴ�");
		}
	}

	@Override
	public void volumeDown() {
		if(volumeLevel > MIN_VOLUME) {
			volumeLevel--;
			System.out.println("����Ŀ ������ 1��ŭ ���� ���� ������ : " + volumeLevel);
		}else {
			System.out.println("����Ŀ ������ �ּ��Դϴ�");
		}
	}

	@Override
	public void volumeDown(int level) { // ���� ���� 5, level 4
		if(volumeLevel-level > MIN_VOLUME) {
			volumeLevel-=level;
			System.out.println("����Ŀ ������ " + level + "��ŭ ���� ���� ������ : " + volumeLevel);
		}else { // ���� ���� 5, level 7
			int templevel = volumeLevel - MIN_VOLUME;
			volumeLevel = MIN_VOLUME;
			System.out.println("����Ŀ ������ " + templevel + "���� ���� �ּ� �����Դϴ�");
		}
	}

}
