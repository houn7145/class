package com.lec.loop;
//��� : 1~20���� �������� 210
//��� : 1+2+3+4+5+6+....20
public class Ex02for { // 1~20���� ������ ���
	public static void main(String[] args) {
			int tot=0;
			for(int i=1 ; i<=20 ; i++){
				System.out.print(i);
				if(i!=20)
					System.out.print("+");
				tot += i;
			}
			System.out.println("="+tot);	
}
}

