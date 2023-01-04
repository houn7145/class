-- [XII] 트랜젝션 명령어 : COMMIT(트랜젝션 반영), ROLLBACK(트랜젝션 취소), SAVEPOINT(트랜젝션 분할)
SELECT * FROM DEPT01;
DROP TABLE DEPT01;
CREATE TABLE DEPT01 AS SELECT * FROM DEPT;
COMMIT;
-------------- 새로운 트랜젝션 시작
SELECT * FROM DEPT01; -- 10, 20, 30, 40
DELETE FROM DEPT01 WHERE DEPTNO = 20;
DELETE FROM DEPT01 WHERE DEPTNO = 30;
ROLLBACK;
-------------- 새로운 트랜젝션 시작
SELECT * FROM DEPT01; -- 10, 20, 30, 40
DELETE FROM DEPT01 WHERE DEPTNO = 40;
COMMIT;
-------------- 새로운 트랜젝션 시작
SELECT * FROM DEPT01; -- 10, 20, 30
DELETE FROM DEPT01 WHERE DEPTNO = 30;
SELECT * FROM DEPT01; -- 10, 20
SAVEPOINT C1; -- ※ C1 시점 : 10, 20
DELETE FROM DEPT01 WHERE DEPTNO = 20;
SELECT * FROM DEPT01; -- 10
SAVEPOINT C2; -- ※ C2 시점 : 10
DELETE FROM DEPT01 WHERE DEPTNO = 10;
SELECT * FROM DEPT01; -- 데이터 X
ROLLBACK TO C2;
SELECT * FROM DEPT01; -- 10 
ROLLBACK TO C1;
SELECT * FROM DEPT01; -- 10, 20
COMMIT;