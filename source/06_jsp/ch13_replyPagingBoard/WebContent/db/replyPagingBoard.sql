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

SELECT * FROM BOARD;

-- 1. 글 갯수
SELECT COUNT(*) FROM BOARD;

-- 2. 글 목록(글 그룹이 최신인 글이 위로) -- ★ ★ ★ ★ ★
SELECT * FROM  BOARD ORDER BY REF DESC, RE_STEP ASC; 

-- 2-1. 글 목록(top-n) -- ★ ★ ★ ★ ★
SELECT ROWNUM RN, A.* FROM(SELECT * FROM  BOARD ORDER BY REF DESC, RE_STEP) A; -- 전 단계
SELECT * 
    FROM(SELECT ROWNUM RN, A.* FROM(SELECT * FROM  BOARD ORDER BY REF DESC, RE_STEP) A)
    WHERE RN BETWEEN 1 AND 10; -- 완성(DAO에 들어갈 SQL)

-- 3. 글 쓰기(원글쓰기) - 글쓴이, 글제목, 글본문, 이메일, PW
    -- 글 번호 생성
    SELECT NVL(MAX(NUM), 0)+1 FROM BOARD;
    
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '홍길동', '제목1', '본문', NULL, '111', (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '192.168.0.1');
    
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '지길동', '제목2', '본문', NULL, '111', (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '192.168.0.1');
    
-- 4. 글 번호로 글 상세보기 내용(DTO) 가져오기
SELECT * FROM BOARD WHERE NUM = 2;

-- 5. 조회수 올리기
UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM = 2;
    
-- 6. 글 수정 - 글쓴이 글제목, 글본문, 이메일, PW, IP
UPDATE BOARD SET SUBJECT = '수정된 제목1',
                 CONTENT = '수정된 본문\n방가',
                 EMAIL = 'hong@hong.com',
                 PW = '111',
                 IP = '127.0.0.1'
            WHERE NUM = 1;

-- 7. 글 삭제(비밀번호가 맞을 경우에만 삭제)
COMMIT;
DELETE FROM BOARD WHERE NUM = 1 AND PW = '111';
ROLLBACK;

-- 8. 답변글 추가

-- 답변글 달기
SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP ASC;

-- 최신 글 번호
SELECT MAX(NUM) FROM BOARD;

-- 223번(원글)
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP) 
    VALUES (223, '홍', '글2', '본문', NULL, '111', 223, 0, 0, '168.125.1.1');
    
-- 223번의 1번째 답변글 달기
SELECT * FROM BOARD WHERE REF = (SELECT REF FROM BOARD WHERE NUM = 222);

    -- 답변글 추가 전단계(엑셀의 A 단계 원글의 REF : 220 원글의 REF_STEP : 1) 
    UPDATE BOARD SET RE_STEP = RE_STEP + 1
        WHERE REF = 223 AND RE_STEP > 0;
        
    -- 답변글 INSERT (REF = 119, RE_STEP = 1, RE_INDENT = 1)
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP) 
    VALUES (224, '답녀', '글2-답1', '본문', 'R@R.COM', '111', 223, 1, 1, '168.125.1.1');  
    
-- 218번의 2번째 답변글 달기
      -- 답변글 추가 전단계(엑셀의 A 단계)
    UPDATE BOARD SET RE_STEP = RE_STEP + 1
        WHERE REF = 220 AND RE_STEP > 1; -- 8. 답변글 추가 전 단계 DAO
        
    -- 답변글 INSERT (REF = 119, RE_STEP = 1, RE_INDENT = 1)
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP) 
    VALUES ((SELECT NVL(MAX(NUM), 0) + 1 FROM BOARD), '이답투', '222글답', '본문', 'LEE@R.COM', 
            '111', 220, 2, 2, '168.125.1.1'); -- 9. 답변글 추가 DAO
    
SELECT * FROM  BOARD ORDER BY REF DESC, RE_STEP ASC;
UPDATE BOARD SET RE_STEP = 1 WHERE NUM = 224;
COMMIT;