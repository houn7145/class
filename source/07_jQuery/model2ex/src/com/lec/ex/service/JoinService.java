package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class JoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getSession().getServletContext().getRealPath("memberPhotoUp");
		int maxSize = 1024 * 1024 * 5; // 최대 업로드 용량 : 5mb
		String mphoto = null; // 첨부파일이 서버에 저장된 파일 이름
		MultipartRequest mRequest = null;
		try {
			// 첨부된 파일을 서버에 저장하고 파일이름 가져오기
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mRequest.getFileNames();
			String param = paramNames.nextElement();
			mphoto = mRequest.getFilesystemName(param); // 첨부하여 서버에 저장된 파일 이름
			// mRequest를 이용하여 파라미터를 받아 db에 저장
			Date mbirth = null;
			String mid = mRequest.getParameter("mid");
			String mpw = mRequest.getParameter("mpw");
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			String birth = mRequest.getParameter("mbirth");
			String maddress = mRequest.getParameter("maddress");
			if (!birth.equals("")) {
				mbirth = Date.valueOf(birth);
			}
			mphoto = mphoto == null ? "NOIMG.JPG" : mphoto;
			MemberDao mDao = new MemberDao();
			int result = mDao.confirmId(mid);
			if (result == MemberDao.MEMBER_NONEEXISTENT) {
				MemberDto dto = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
				result = mDao.joinMember(dto);
				HttpSession session = request.getSession();
				session.setAttribute("mid", mid);
				request.setAttribute("joinResult", "회원가입이 완료되었습니다");
			} 
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// 서버에서 소스 폴더로 파일 복사
		if (mphoto != null && !mphoto.equals("NOIMG.JPG")) {
			InputStream is = null;
			OutputStream os = null;
			try {
				File serverFile = new File(path + "/" + mphoto);
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("C:/houn/source/07_jQuery/model2ex/WebContent/memberPhotoUp/" + mphoto);
				byte[] bs = new byte[(int) serverFile.length()];
				int readByteCnt;
				while ((readByteCnt = is.read(bs)) != -1) {
					os.write(bs, 0, readByteCnt);
				}
				System.out.println(mphoto + "복사완료");
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