-- [ VI ] Sub Query : ���� QUERY(SQL��) �ȿ� QUERY(SQL��)�� ����

-- �� 1. �������� ����
    -- ex. �޿��� ���� ���� �޴� ����� �̸��� �޿�
SELECT ENAME, MAX(SAL) FROM EMP; -- ����
SELECT ENAME, MAX(SAL) FROM EMP GROUP BY ENAME; -- �� ����
SELECT MAX(SAL) FROM EMP; -- ��������
SELECT ENAME, SAL 
    FROM EMP
    WHERE SAL = (SELECT MAX(SAL) FROM EMP); -- ��������
    
-- ���������� ����(1) ������ ��������(���������� �������� ������) : = > >= < <= !=
    -- ex. SCOTT�� �ٹ��ϴ� �μ��̸� ���
SELECT DEPTNO 
    FROM EMP 
    WHERE ENAME = 'SCOTT'; -- ��������
SELECT DNAME 
    FROM DEPT 
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'); -- ��������
SELECT DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'SCOTT'; -- JOIN �̿�
    
-- ���������� ����(2) ������ ��������(���������� �������� 2���̻�) : IN, >(ALL, ANY(SOME)),EXISTS
    -- ex. JOB�� MANAGER�� ����� �μ��̸� ���
SELECT DEPTNO 
    FROM EMP 
    WHERE JOB = 'MANAGER'; -- �������� ����� 2���̻�
SELECT DNAME
    FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER'); -- ��������

-- �� 2. ������ ��������
    -- ex1. SCOTT�� ������ �μ���ȣ���� �ٹ��ϴ� ����� �̸��� �޿� ���
SELECT DEPTNO 
    FROM EMP 
    WHERE ENAME = 'SCOTT'; -- ��������
SELECT ENAME, SAL 
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT') 
        AND ENAME <> 'SCOTT'; -- ��������
    -- ex2. SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� �̸��� �޿� ���
-- ������ �߰� (DALLAS 50�� �μ��� HONG ���)
INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (9999, 'HONG', 50);

SELECT LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'SCOTT'; -- ��������
SELECT ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
        AND LOC = (SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'SCOTT')
            AND ENAME != 'SCOTT'; -- ��������
ROLLBACK; -- DML ��ɾ� ���

    -- ex3. �����Ի��ϰ� �����Ի��ڸ� ���
SELECT MIN(HIREDATE) 
    FROM EMP; -- ������ ��������
SELECT HIREDATE, ENAME
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP); -- ��������
    
    -- ex4. �ֱ��Ի��ϰ� �ֱ��Ի��ڸ� ���
SELECT MAX(HIREDATE) 
    FROM EMP; -- ��������
SELECT HIREDATE, ENAME
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP); -- ��������
    
    -- ex5. �����Ի���, �����Ի���, �ֱ��Ի���, �ֱ��Ի��� ���
SELECT E1.HIREDATE, E1.ENAME, E2.HIREDATE, E2.ENAME
    FROM EMP E1, EMP E2
    WHERE E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP)
        AND E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP); -- ��������
SELECT 
    (SELECT MIN(HIREDATE) FROM EMP) FIRSTDAY,
    (SELECT ENAME FROM EMP WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP)) FIRSTMAN,
    (SELECT MAX(HIREDATE) FROM EMP) LASTDAY,
    (SELECT ENAME FROM EMP WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP)) LASTMAN
    FROM DUAL;
    
    -- ex6. SCOTT�� ���� �μ��� �ٹ��ϴ� ������� �޿���
SELECT DEPTNO 
    FROM EMP 
    WHERE ENAME = 'SCOTT'; -- ��������
SELECT SUM(SAL) 
    FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP 
    WHERE ENAME = 'SCOTT'); -- ��������
    
    -- ex7. SCOTT�� ������ JOB�� ���� ����� ��� �ʵ�
SELECT JOB 
    FROM EMP 
    WHERE ENAME = 'SCOTT'; -- ��������
