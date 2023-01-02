-- [ III ] join : 2�� �̻��� ���̺��� �����Ͽ� �����͸� �˻��ϴ� ���
SELECT * FROM EMP WHERE ENAME = 'SCOTT'; -- 1��
SELECT * FROM DEPT; -- 4��
-- CROSS JOIN (FROM ���� ���̺��� 2�� �̻�)
SELECT * FROM EMP, DEPT WHERE ENAME = 'SCOTT'; -- 1(EMP���̺��� ����)*4(DEPT���̺��� ����)��

-- �� 1. EQUI JOIN(�����ʵ��� DEPTNO���� ��ġ�Ǵ� ���Ǹ� JOIN)
SELECT * FROM EMP, DEPT 
    WHERE ENAME = 'SCOTT' AND EMP.DEPTNO = DEPT.DEPTNO;
    
    -- ex. ��� ����� ���, �̸�, JOB, �����, �μ���ȣ, �μ��̸�, �ٹ��� ���
SELECT EMPNO, ENAME, JOB, MGR, EMP.DEPTNO, DNAME, LOC
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO;
    
SELECT EMPNO, ENAME, JOB, MGR, E.DEPTNO, DNAME, LOC
    FROM EMP E, DEPT D -- FROM���� ���� �����ϱ⿡ ��Ī�� �൵ ��
    WHERE E.DEPTNO = D.DEPTNO;
    
    -- ex. �޿��� 2000�̻��� ����� �̸� ,��å, �޿�, �μ���, �ٹ��� ���
SELECT ENAME, JOB,SAL, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL >= 2000;
    
    -- ex. 20�� �μ��� ������ �̸�, �μ���ȣ, �ٹ��� ���
SELECT ENAME, E.DEPTNO, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO = 20;
    
    -- ex. LOC�� CHICAGO�� ����� �̸�, ����, �޿�, �μ���, �ٹ����� ���
SELECT ENAME, JOB, SAL, DNAME, LOC 
    FROM EMP E, DEPT D
    WHERE  E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO';
    
    -- ex. �μ���ȣ�� 10�̰ų� 20���� ����� �̸�, ����, �ٹ����� ���(�޿���)
SELECT ENAME JOB, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO IN (10,20) ORDER BY SAL;
    
    -- ex. JOB�� SALESMAN�̰ų� MANAGER�� ����� �̸�, �޿�, ��, ����((SAL+COMM*12), �μ���, �ٹ����� ���(������ ū ������ ����)
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM,0))*12 ANNUALSAL, DNAME, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND JOB IN ('SALESMAN','MANAGER') 
    ORDER BY ANNUALSAL, DESC;
    
    -- ex. COMM�� NULL�̰� SAL�� 1200 �̻��� ����� �̸�, �޿�, �Ի���, �μ���ȣ, �μ���
    -- �μ��� ������ ����, ���� �μ��� �� �޿��� ū ������ ����
SELECT ENAME, SAL, HIREDATE, E.DEPTNO DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NULL AND SAL >= 1200 
    ORDER BY DNAME, SAL DESC;
    
    -- źź ex.
 -- ���忡�� �ٹ��ϴ� ����� �̸��� �޿��� ����Ͻÿ�
SELECT ENAME, SAL 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';

 --	ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի����� ����Ͻÿ�
SELECT ENAME, HIREDATE
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = 'ACCOUNTING';

 --	������ MANAGER�� ����� �̸�, �μ����� ����Ͻÿ�
SELECT ENAME, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND JOB = 'MANAGER';

 --	Comm�� null�� �ƴ� ����� �̸�, �޿�, �μ��ڵ�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, E.DEPTNO, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL;


-- �� 2. NON - EQUI JOIN
SELECT * FROM EMP 
    WHERE ENAME = 'SCOTT'; -- ���� ����
SELECT * 
    FROM SALGRADE; -- �޿� ��� ����
SELECT * 
    FROM EMP, SALGRADE 
    WHERE ENAME = 'SCOTT'; -- CROSS JOIN
SELECT * 
    FROM EMP, SALGRADE 
    WHERE SAL >= LOSAL AND SAL <= HISAL AND ENAME = 'SCOTT'; -- NON - EQUI JOIN
SELECT * 
    FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL AND ENAME = 'SCOTT';  -- NON - EQUI JOIN
    
    -- ex. ��� ����� ���, �̸�, ��å, �����, �޿�, �޿����(1���, 2���, ...)
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE || '���' GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
    
    -- źź ex.
--	Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ���ȣ, �μ��̸�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, GRADE, E.DEPTNO, DNAME, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL 
        AND COMM IS NOT NULL;

