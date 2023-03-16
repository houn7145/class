package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;
import com.lec.ex.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getSession().getServletContext().getRealPath("memberPhotoUp");
		int maxSize = 1024 * 1024 * 5; // 최대 업로드 용량 : 5mb
		String ffileName = null; // 첨부파일이 서버에 저장된 파일 이름
		MultipartRequest mRequest = null;
		try {
			// 첨부된 파일을 서버에 저장하고 파일이름 가져오기
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mRequest.getFileNames();
			String param = paramNames.nextElement();
			ffileName = mRequest.getFilesystemName(param); // 첨부하여 서버에 저장된 파일 이름
			String mname = mRequest.getParameter("mname");
			String ftitle = mRequest.getParameter("ftitle");
			String fcontent = mRequest.getParameter("fcontent");
			String fip = request.getRemoteAddr();
			String mid = mRequest.getParameter("mid");
			BoardDao bDao = new BoardDao();
			BoardDto bDto = new BoardDto(0, mid, mname, ftitle, fcontent, ffileName, null, 0, 0, 0, 0, fip);
			int result = bDao.writeBoard(bDto);
			if(result == BoardDao.SUCCESS) {
				request.setAttribute("boardResult", "글쓰기 완료");
			}else {
				request.setAttribute("boardResult", "글쓰기 실패");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		if (ffileName != null) {
			InputStream is = null;
			OutputStream os = null;
			try {
				File serverFile = new File(path + "/" + ffileName);
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("C:/houn/source/07_jQuery/model2ex/WebContent/fileBoardUp/" + ffileName);
				byte[] bs = new byte[(int) serverFile.length()];
				int readByteCnt;
				while ((readByteCnt = is.read(bs)) != -1) {
					os.write(bs, 0, readByteCnt);
				}
				System.out.println(ffileName + "복사완료");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(os != null) os.close();
					if(is != null) is.close();
				}catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
