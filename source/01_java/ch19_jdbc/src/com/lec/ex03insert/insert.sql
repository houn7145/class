-- ex1
INSERT INTO DEPT VALUES (60, 'IT', 'SEOUL');
COMMIT;
SELECT * FROM DEPT;
-- ex2 �ߺ� üũ
SELECT * FROM DEPT WHERE DEPTNO = 50;
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO = 30;
INSERT INTO DEPT VALUES (60, 'IT', 'SEOUL');

-- update
UPDATE DEPT SET DNAME = 'MARKETING', LOC = 'INCHON' WHERE DEPTNO = 70;
SELECT CNT FROM  DEPT WHERE DEPTNO = 30;

-- delete
DELETE FROM DEPT WHERE DEPTNO = 99;
rollback;