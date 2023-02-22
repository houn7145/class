-- BOARD TABLE DROP & CREATE
DROP TABLE BOARD;
CREATE TABLE BOARD(
    NUM NUMBER(5,0) PRIMARY KEY,      -- 글 번호
    WRITER VARCHAR2(30) NOT NULL,     -- 글쓴이
    SUBJECT VARCHAR2(100) NOT NULL,   -- 글 제목
    CONTENT VARCHAR2(4000) NOT NULL,  -- 글 본문
    EMAIL VARCHAR2(30),               -- 이메일
    READCOUNT NUMBER(5) DEFAULT 0,    -- 조회수
    PW VARCHAR2(30) NOT NULL,         -- 비밀번호
    REF NUMBER(5,0) NOT NULL,         -- 글 그룹(원글의 경우 글번호로/답변글일 경우 원글의 REF로)
    RE_STEP NUMBER(3) NOT NULL,       -- 글 그룹내 출력 순서(원글 0)
    RE_INDENT NUMBER(3) NOT NULL,     -- 글 LIST 출력시 글 제목의 들여쓰기 정도(원글 0)
    IP VARCHAR2(30) NOT NULL,         -- IP
    RDATE DATE DEFAULT SYSDATE        -- 글쓴 시점(날짜+시간)
);
--1. 글 갯수
SELECT COUNT(*) FROM BOARD;

--2. 글 목록
SELECT * FROM BOARD ORDER BY REF DESC;

--2-1. 글 목록 topN
SELECT * FROM BOARD ORDER BY REF DESC; -- 1단계

SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY REF DESC) A; -- 2단계

SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY REF DESC) A)
    WHERE RN BETWEEN 11 AND 20; -- 3단계

--3. 글 쓰기
    -- 글 번호 생성
    SELECT NVL(MAX(NUM), 0)+1 FROM BOARD;

INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW , REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '홍길동', '제목', '본문', NULL, '111', (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '192.168.0.1');
    
--4. 글 번호로 상세내용 가져오기
SELECT * FROM BOARD WHERE NUM = '2';

--5. 조회수 올리기
UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM = '1';

--6. 글 수정
UPDATE BOARD SET SUBJECT = '바뀐 제목',
                 CONTENT = '바뀐 본문',
                 EMAIL = 'hong@h.com',
                 PW = '111',
                 IP = '127.0.0.1'
        WHERE NUM = '1';

--7. 글 삭제
DELETE FROM BOARD WHERE NUM = '3' AND PW = '111';

COMMIT;
