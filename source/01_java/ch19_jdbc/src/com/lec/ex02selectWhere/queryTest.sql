-- Ex1 �μ���ȣ �ް� ����ϱ�
SELECT * FROM EMP WHERE DEPTNO = 40;
-- 40�� ����

-- Ex2 �μ���ȣ �ް� �μ������� ������� (���, �̸�, �޿�, ����̸�) ����ϱ�
SELECT * FROM DEPT WHERE DEPTNO = 40;
SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER FROM EMP W, EMP M WHERE W.MGR = M.EMPNO AND W.DEPTNO = 20;


-- Ex3 

-- Ex4