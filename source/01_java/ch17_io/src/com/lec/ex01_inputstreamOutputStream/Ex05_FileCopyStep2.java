package com.lec.ex01_inputstreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// C:\houn\note\bts_mp4 -> C:\houn\note\bts_copy.mp4
public class Ex05_FileCopyStep2 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // 1970.1.1 ~ 시작 시점까지의 밀리세컨
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("C:\\houn\\note\\bts.mp4"); // 1. 스트림 객체 생성
			os = new FileOutputStream("C:\\houn\\note\\bts_copy(1024).mp4");
			byte[] bs = new byte[1024]; // 1킬로바이트
			int cnt = 0;
			while(true) {  // 8,075,033byte라 7,887번 실행
				cnt++;
				int Count = is.read(bs); // 2. read(bs에 읽음) & write : 
				if(Count == -1)
					break;
				os.write(bs, 0, Count); // bs배열을 0번 index부터 Count 바이트만큼 write
			}
			System.out.println(cnt + "번 while문 실행하여 복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(os!=null) os.close(); // 3. 파일 닫기(스트림 해제)
				if(is!=null) is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} 
		}
		long end = System.currentTimeMillis(); // 1970.1.1 ~ 끝나는 시점까지의 밀리세컨
		System.out.println(end-start);
	}
}
