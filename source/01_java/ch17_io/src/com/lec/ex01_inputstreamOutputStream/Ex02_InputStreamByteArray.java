package com.lec.ex01_inputstreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//(1)스트림 객체 생성(파일을 열음) 
//(2)read메소드(1byte씩 읽음, 속도가 느림) 
//read(byte[])(byte배열의 length만큼 읽음)사용(데이터를 읽음) 
//(3)close메소드 사용(파일을 닫음)
public class Ex02_InputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt"); // 1. 파일을 열음
			// 2. 데이터를 읽음(10byte씩 반복적으로 읽음)
			byte[] bs = new byte[10];
			while (true) {
				int readByteCount = is.read(bs);
				if (readByteCount == -1)
					break; // 파일의 끝이면 break;
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