SELECT * 
    FROM EMP 
    WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'SCOTT'); -- ��������
    
    -- ex8. DALLAS���� �ٹ��ϴ� ����� �̸��� �μ���ȣ
SELECT DEPTNO 
    FROM DEPT 
    WHERE LOC = 'DALLAS'; -- ��������
SELECT ENAME, DEPTNO 
    FROM EMP 
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS'); -- ��������
    
    -- ex9. KING�� ���ӻ���� ����� �̸��� �޿� ���
SELECT EMPNO 
    FROM EMP 
    WHERE ENAME = 'KING'; -- ��������
SELECT ENAME, SAL 
    FROM EMP 
    WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING'); -- ��������
    
    -- ex10. ��ձ޿� ���Ϸ� �޴� ����� �̸��� �޿� ���
SELECT AVG(SAL) 
    FROM EMP; -- ��������
SELECT ENAME, SAL 
    FROM EMP
    WHERE SAL <= (SELECT AVG(SAL) FROM EMP); -- ��������
    
    -- ex11. ��ձ޿� ���Ϸ� �޴� ����� �̸��� �޿�, ��ձ޿� ���
SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP)) AVG_SAL
    FROM EMP
    WHERE SAL <= (SELECT AVG(SAL) FROM EMP);

    -- ex12. ��ձ޿� ���Ϸ� �޴� ����� �̸��� �޿�, ��ձ޿����� ���� ���
SELECT ENAME, SAL, ABS(ROUND((SELECT AVG(SAL) FROM EMP)) - SAL) DIFF
    FROM EMP
    WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
    
-- ������ ���߿� ��������
    -- ex. SCOTT�� JOB�� �μ���ȣ�� ���� ������ ��� �ʵ� ���
SELECT JOB, DEPTNO 
    FROM EMP 
    WHERE ENAME = 'SCOTT'; -- ������ ���߿� ��������
SELECT * 
    FROM EMP
    WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP WHERE ENAME = 'SCOTT')
        AND ENAME != 'SCOTT'; -- ��������
        
-- �� 3. ������ �������� : IN, (ALL, ANY=SOME), EXISTS
-- (1) IN : �������� ��� �� �ϳ��� ��ġ�ϸ� ��
    -- ex1. �μ��� �Ի����� ���� ���� ����� �̸�, �Ի���, �μ���ȣ ���
SELECT DEPTNO, MAX(HIREDATE) 
    FROM EMP 
    GROUP BY DEPTNO; -- ������ ���߿� ��������
SELECT ENAME, HIREDATE, DEPTNO
    FROM EMP
    WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO); -- ��������
    
    -- ex2. �޿��� 3000�̻� �޴� ����� �Ҽӵ� �μ��� ������� ��� �ʵ� ���
SELECT DEPTNO 
    FROM EMP 
    WHERE SAL >= 3000; -- ������ ���Ͽ� ��������
SELECT * 
    FROM EMP 
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL >= 3000); -- ��������

-- (2) ALL : �������� ����� ��� �����ϸ� ��
    -- ex1. 30�� �μ����� ����� �޿����� ū ������ ��� �ʵ� ���
SELECT SAL 
    FROM EMP 
    WHERE DEPTNO = 30; -- 950, 1250, 2850, 1500, 1600 ��������
SELECT * 
    FROM EMP
    WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO = 30); -- ������ �������� �̿�
SELECT *  
    FROM EMP
    WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30); -- ������ �������� �̿�

-- (3) ANY(SOME) : �������� ����� �ϳ��� �����ϸ� ��
    -- ex1. 30�� �μ����� �Ѹ��� �޿����� ū ������ ��� �ʵ� ���
SELECT SAL 
    FROM EMP 
    WHERE DEPTNO = 30; -- ������ ���Ͽ� ��������
SELECT *
    FROM EMP
    WHERE SAL > ANY(SELECT SAL FROM EMP WHERE DEPTNO = 30); -- ������ �������� �̿�
