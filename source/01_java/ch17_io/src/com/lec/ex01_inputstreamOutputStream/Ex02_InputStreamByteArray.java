package com.lec.ex01_inputstreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//(1)��Ʈ�� ��ü ����(������ ����) 
//(2)read�޼ҵ�(1byte�� ����, �ӵ��� ����) 
//read(byte[])(byte�迭�� length��ŭ ����)���(�����͸� ����) 
//(3)close�޼ҵ� ���(������ ����)
public class Ex02_InputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt"); // 1. ������ ����
			// 2. �����͸� ����(10byte�� �ݺ������� ����)
			byte[] bs = new byte[10];
			while (true) {
				int readByteCount = is.read(bs);
				if (readByteCount == -1)
					break; // ������ ���̸� break;
				for (int i = 0; i < readByteCount; i++) {
					System.out.print((char) bs[i]);
				}
			}
			System.out.println("\nDONE");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
