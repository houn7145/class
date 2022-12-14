package com.lec.ex05_printWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex01 {
	public static void main(String[] args) {
		OutputStream os = null; // 기본스트림
		Writer writer = null; // 기본스트림
		PrintWriter printWriter = null; // 보조스트림
		try {
			// 1. PrintWriter : OutputStream의 보조스트림
//			os = new FileOutputStream("txtFile/outTest.txt", true);
//			printWriter = new PrintWriter(os); // OutputStream의 보조스트림
			// 2. printWriter : Write의 보조스트림
//			writer = new FileWriter("txtFile/outTest.txt", true);
//			printWriter = new PrintWriter(writer);
			// 3. PrintWriter를 기본스트림처럼 사용
			printWriter = new PrintWriter("txtFile/outTest.txt"); // append 불가
			System.out.println("안녕하세요\n반갑습니다"); // 콘솔창에 출력
			printWriter.println("안녕하세요\n반갑습니다"); // 파일에 출력
			System.out.print("print는 자동개행이 안됩니다 그래서 개행추가\n");
			printWriter.print("print는 자동개행이 안됩니다 그래서 개행추가\n");
			System.out.printf("%s %3d %3d %5.1f\n", "홍길동", 95, 94, 94.5);
			printWriter.printf("%s %3d %3d %5.1f\n", "홍길동", 95, 94, 94.5);
			System.out.printf("%s %3d %3d %5.1f\n", "신길동", 100, 99, 99.5);
			printWriter.printf("%s %3d %3d %5.1f\n", "신길동", 100, 99, 99.5);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (printWriter != null)
					;
				printWriter.close();
				if (os != null)
					os.close();
				if (writer != null)
					writer.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