SELECT *
    FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30); -- ������ �������� �̿�

-- (4) EXISTS : �������� ����� �����ϸ� ��
    -- ex1. ���Ӻ��ϰ� �ִ� �������� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL 
    FROM EMP MANAGER
    WHERE EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO = MGR); -- �������� �̿�
SELECT DISTINCT M.EMPNO, M.ENAME, M.SAL
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO; --SELF JOIN �̿�
    
    -- ex2. ���Ӻ��ϰ� ���� �������� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL  
    FROM EMP MANAGER
    WHERE NOT EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO = MGR); -- �������� �̿�
SELECT M.EMPNO, M.ENAME, M.SAL
    FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO AND W.ENAME IS NULL; --SELF JOIN �̿�
    
-- źź ex
-- �μ����� ���� �޿��� ���� �޴� ����� ����(��� ��ȣ, ����̸�, �޿�, �μ���ȣ)�� ���(IN ������ �̿�)
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP
    WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);
    
-- ����(JOB)�� MANAGER�� ����� ���� �μ��� �μ� ��ȣ�� �μ���� ������ ���(IN)
SELECT DEPTNO 
    FROM EMP 
    WHERE JOB = 'MANAGER'; -- ��������
SELECT DEPTNO, DNAME, LOC 
    FROM DEPT 
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER'); -- ��������

-- �޿��� 3000�̻��� ����� �� ���� ����� ����� �ش� ��޺� �ְ� ������ �޴� ������� ���, �̸�, ����, �Ի���, �޿�, �޿������ ���
SELECT GRADE, MAX(SAL) 
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >= 3000
    GROUP BY GRADE; -- ��������
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND
        (GRADE, SAL) IN (SELECT GRADE, MAX(SAL) FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >= 3000 GROUP BY GRADE)
    ORDER BY GRADE; -- ��������

-- �����ȭ : �Ի��� �б⺰�� ���� ���� ������ �޴� ������� �б�, ���, �̸�, JOB, �����, �Ի���, �޿�, �󿩸� ����ϼ���
SELECT HIREDATE, CEIL(EXTRACT(MONTH FROM HIREDATE)/3) �б� FROM EMP; -- �б�
SELECT TO_CHAR(HIREDATE, 'Q') �б�, MAX(SAL) FROM EMP GROUP BY TO_CHAR(HIREDATE, 'Q'); -- ��������
SELECT HIREDATE, TO_CHAR(HIREDATE, 'Q') �б�, EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM
    FROM EMP
    WHERE (TO_CHAR(HIREDATE, 'Q'), SAL) IN
        (SELECT TO_CHAR(HIREDATE, 'Q'), MAX(SAL)
            FROM EMP GROUP BY TO_CHAR(HIREDATE, 'Q'))
    ORDER BY �б�; -- ��������
-- �޿��� 3000�̸��� ��� �߿� ���� �ֱٿ� �Ի��� ����� �����ȣ�� �̸�, �޿�, �Ի����� ���
SELECT EMPNO, ENAME, SAL, HIREDATE 
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL < 3000);

-- SALESMAN ��� ����� ���� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ������� �ʴ´�.(ALL�̿�)
SELECT ENAME, SAL, JOB 
    FROM EMP
    WHERE SAL > ALL(SELECT SAL FROM EMP WHERE JOB = 'SALESMAN');

-- SALESMAN �Ϻ� � �� ������� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ���(ANY)
SELECT ENAME, SAL, JOB 
    FROM EMP
    WHERE SAL > ANY(SELECT SAL FROM EMP WHERE JOB = 'SALESMAN');

-- �� �� ��������
--1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);

-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL = (SELECT MIN(SAL) FROM EMP);

-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT ENAME, SAL, DEPTNO
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);

--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT E.ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL <= (SELECT AVG(SAL) FROM EMP);

--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL 
        AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT');

