package com.lec.ex01_inputstreamOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_OutfutStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true); // 1�ܰ�
			String msg = "Hello, Java \n ���� ��׿�. ������ �Ͱ� �Ǽ���";
			byte[] bs = msg.getBytes(); // String�� byte�迭�� �ٲٴ� �Լ�
			os.write(bs); // 2�ܰ�
			System.out.println("���� ��� ����");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close(); // 3�ܰ�
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
