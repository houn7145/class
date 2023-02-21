--TABLE DROP & CREATE
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    ID VARCHAR2(30) PRIMARY KEY,
    PW VARCHAR2(30) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    PHONE1 VARCHAR2(5),
    PHONE2 VARCHAR2(5),
    PHONE3 VARCHAR2(5),
    GENDER VARCHAR2(1),
    EMAIL VARCHAR2(30),
    BIRTH DATE,
    ADDRESS VARCHAR2(200),
    RDATE DATE NOT NULL -- ������
);
SELECT* FROM MEMBER;
-- 1. ȸ�����Խ� ID �ߺ�üũ : public int confirmId(String id)
SELECT * FROM MEMBER WHERE ID = 'aaa';
-- SELECT COUNT(*) FROM MEMBER WHERE ID = 'AAA';

-- 2. ȸ������ : public int joinMember(MemberDto dto)
INSERT INTO MEMBER 
        (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, ADDRESS, RDATE)
    VALUES
        ('aaa', '111', '��浿', '02', '715', '7777', 'm', 'hong@hong.com', '1995-12-12', '����', SYSDATE);
commit; 
-- 3. �α��� : public int loginCheck(String id, String pw)
SELECT * FROM MEMBER WHERE ID = 'aaa';
SELECT * FROM MEMBER WHERE PW = '111';

-- 4. ID�� dto�������� : �α��� ������ session�� setAttribute / ȸ������ ������ ȸ������ �������� 
--                   : public MemberDto getMember(String id)
SELECT * FROM MEMBER WHERE ID = 'aaa';

-- 5. ȸ���������� : public int modifyMember(MemberDto dto)
UPDATE MEMBER SET PW = '111',
                  NAME = 'ȫ�浿',
                  PHONE1 = '031',
                  PHONE2 = '777',
                  PHONE3 = '1234',
                  GENDER = 'm',
                  EMAIL = 'kil@hong.com',
                  BIRTH = '1995-12-12',
                  ADDRESS = '��⵵ �Ⱦ�'
        WHERE ID = 'bbb';
COMMIT;