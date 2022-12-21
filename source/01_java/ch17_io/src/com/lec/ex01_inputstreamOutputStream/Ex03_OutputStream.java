package com.lec.ex01_inputstreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// ������ ���� -> ���� -> ������ �ݴ´�
public class Ex03_OutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true);  // 1. ������ ����(��Ʈ�� ��ü ����) // true : append��
			byte[] bs = {'H', 'e', 'l', 'l', 'o', ',', 'C','c'};
//			for(byte b : bs) {
//				os.write(b); // 2. �����͸� ��
//			}
			os.write(bs); // for���� ����
			System.out.println("���� ��� ����");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