--	�̸�, �޿�, �Ի���, �޿����
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL; 

--	�̸�, �޿�, �Ի���, �޿����, �μ���, �ٹ���
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL;

--	�̸�, �޿�, ���, �μ��ڵ�, �ٹ���. �� comm �� null�ƴ� ���
SELECT ENAME, SAL, GRADE, D.DEPTNO, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
        AND COMM IS NOT NULL;

--	�̸�, �޿�, �޿����, ����, �μ���, �μ��� ���, �μ��� ������ ������. ����=(sal+comm)*12 comm�� null�̸� 0
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM, 0)*12) ����, DNAME
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL 
    ORDER BY DNAME, ���� DESC;

--	�̸�, ����, �޿�, ���, �μ��ڵ�, �μ��� ���. �޿��� 1000~3000����. �������� : �μ���, �μ������� ������, ���������� �޿� ū��
SELECT ENAME, JOB, SAL, GRADE, D.DEPTNO, DNAME
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
        AND SAL BETWEEN 1000 AND 3000 
    ORDER BY DNAME, JOB, SAL DESC;

--	�̸�, �޿�, ���, �Ի���, �ٹ���. 81�⿡ �Ի��� ���. ��� ū��
SELECT ENAME, SAL, GRADE, HIREDATE, LOC
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND HIREDATE BETWEEN '81/01/01' AND '81/12/31' 
    ORDER BY GRADE DESC;


-- �� 3. SELP - JOIN
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'SMITH';
SELECT EMPNO, ENAME FROM EMP WHERE EMPNO = 7902;

SELECT WORK.EMPNO, WORK.ENAME, WORK.MGR, MANAGER.EMPNO, MANAGER.ENAME
    FROM EMP WORK, EMP MANAGER
    WHERE WORK.ENAME = 'SMITH' AND WORK.MGR = MANAGER.EMPNO;
    
    -- ex. ��� ����� ���, �̸�, ����� ���, ����� �̸�
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO; -- 13�� (KING�� MGR�� NULL�̶� EMPNO���� NULL�� ���⿡ �ȳ���)
    
    -- ex. 'SMITH�� ���� FORD��' �������� ���
SELECT W.ENAME || '�� ���� ' || M.ENAME || '��' MESSAGE
    FROM EMP W, EMP M
    WHERE W.MGR =  M.EMPNO;
    
    -- źź ex.
-- �Ŵ����� KING�� ������� �̸��� ������ ����Ͻÿ�.
SELECT W.ENAME, W.JOB
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO AND M.ENAME = 'KING';

-- SCOTT�� ������ �μ���ȣ���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�
SELECT E2.ENAME
    FROM EMP E1, EMP E2
    WHERE E1.ENAME = 'SCOTT' AND E1.DEPTNO = E2.DEPTNO AND E2.ENAME != 'SCOTT';
    
-- SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�(2�ܰ� ��������)
SELECT ENAME 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'SCOTT';
SELECT ENAME 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO 
        AND LOC = 'DALLAS' AND ENAME != 'SCOTT';
    
SELECT E1.ENAME
    FROM EMP E1, EMP E2, DEPT D
    WHERE E1.DEPTNO = D.DEPTNO AND E2.ENAME = 'SCOTT' 
        AND LOC = 'DALLAS' AND E1.ENAME != 'SCOTT';

SELECT E2.ENAME
    FROM EMP E1, DEPT D1, EMP E2, DEPT D2
    WHERE E1.DEPTNO = D1.DEPTNO AND E2.DEPTNO = D2.DEPTNO 
        AND E1.ENAME = 'SCOTT' AND D1.LOC = D2.LOC AND E2.ENAME != 'SCOTT';
    
INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
INSERT INTO EMP VALUES (9999,'ȫ',NULL,NULL,NULL,6000,NULL,50);
-- ȫ �߰��Ѱ� �ѹ���

-- �� 4. OUTER JOIN : EQUI JOIN & SELF JOIN�� ���ǿ� �������� �ʴ� ����� ��Ÿ���� �ϴ� JOIN
-- (1) SELF JOIN������ OUTER JOIN
SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
    
    -- ex. "SNITH�� ���� FORD" ... 'KING�� ���� ����'
SELECT W.ENAME || '�� ���� ' || NVL(M.ENAME, '����')
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
    -- ex. ���ܻ�� ���
SELECT M.EMPNO, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO AND W.ENAME IS NULL;

