---------------------------------------------
---------- MemberDao에 들어갈 query ----------
---------------------------------------------
-- 1-1. ID중복체크
SELECT * FROM MVC_MEMBER WHERE MID = 'aaa';

-- 1-2. EMAIL중복체크
SELECT * FROM MVC_MEMBER WHERE MEMAIL = 'h@h.com';
 
-- 2. JOIN
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES('bbb', '111', '김길동', 'h@h.com', 'gayun.jpg', '1995-07-02', '경기');

-- 3. LOGIN CHECK
SELECT * FROM MVC_MEMBER WHERE MID = 'aaa' AND MPW = '111';

-- 4. MID로 MEMBERDTO 가져오기
SELECT * FROM MVC_MEMBER WHERE MID = 'aaa';

-- 5. 회원정보 수정
UPDATE MVC_MEMBER SET MPW = '1',
                      MNAME = '송중기',
                      MEMAIL = 'SONG@S.COM',
                      MPHOTO = 'NOIMG.JPG',
                      MBIRTH = '1995-12-12',
                      MADDRESS = '서대문'
        WHERE MID = 'song';

-- 6. 회원 리스트(TOP-N)
SELECT * FROM MVC_MEMBER ORDER BY MRDATE DESC; -- 신규 가입 회원순
SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_MEMBER ORDER BY MRDATE DESC) A;
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_MEMBER ORDER BY MRDATE DESC) A)
    WHERE RN BETWEEN 4 AND 7;
    
-- 7. 전체 회원 수
SELECT COUNT(*) CNT FROM MVC_MEMBER;

-- 8. 회원 탈퇴
DELETE FROM MVC_MEMBER WHERE MID = 'bbb';

---------------------------------------------
---------- BoardDao에 들어갈 query ----------
---------------------------------------------
-- 1. 글목록(top-n)
SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP;
SELECT ROWNUM RN, A.* FROM (SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP) A;
SELECT * FROM(SELECT ROWNUM RN, A.* FROM (SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP) A)
    WHERE RN BETWEEN 2 AND 3;
    
-- 2. 전체 글 갯수
SELECT COUNT(*) FROM FILEBOARD;

-- 3. 글쓰기(원글)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'go', '제목', '본문', 'NOIMG.JPG', FILEBOARD_SEQ.CURRVAL, 0, 0, '192.1.1.1');

-- 4. 조회수 1 올리기
UPDATE FILEBOARD SET FHIT = FHIT + 1
    WHERE FID = 1;

-- 5. 글번호(fID)로 글전체 내용(BoardDao) 가져오기
SELECT * FROM FILEBOARD WHERE FID = 1;

-- 6. 글 수정(fid, ftitle, fcontent, ffilename, frdate(수정일 - sysdate), fip 수정)
UPDATE FILEBOARD SET FTITLE = '수정된 제목',
                     FCONTENT = '수정된 본문',
                     FFILENAME = '100.JPG',
                     FRDATE = SYSDATE,
                     FIP = '192.1.1.0'
    WHERE FID = '1';
                     
-- 7. 글 삭제(fid로)
DELETE FROM FILEBOARD WHERE FID = 4;

-- 8. 답변글 쓰기 선행 단계(원글의 fgroup과 같고 원글의 fstep보다 크면 fstep을 1 증가)
UPDATE FILEBOARD SET FSTEP = FSTEP + 1
    WHERE FGROUP = 2 AND FSTEP > 0;
    
-- 9. 답변글 쓰기
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'jang', '답글', '본문', 'NOIMG.JPG', 2, 1, 1, '192.1.1.3');

-- 10. 회원탈퇴시 탈퇴하는 회원의 mid로 작성한 글 전부 삭제 -- void
DELETE FROM FILEBOARD WHERE MID = 'aaa';

---------------------------------------------
---------- AdminDao 들어갈 query ----------
---------------------------------------------
-- 1. admin LOGIN CHECK
SELECT * FROM ADMIN WHERE AID = 'admin' AND APW = '1';

-- 2. 로그인 후 세션에 넣을 용도 admin aid로 AdminDto 가져오기
SELECT * FROM ADMIN WHERE AID = 'admin';

commit;