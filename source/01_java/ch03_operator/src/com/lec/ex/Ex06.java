package com.lec.ex;
// 할당(대입)연산자 : = +=, -=, *=, /=, %= (오른쪽에서 왼쪽으로 수행)
public class Ex06 {
	public static void main(String[] args) {
		int n1 = 10;
		n1 += 10; // n1 = n1+10 =20
		System.out.println("n1 = " + n1);
		n1 *= 10; // n1 = n1*10 =200
		System.out.println("n1 = " + n1);
		int n2, n3;
		n1 = n2 = n3 = 10;
		System.out.println(n1 +"\t" + n2 + "\t" + n3);
	}
}