-- (2) EQUI JOIN������ OUTER JOIN
SELECT * FROM EMP; -- 14��
SELECT * FROM DEPT; -- 4��
SELECT * FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO; -- 40�� �μ��� ��� �ȵ�
SELECT * FROM EMP E, DEPT D WHERE E.DEPTNO(+) = D.DEPTNO; -- 40�� �μ� ���

-- �� <��������> PART1
--1. �̸�, ���ӻ���
SELECT W.ENAME �̸�, M.ENAME ���ӻ���
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;

--2. �̸�, �޿�, ����, ���ӻ���
SELECT W.ENAME, W.SAL, W.JOB, M.ENAME ���ӻ���
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;

--3. �̸�, �޿�, ����, ���ӻ��� . (��簡 ���� �������� ��ü ���� �� ���.
    --��簡 ���� �� '����'���� ���)
SELECT W.ENAME, W.SAL, W.JOB, NVL(M.ENAME, '����') ���ӻ���
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);

--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT W.ENAME, W.SAL, D.DNAME, M.ENAME ���ӻ���
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.EMPNO AND W.DEPTNO = D.DEPTNO;

--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT W.ENAME, W.SAL, D.DEPTNO, D.DNAME, D.LOC, M.ENAME ���ӻ���
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.EMPNO(+) AND W.DEPTNO = D.DEPTNO;

--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT W.ENAME, W.SAL, GRADE, D.DNAME, M.ENAME ���ӻ���
    FROM EMP W, EMP M, SALGRADE, DEPT D
    WHERE W.MGR = M.EMPNO AND W.DEPTNO = D.DEPTNO 
        AND W.SAL BETWEEN LOSAL AND HISAL AND W.SAL >= 2000;

--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT W.ENAME, W.SAL, GRADE, D.DNAME, M.ENAME ���ӻ���
    FROM EMP W, EMP M, SALGRADE, DEPT D
    WHERE W.MGR = M.EMPNO(+) AND W.DEPTNO = D.DEPTNO 
        AND W.SAL BETWEEN LOSAL AND HISAL
    ORDER BY D.DNAME;

--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT W.ENAME, W.SAL, GRADE, D.DNAME, (W.SAL+NVL(W.COMM,0))*12 ����, M.ENAME ���ӻ���
    FROM EMP W, EMP M, SALGRADE, DEPT D
    WHERE W.MGR = M.EMPNO AND W.DEPTNO = D.DEPTNO
        AND W.SAL BETWEEN LOSAL AND HISAL;

--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT W.ENAME, W.SAL, GRADE, D.DNAME, (W.SAL+NVL(W.COMM,0))*12 ����, M.ENAME ���ӻ���
    FROM EMP W, EMP M, SALGRADE, DEPT D
    WHERE W.MGR = M.EMPNO AND W.DEPTNO = D.DEPTNO
        AND W.SAL BETWEEN LOSAL AND HISAL
    ORDER BY D.DNAME, SAL DESC;

--  PART2
--1.EMP ���̺��� ��� ����� ���� �̸�, �μ���ȣ, �μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT E.ENAME, E.DEPTNO, D.DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO;

--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�, ����, �޿�, �μ����� ���
SELECT E.ENAME, E.JOB, E.SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';

--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
SELECT E.ENAME, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND COMM > 0;

--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT E.ENAME, E.JOB, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND ENAME LIKE '%L%';

--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO, E.ENAME, E.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    ORDER BY E.ENAME;

--6. ���, �����, �޿�, �μ����� �˻��϶�. 
    --�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO, E.ENAME, E.SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND E.SAL >= 2000
    ORDER BY SAL DESC;

--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻���
-- ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT EMPNO, E.ENAME, JOB, E.SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND JOB = 'MANAGER' AND E.SAL >= 2500
    ORDER BY EMPNO;

--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, JOB, E.SAL, GRADE
    FROM EMP E, SALGRADE
    WHERE E.SAL BETWEEN LOSAL AND HISAL
    ORDER BY E.SAL DESC;

--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT E1.ENAME, E2.ENAME ���
    FROM EMP E1, EMP E2, DEPT D
    WHERE E1.DEPTNO = D.DEPTNO AND E1.MGR = E2.EMPNO(+);

--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT E1.ENAME, E2.ENAME "������ ���", E3.ENAME ���
    FROM EMP E1, EMP E2, EMP E3
    WHERE E1.MGR = E2.EMPNO AND E2.MGR = E3.EMPNO;

--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT E1.ENAME, NVL(E2.ENAME,'����')"������ ���", NVL(E3.ENAME,'����') ��� 
    FROM EMP E1, EMP E2, EMP E3
    WHERE E1.MGR = E2.EMPNO(+) AND E2.MGR = E3.EMPNO(+);

