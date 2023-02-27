-- 고객(CUSTOMER)테이블 dummy data - 6개(aaa~fff)

INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH) 
    VALUES ('aaa', '111', '홍길동', '010-9999-9999', 'a@a.com', '서울시 서대문구', 'm', '1995-12-12');
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH) 
    VALUES ('bbb', '111', '마길동', '010-8888-9999', null, '서울시 강남구', 'm', '1995-12-12');
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH) 
    VALUES ('ccc', '111', '김길동', '010-7777-9999', 'c@c.com', '서울시 서대문구', 'm', '1995-12-12');
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH) 
    VALUES ('ddd', '111', '이길동', '010-6666-9999', null, '서울시 서대문구', 'm', '1995-12-12');
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH) 
    VALUES ('eee', '111', '신길동', '010-5555-9999', 'e@e.com', '서울시 서대문구', 'm', '1995-12-12');
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH) 
    VALUES ('fff', '111', '강길동', '010-4444-9999', null, '서울시 서대문구', 'm', '1995-12-12');


-- 파일첨부 게시판(FileBoard)테이블 dummy data - 3개(글1, 글2, 글2-1) : 한개는 첨부파일 1.docx이 있는 걸로
INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRE_STEP, FRE_LEVEL, FIP) 
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '글1', '글1내용', '1.docx', '111', FILEBOARD_SEQ.CURRVAL, 0, 0, '162.0.0.1');
INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FPW, FREF, FRE_STEP, FRE_LEVEL, FIP) 
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'bbb', '글2', '글2내용', '111', FILEBOARD_SEQ.CURRVAL, 0, 0, '162.0.0.1');
INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FPW, FREF, FRE_STEP, FRE_LEVEL, FIP) 
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'ccc', '글2답글', '답글내용', '111', 2, 1, 1, '162.0.0.1');

-- 도서(BOOK)테이블 dummy data  - 15개
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '내일의 부',16000,'100.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '3층 서기실의 암호',20000,'101.jpg','noImg.png','태영호 증언',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '당신이 글을 쓰면 좋겠습니다',14000,'102.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '울트라러닝',16000,'103.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '내가 왔다',11500,'104.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '나의 서툰 위로가 너에게 닿기를',13000,'105.jpg','noImg.png','좋아',30);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '아직 멀었다는 말',13500,'106.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '소금 지방 산열',33000,'107.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '디레버리징',20000,'108.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '너와 나의 암호말',18000,'109.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '오늘도 펭수, 내일도 펭수',17000,'110.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '지적대화를 위한 넓고 얕은 지식2',1600,'111.jpg','noImg.png','좋아',30);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '트렌드코리아 2020',2000,'112.jpg','noImg.png','2020 트렌드 키워드 ',15);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '여행의 이유',1800,'113.jpg','noImg.png','김영하의 여행 경험',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '작은 아씨들',2000,'114.jpg','noImg.png','좋다 ',10);

SELECT * FROM CUSTOMER;
SELECT * FROM FILEBOARD;
SELECT * FROM BOOK;

COMMIT;