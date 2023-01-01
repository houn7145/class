DROP TABLE MAJOR;
DROP TABLE STUDENT;

CREATE TABLE MAJOR (
    MAJOR_CODE NUMBER(3) PRIMARY KEY,
    MAJOR_NAME VARCHAR2(50),
    MAJOR_OFFICE_LOC VARCHAR2(50)
);

CREATE TABLE STUDENT (
    STUDENT_CODE NUMBER(10) PRIMARY KEY,
    STUDENT_NAME VARCHAR2(50),
    SCORE        NUMBER(3) CHECK (0 <= SCORE AND SCORE <= 100),
    MAJOR_CODE   NUMBER(2) REFERENCES MAJOR(MAJOR_CODE)
);

INSERT INTO MAJOR VALUES (1, '컴퓨터공학', 'A101호');
INSERT INTO MAJOR VALUES (2, '빅데이터', 'A102호');

SELECT * FROM MAJOR;

INSERT INTO STUDENT VALUES (101, '홍길동', 99, 1);
INSERT INTO STUDENT VALUES (102, '신길동', 100, 2);

SELECT * FROM STUDENT;

SELECT STUDENT_CODE 학번, STUDENT_NAME 이름, SCORE 점수, S.MAJOR_CODE 학과코드, MAJOR_NAME 학과명, MAJOR_OFFICE_LOC 학과사무실
    FROM MAJOR M, STUDENT S
    WHERE M.MAJOR_CODE = S.MAJOR_CODE;