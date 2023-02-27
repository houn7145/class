-- CustomerDao(ID중복체크, 회원가입, 로그인, pk로 dto 가져오기 - 상세보기, 정보수정, 리스트(top-n), 등록된 회원수)
-- 1. ID중복체크 public int confirmId(String cid)
SELECT * FROM CUSTOMER WHERE CID = 'aaa';

-- 2. 회원가입 public int joinCustomer(CustomerDto dto)
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH) 
    VALUES ('aaa', '111', '홍길동', '010-9999-9999', 'a@a.com', '서울시 서대문구', 'm', '1995-12-12');
    
-- 3. 로그인 public int loginCheck(String cid, String cpw)
SELECT * FROM CUSTOMER WHERE CID='aaa' AND CPW='111';

-- 4. pk로 dto 가져오기 (상세보기) public CustomerDto getCustomer(String cid)
SELECT * FROM CUSTOMER WHERE CID = 'aaa';

-- 5. 정보수정 public int modifyCustomer(CustomerDto dto)
UPDATE CUSTOMER SET CPW = '111',
                    CNAME = '진길동',
                    CTEL = '010-9955-9955',
                    CEMAIL = 'A@A.COM',
                    CADDRESS = '인천',
                    CGENDER = 'f',
                    CBIRTH = '1995-12-10'
        WHERE CID = 'aaa';
        
-- 6. 리스트
SELECT * FROM CUSTOMER ORDER BY CRDATE;
SELECT ROWNUM RN, A.* FROM(SELECT * FROM CUSTOMER ORDER BY CRDATE) A;

SELECT * FROM (SELECT ROWNUM RN, A.* FROM(SELECT * FROM CUSTOMER ORDER BY CRDATE DESC) A)
    WHERE RN BETWEEN 1 AND 3;

-- 7. 등록된 회원수
SELECT COUNT(*) FROM CUSTOMER;

-- FileboardDao(리스트(top-n), 글 갯수, 글쓰기(원글 쿼리 1개, 답변 쿼리 2개), hit 올리기, pk로 dto 가져오기 - 글 상세보기, 글수정, 글삭제) 
-- 1. 리스트
SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C WHERE F.CID = C.CID ORDER BY FREF DESC, FRE_STEP;
SELECT ROWNUM RN, A.* FROM (SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C WHERE F.CID = C.CID ORDER BY FREF DESC, FRE_STEP) A;

SELECT * FROM(SELECT ROWNUM RN, A.* FROM (SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C WHERE F.CID = C.CID ORDER BY FREF DESC, FRE_STEP) A)
    WHERE RN BETWEEN 2 AND 3;

-- 2. 글 갯수
SELECT COUNT(*) FROM FILEBOARD;

-- 3. 글쓰기
SELECT * FROM FILEBOARD;
    -- 원글
INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRE_STEP, FRE_LEVEL, FIP) 
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '글1', '글1내용', '1.docx', '111', FILEBOARD_SEQ.CURRVAL, 0, 0, '162.0.0.1');
    -- 답변글 선행
    UPDATE FILEBOARD SET fRE_STEP = fRE_STEP + 1
        WHERE fREF = 2 AND fRE_STEP > 0;
    -- 답변글
INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FPW, FREF, FRE_STEP, FRE_LEVEL, FIP) 
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'ccc', '글2답글', '답글내용', '111', 2, 1, 1, '162.0.0.1');

-- 4. 조회수 올리기
UPDATE FILEBOARD SET FHIT = FHIT + 1 WHERE FNUM = '4';

-- 5. pk로 dto 가져오기 
SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C WHERE F.CID=C.CID AND FNUM=4;

-- 6. 글 수정
UPDATE FILEBOARD SET FSUBJECT = '수정된 제목',
                     FCONTENT = '수정된 본문',
                     FFILENAME = '100.jpg',
                     FPW = '111',
                     FIP = '192.0.0.1'
                WHERE FNUM = '1';

-- 7. 글 삭제
DELETE FROM FILEBOARD WHERE FNUM = '1' AND FPW = '111';

-- BookDao(리스트(top-n), 책 갯수, 책등록, pk로 dto 가져오기 - 책 상세보기)
-- 1. 리스트
SELECT * FROM BOOK ORDER BY BID DESC;
SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BID DESC) A;

SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BID DESC) A)
    WHERE RN BETWEEN 1 AND 3;

-- 2. 책 갯수
SELECT COUNT(*) FROM BOOK;

-- 3. 책 등록 
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '내일의 부',16000,'100.jpg','noImg.png','좋아',10);
    
-- 4. pk로 dto 가져오기
SELECT * FROM BOOK WHERE BID = '1';