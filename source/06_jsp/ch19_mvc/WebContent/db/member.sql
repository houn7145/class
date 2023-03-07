-- drop table 
DROP TABLE MEMBER;
-- create table
CREATE TABLE MEMBER(
    ID VARCHAR2(30) PRIMARY KEY,
    PW VARCHAR2(30) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    BIRTH DATE,
    RDATE DATE DEFAULT SYSDATE NOT NULL
);

-- dummy data
INSERT INTO MEMBER (ID, PW, NAME, BIRTH)
    VALUES ('aaa', '1', 'ȫ�浿', TO_DATE('1995-12-12', 'YYYY-MM-DD'));
    
-- dao�� �ʿ��� query
-- 1. ȸ�� ����Ʈ
SELECT * FROM MEMBER;
-- 2. ȸ������
INSERT INTO MEMBER (ID, PW, NAME, BIRTH)
    VALUES ('bbb', '1', '��浿', '1998-12-05');
    
COMMIT;

