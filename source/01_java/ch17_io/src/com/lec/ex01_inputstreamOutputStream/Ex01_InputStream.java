package com.lec.ex01_inputstreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// (1)스트림 객체 생성(파일을 열음) (2)read메소드 사용(데이터를 읽음) (3)close메소드 사용(파일을 닫음)
public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt"); // 1. 파일을 열음
			// 2. 데이터를 읽음(파일 끝까지 1byte씩만 읽음)
			while (true) {
				int i = is.read(); // 1byte씩 읽음
				if (i == -1)
					break; // 파일의 끝이면 break;
				System.out.print((char) i + "(" + i + ")");
			}
			System.out.println("\nDONE");
		} catch (FileNotFoundException e) {
			System.out.println("예외 메세지 : 파일을 못 찾음 " + e.getMessage());
		} catch (IOException e) {
			System.out.println("예외 메세지 : 파일을 못 읽음 " + e.getMessage());
		} finally {
			// 3. 파일을 닫음
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
