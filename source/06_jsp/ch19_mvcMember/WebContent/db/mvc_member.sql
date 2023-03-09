DROP TABLE MVC_MEMBER;
CREATE TABLE MVC_MEMBER(
    MID VARCHAR2(30) PRIMARY KEY,
    MPW VARCHAR2(30) NOT NULL,
    MNAME VARCHAR2(30) NOT NULL,
    MEMAIL VARCHAR2(30),
    MPHOTO VARCHAR2(30) DEFAULT 'NOIMG.JPG',
    MBIRTH DATE,
    MADDRESS VARCHAR2(300),
    MRDATE DATE DEFAULT SYSDATE NOT NULL
);
-- DUMMY DATA
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES('aaa', '111', '홍길동', 'hong@h.com', 'NOIMG.JPG', '1988-12-12', '서울');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES('bbb', '111', '김길동', 'h@h.com', 'gayun.jpg', '1995-07-02', '경기');

-- DAO에 들어갈 QUERY

-- 1. ID중복체크
SELECT * FROM MVC_MEMBER WHERE MID = 'zzz';

-- 2. JOIN
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES('bbb', '111', '김길동', 'h@h.com', 'gayun.jpg', '1995-07-02', '경기');

-- 3. LOGIN CHECK
SELECT * FROM MVC_MEMBER WHERE MID = 'aaa' AND MPW = '111';

-- 4. MID로 MEMBERDTO 가져오기
SELECT * FROM MVC_MEMBER WHERE MID = 'aaa';
commit;