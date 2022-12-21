package com.lec.ex;

//0 < Math.random() < 1 : �Ǽ�
//0 < Math.random()*45 < 45 : �Ǽ�
//1 < (int)(Math.random()*45+1) < 46 : 1~45������ ����
public class Ex06_lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		int i, j;
		int temp;
		for (i = 0; i < lotto.length; i++) {
			do { // �߻��� ������ �ߺ��Ǿ����� üũ
				temp = (int) (Math.random() * 45 + 1);
				System.out.println(i);
				for (j = 0; j < i; j++) {
					if (lotto[j] == temp) {
						System.out.println("�ߺ��Ǿ �ٽ� �� " + temp);
						break;
					} // if = temp�� ���� ��ȣ�� ������ for���� ��������.
				} // for
			} while (i != j);
			lotto[i] = temp;
			// lotto[i] = (int)(Math.random()*45+1);
		}
		// �߻��� �ζ� ��ȣ ���
		for (int l : lotto) {
			System.out.print(l + "\t");
		}
		System.out.println("\n���� ��");
		// lotto �迭 ���� sort
		for (i = 0; i < lotto.length - 1; i++) {
			for (j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		for (int l : lotto) {
			System.out.print(l + "\t");
		}
	}

}
