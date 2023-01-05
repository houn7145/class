-- (사번, 이름, 상사이름, 급여, 급여등급. 상사가 없는 사원은 CEO)
SELECT W.EMPNO, W.ENAME, NVL(M.ENAME, 'CEO')MANAGER , W.SAL, GRADE
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR = M.EMPNO AND W.DEPTNO = D.DEPTNO 
        AND W.SAL BETWEEN LOSAL AND HISAL
        AND DNAME = UPPER('sales');
SELECT * FROM DEPT;