package com.lec.ex01_inputstreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// (1)��Ʈ�� ��ü ����(������ ����) (2)read�޼ҵ� ���(�����͸� ����) (3)close�޼ҵ� ���(������ ����)
public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt"); // 1. ������ ����
			// 2. �����͸� ����(���� ������ 1byte���� ����)
			while (true) {
				int i = is.read(); // 1byte�� ����
				if (i == -1)
					break; // ������ ���̸� break;
				System.out.print((char) i + "(" + i + ")");
			}
			System.out.println("\nDONE");
		} catch (FileNotFoundException e) {
			System.out.println("���� �޼��� : ������ �� ã�� " + e.getMessage());
		} catch (IOException e) {
			System.out.println("���� �޼��� : ������ �� ���� " + e.getMessage());
		} finally {
			// 3. ������ ����
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
