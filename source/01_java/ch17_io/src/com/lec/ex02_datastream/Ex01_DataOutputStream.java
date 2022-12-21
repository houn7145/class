package com.lec.ex02_datastream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// outputStream을 보조 (조금 발전된 스트림)
public class Ex01_DataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null; // 기존 스트림
		DataOutputStream dos = null; // 보조 스트림
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat");
			dos = new DataOutputStream(fos);
			dos.writeUTF("홍길동"); // String 저장
			dos.writeInt(2); // int 저장
			dos.writeDouble(95.5); // double 저장

			dos.writeUTF("마길동"); // String 저장
			dos.writeInt(6); // int 저장
			dos.writeDouble(97.2); // double 저장
			System.out.println("파일 저장 완료");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null)
					dos.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
