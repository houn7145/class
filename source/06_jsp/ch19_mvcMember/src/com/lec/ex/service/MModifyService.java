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

public class MModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getSession().getServletContext().getRealPath("memberPhotoUp");		
		int maxSize = 1024 * 1024 * 5;
		String mphoto = null; // 첨부파일 이름이 저장될 변수
		int result = MemberDao.FAIL;
		try {
			// mRequest 객체 생성(서버에 업로드딘 파일 저장) 후 파일 이름 받아오기 
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			// while(params.hasMoreElements()) {
				String param = params.nextElement(); // param이 "mphoto"
				mphoto = mRequest.getFilesystemName(param);
			// }
			// 파라미터를 받아서 db에 저장
			String dbMpw = mRequest.getParameter("dbMpw");
			String dbMphoto = mRequest.getParameter("dbMphoto");
			// hidden으로 넘어온 dbMpw, dbMphoto가 없을 경우
			// HttpSession session = request.getSession();
			// String sessionMpw = null, sessionMphoto = null;
			// MemberDto sessionMember = (MemberDto)session.getAttribute("member");
			// if(member != null) {
			//	sessionMpw = member.getMpw();
			// 	sessionMphoto = member.getMphoto();
			// }
			String mid = mRequest.getParameter("mid");
			String oldMpw = mRequest.getParameter("oldMpw");
			if(!oldMpw.equals(dbMpw)) {
				request.setAttribute("modifyErrorMsg", "현 비밀번호를 확인하세요");
				return;
			}
			String mpw = mRequest.getParameter("mpw");
			if(mpw.equals("")) { // 새 비밀번호를 입력하지 않았을 경우 현 비밀번호로 교체
				mpw = dbMpw;
			}
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			// 사진첨부를 안했을 경우 기존 사진으로
			mphoto = mphoto == null ? dbMphoto : mphoto;
			String mbirthStr = mRequest.getParameter("mbirth");
			Date mbirth = null;
			if(!mbirthStr.equals("")) {
				mbirth = Date.valueOf(mbirthStr);
			}
			String maddress = mRequest.getParameter("maddress");
			// 회원정보 수정
			MemberDao mDao = new MemberDao();
			MemberDto member = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
			result = mDao.modifyMember(member);
			if(result == MemberDao.SUCCESS) { // 수정 성공시 session도 수정
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				request.setAttribute("modifyResult", "회원정보 수정 성공");
			}else { // 수정 실패
				request.setAttribute("modifyErrorMsg", "회원정보 수정 실패");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// 서버에 저장된 파일을 소스 폴더로 복사(파일명이 NOIMG.JPG거나 result가 FAIL이 아닐 경우)
		File serverFile = new File(path + "/" + mphoto);
		if(!mphoto.equals("NOIMG.JPG") && result == MemberDao.SUCCESS) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("C:/houn/source/06_jsp/ch19_mvcMember/WebContent/memberPhotoUp/" + mphoto);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true) {
					int readByteCnt = is.read(bs);
					if(readByteCnt == -1) break;
					os.write(bs, 0, readByteCnt);
				}
				System.out.println("첨부된 파일 ("+ mphoto +") 복사완료");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}finally {
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
