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
import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getSession().getServletContext().getRealPath("memberPhotoUp");		
		int maxSize = 1024 * 1024 * 5;
		String ffileName = null, dbFfileName = null; // 첨부파일 이름이 저장될 변수
		int result = MemberDao.FAIL;
		MultipartRequest mRequest = null;
		try {
			// 첨부된 파일을 서버에 저장하고 파일이름 가져오기
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mRequest.getFileNames();
			String param = paramNames.nextElement();
			ffileName = mRequest.getFilesystemName(param); // 첨부하여 서버에 저장된 파일 이름
			dbFfileName = mRequest.getParameter("dbFfileName");
			if(ffileName == null) {
				ffileName = dbFfileName;
			}
			String ftitle = mRequest.getParameter("ftitle");
			String fcontent = mRequest.getParameter("fcontent");
			String fip = request.getRemoteAddr();
			int fid = Integer.parseInt(mRequest.getParameter("fid"));
			BoardDao bDao = new BoardDao();
			BoardDto bDto = new BoardDto(fid, null, null, ftitle, fcontent, dbFfileName, null, 0, 0, 0, 0, fip);
			result = bDao.modifyBoard(bDto);
			if(result == BoardDao.SUCCESS) {
				request.setAttribute("modifyResult", "글 수정 완료");
			}else {
				request.setAttribute("modifyResult", "글 수정 실패");
			}
			request.setAttribute("pageNum", mRequest.getParameter("pageNum"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		if(dbFfileName !=null && !ffileName.equals(dbFfileName)) { 
			InputStream  is = null;
			OutputStream os = null;
			try {
				File serverFile = new File(path+"/"+ffileName);
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("C:/houn/source/07_jQuery/model2ex/WebContent/fileBoardUp/"+ffileName);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true) {
					int nByteCnt = is.read(bs);
					if(nByteCnt==-1) break;
					os.write(bs, 0, nByteCnt);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} 
		}
	}
}
