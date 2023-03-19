--------------------------------
----------------- MEMBER
--------------------------------
-- 1. 회원가입
INSERT INTO MEMBER (MID, MPW, MNAME, MEMAIL, MGENDER, MBIRTH)
    VALUES ('AAA', '1', '홍', 'H@H.COM', '남', '1995-12-12');
    
-- 2. ID중복체크
SELECT * FROM MEMBER WHERE MID = 'AAA';

-- 3. 로그인 체크
SELECT * FROM MEMBER WHERE MID = 'AAA' AND MPW = '1';

-- 4. ID로 회원정보 가져오기
SELECT * FROM MEMBER WHERE MID = 'AAA';

-- 5. 회원정보 수정하기
UPDATE MEMBER SET MPW = '111',
                  MEMAIL = 'A@A.COM',
                  MTEL = '010-1111-1111',
                  MGENDER = '남',
                  MBIRTH = '1995-12-20'
    WHERE MID = 'AAA';
    
-- 6-1. 관리자모드에서 회원리스트 출력 - 페이징
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MEMBER ORDER BY MRDATE DESC) A)
    WHERE RN BETWEEN 2 AND 3;
    
-- 6-2. 페이징시 필요한 등록된 회원수
SELECT COUNT(*) FROM MEMBER;

-- 7-1. 내가 쓴 글 보기 (자유게시판) - 페이징 // 보류
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM FREEBOARD WHERE MID = 'BBB' ORDER BY FRDATE DESC)A)
    WHERE RN BETWEEN 1 AND 2;

-- 7-2. 페이징시 필요한 등록한 글 갯수 (자유게시판) // 보류
SELECT COUNT(*) FROM FREEBOARD WHERE MID = 'BBB';

-- 8-1. 내가 등록한 음식점 보기 - 페이징 // 보류
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM RESTAURANT WHERE MID = 'BBB' ORDER BY RRDATE DESC)A)
    WHERE RN BETWEEN 1 AND 2;

-- 8-2. 페이징시 필요한 등록한 음식점 갯수
SELECT COUNT(*) FROM RESTAURANT;

--------------------------------
----------------- ADMIN
--------------------------------
--1. ADMIN 로그인 체크
SELECT * FROM ADMIN WHERE AID = 'ADMIN' AND APW = '1';

--2. 관리자 로그인 후 세션에 넣을 용도 (DTO 가져오기)
SELECT * FROM  ADMIN WHERE AID = 'ADMIN';

--------------------------------
----------------- NOTICEBOARD
--------------------------------
--1. 공지게시판 글 등록
INSERT INTO NOTICEBOARD (NNO, AID, NTITLE, NCONTENT)
    VALUES (NOTICE_SEQ.NEXTVAL, 'ADMIN', '공지1', '본문');

--2.
