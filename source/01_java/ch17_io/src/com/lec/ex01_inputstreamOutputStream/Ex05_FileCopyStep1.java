package com.lec.ex01_inputstreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// C:\houn\note\bts_mp4 -> C:\houn\note\bts_copy.mp4
public class Ex05_FileCopyStep1 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // 1970.1.1 ~ ���� ���������� �и�����
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("C:\\houn\\note\\bts.mp4"); // 1. ��Ʈ�� ��ü ����
			os = new FileOutputStream("C:\\houn\\note\\bts_copy.mp4");
			int cnt = 0;
			while (true) { // 8,075,033byte�� 8,075,033�� ����
				cnt++;
				int i = is.read(); // 2. read & write
				if (i == -1)
					break;
				os.write(i);
				if (cnt % 100000 == 0) {
					System.out.println(cnt + "/8,075,033 : " + (int) (cnt / 8075033.0 * 100) + "% �ϼ�");
				}
			}
			System.out.println(cnt + "�� while�� �����Ͽ� ���� ����");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close(); // 3. ���� �ݱ�(��Ʈ�� ����)
				if (is != null)
					is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		long end = System.currentTimeMillis(); // 1970.1.1 ~ ������ ���������� �и�����
		System.out.println(end - start);
	}
}
