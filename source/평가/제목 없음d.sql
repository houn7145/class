-- 1. ���, �̸�, �޿��� ���
SELECT EMPNO, ENAME, SAL FROM EMP;

-- 2. �޿��� 2000~5000 ���� ��� ������ ��� �ʵ�
SELECT * FROM EMP 
    WHERE SAL BETWEEN 2000 AND 5000;
    
-- 3. �μ���ȣ�� 10�Ǵ� 20�� ����� ���, �̸�, �μ���ȣ
SELECT EMPNO, ENAME, DEPTNO
    FROM EMP
    WHERE DEPTNO IN (10, 20);
    
-- 4. ���ʽ��� null�� ����� ���, �̸�, �޿� �޿� ū ������
SELECT EMPNO, ENAME, SAL 
    FROM EMP
    WHERE COMM IS NULL
    ORDER BY SAL DESC;
-- 5. ���, �̸�, �μ���ȣ, �޿�. �μ��ڵ� �� ���� ������ PAY ū��
SELECT EMPNO, ENAME, DEPTNO, SAL
     FROM EMP
     ORDER BY DEPTNO, SAL DESC;
-- 6. ���, �̸�, �μ���
SELECT EMPNO, ENAME, DNAME
    FROM EMP M, DEPT D
    WHERE M.DEPTNO = D.DEPTNO;

-- 7. ���, �̸�, ����̸�
SELECT W.EMPNO, W.ENAME, M.ENAME MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;

-- 8. ���, �̸�, ����̸�(��簡 ���� ����� ���)
SELECT W.EMPNO, W.ENAME, M.ENAME MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
-- 9. �̸��� s�� �����ϴ� ��� �̸�
SELECT ENAME FROM EMP
    WHERE ENAME LIKE 'S%';

-- 10. ���, �̸�, �޿�, �μ���, ����̸�
SELECT W.EMPNO, W.ENAME, W.SAL, DNAME, M.ENAME MANAGER
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.EMPNO AND W.DEPTNO = D.DEPTNO;

-- 11. �μ��ڵ�, �޿��հ�, �ִ�޿�
SELECT DEPTNO, SUM(SAL), MAX(SAL)
    FROM EMP
    GROUP BY DEPTNO;

-- 12. �μ���, �޿����, �ο���
SELECT DNAME, AVG(SAL), COUNT(*)
    FROM DEPT D, EMP E
    WHERE E.DEPTNO = D.DEPTNO
    GROUP BY DNAME;

-- 13. �μ��ڵ�, �޿��հ�, �ο��� �ο����� 4�� �̻��� �μ��� ���\
SELECT DEPTNO, SUM(SAL), COUNT(*)
   FROM EMP
   GROUP BY DEPTNO
   HAVING COUNT(*) >= 4;

-- 14. ���, �̸�, �޿� ȸ�翡�� ���� �޿��� ���� �޴� ���
SELECT EMPNO, ENAME, SAL 
    FROM EMP
    WHERE SAL = (SELECT MAX(SAL) FROM EMP);

-- 15. ȸ�� ��պ��� �޿��� ���� �޴� ��� �̸�, �޿�, �μ���ȣ
SELECT ENAME, SAL 
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);

-- 16. ȸ�� ��� �޿����� ���� �޴� ����� ���, �̸�, �޿�, �μ����� ���(�μ���� ���� ������ �޿� ū�� ����)
SELECT EMPNO, ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL > (SELECT AVG(SAL) FROM EMP)
    ORDER BY DNAME, SAL DESC;

-- 17. �ڽ��� ���� �μ��� ��պ��� ���� �޴� ����� �̸�, �޿�, �μ���ȣ, �ݿø��� �ش�μ����
SELECT ENAME, SAL, E.DEPTNO, ROUND(AVG)
    FROM EMP E,(SELECT DEPTNO, AVG(SAL) AVG
    FROM EMP 
    GROUP BY DEPTNO)A
    WHERE E.DEPTNO = A.DEPTNO AND SAL > AVG;

-- 18. �Ի簡 ���� ���� ����� �̸�, �޿�, �μ���
SELECT ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);
 
-- 19. �̸�, �޿�, �ش�μ����
;
SELECT ENAME, SAL, AVG
    FROM EMP E, (SELECT DEPTNO, AVG(SAL) AVG
    FROM EMP
    GROUP BY DEPTNO) A
    WHERE E.DEPTNO = A.DEPTNO;

-- 20. �̸�, �޿�, �μ���, �ش�μ����
SELECT ENAME, SAL, DNAME, AVG FROM EMP E, DEPT D, (SELECT DEPTNO, AVG(SAL) AVG FROM EMP
    GROUP BY DEPTNO)A
    WHERE E.DEPTNO= D.DEPTNO AND E.DEPTNO = A.DEPTNO;