--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� �޿��� ū �� ����
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME
    FROM EMP E, DEPT D, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND E.DEPTNO = D.DEPTNO
            AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT')
    ORDER BY SAL DESC;

--7. BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');

--8. MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի���
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER');

--9. �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);

--10. CLARK�� ���� �μ���ȣ�̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'CLARK')
        AND SAL > (SELECT SAL FROM EMP WHERE EMPNO = 7698);

--11.  �����ȭ. CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT E.EMPNO, ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
     AND DNAME = (SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'CLARK')
            AND SAL > (SELECT SAL FROM EMP WHERE EMPNO = 7698);
            
--12. BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի�����
SELECT ENAME, HIREDATE
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE')
        AND ENAME != 'BLAKE';

--13. ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸� �� �޿��� ���� ������ ���)
SELECT EMPNO, ENAME
    FROM EMP
    WHERE SAL >= (SELECT AVG(SAL) FROM EMP)
    ORDER BY SAL DESC;
-- ���⼭���ʹ� �����༭�������� �����༭������, ������ �����༭������
-- 14.  �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� ������ ��� ��ȣ,�̸�,�޿�(�� ��� �� ���)
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
    ORDER BY EMPNO;

-- 15. �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿�
SELECT ENAME, JOB, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND 
        LOC = 'DALLAS';
        
-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿�
SELECT ENAME, SAL 
    FROM EMP 
    WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');
     
-- 17. SALES�μ� ����� �̸�, ����
SELECT ENAME, JOB
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = (SELECT DNAME FROM DEPT WHERE DNAME = 'SALES');

-- 18. ������ �μ� 30�� ���� ���޺��� ���� ����� ��� �ʵ�
SELECT *
    FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30);

-- 19.  FORD�� ������ ���޵� ���� ����� ��� �ʵ�
SELECT *
    FROM EMP
    WHERE (JOB, SAL) = (SELECT JOB, SAL FROM EMP WHERE ENAME = 'FORD');

-- 20. �̸��� JONES�� ������ JOB�� ���ų� FORD�� SAL �̻��� �޴� ����� ������ �̸�, ����, �μ���ȣ, �޿�
    -- ��, ������ ���ĺ� ��, ������ ���� ������ ���
SELECT ENAME, JOB, DEPTNO, SAL 
    FROM EMP
    WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'JONES') OR
        SAL >= (SELECT SAL FROM EMP WHERE ENAME = 'FORD')
    ORDER BY JOB, SAL DESC;

-- 21. SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿�
SELECT ENAME, JOB, SAL
    FROM EMP
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME IN ('SCOTT','WARD'));

-- 22. CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,����
SELECT ENAME, JOB
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND JOB IN (SELECT JOB FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO');
    
-- 23. �μ� ��� ���޺��� ������ ���� ����� ���, �̸�, �޿�, �μ���ȣ
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO);
    -- ���, �̸�, �޿�, �μ���ȣ, �ش�μ��� ���
SELECT EMPNO, ENAME, SAL, DEPTNO, ROUND((SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO)) AVG
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO);
-- 24. �������� ��� ���޺��� ���� ������ �޴� ����� �μ���ȣ, �̸�, �޿�
SELECT DEPTNO, ENAME, SAL
    FROM EMP E
    WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE JOB = E.JOB);

-- 25. ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����, �̸�, ���, �μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
SELECT DISTINCT M.JOB, M.ENAME, M.EMPNO, M.DEPTNO
    FROM EMP W, EMP M 
    WHERE W.MGR = M.EMPNO
    ORDER BY DEPTNO;
    
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP M
    WHERE EXISTS(SELECT EMPNO FROM EMP WHERE M.EMPNO = MGR);
    
-- 26.  ���� ����� ���, �̸�, ����, �μ���ȣ    
SELECT EMPNO, ENAME, JOB, DEPTNO
    FROM EMP M
    WHERE NOT EXISTS(SELECT EMPNO FROM EMP WHERE M.EMPNO = MGR);
    
    
    