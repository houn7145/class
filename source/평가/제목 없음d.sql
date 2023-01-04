-- 1. 사번, 이름, 급여를 출력
SELECT EMPNO, ENAME, SAL FROM EMP;

-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
SELECT * FROM EMP 
    WHERE SAL BETWEEN 2000 AND 5000;
    
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
SELECT EMPNO, ENAME, DEPTNO
    FROM EMP
    WHERE DEPTNO IN (10, 20);
    
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
SELECT EMPNO, ENAME, SAL 
    FROM EMP
    WHERE COMM IS NULL
    ORDER BY SAL DESC;
-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
SELECT EMPNO, ENAME, DEPTNO, SAL
     FROM EMP
     ORDER BY DEPTNO, SAL DESC;
-- 6. 사번, 이름, 부서명
SELECT EMPNO, ENAME, DNAME
    FROM EMP M, DEPT D
    WHERE M.DEPTNO = D.DEPTNO;

-- 7. 사번, 이름, 상사이름
SELECT W.EMPNO, W.ENAME, M.ENAME MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;

-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)
SELECT W.EMPNO, W.ENAME, M.ENAME MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
-- 9. 이름이 s로 시작하는 사원 이름
SELECT ENAME FROM EMP
    WHERE ENAME LIKE 'S%';

-- 10. 사번, 이름, 급여, 부서명, 상사이름
SELECT W.EMPNO, W.ENAME, W.SAL, DNAME, M.ENAME MANAGER
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.EMPNO AND W.DEPTNO = D.DEPTNO;

-- 11. 부서코드, 급여합계, 최대급여
SELECT DEPTNO, SUM(SAL), MAX(SAL)
    FROM EMP
    GROUP BY DEPTNO;

-- 12. 부서명, 급여평균, 인원수
SELECT DNAME, AVG(SAL), COUNT(*)
    FROM DEPT D, EMP E
    WHERE E.DEPTNO = D.DEPTNO
    GROUP BY DNAME;

-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력\
SELECT DEPTNO, SUM(SAL), COUNT(*)
   FROM EMP
   GROUP BY DEPTNO
   HAVING COUNT(*) >= 4;

-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
SELECT EMPNO, ENAME, SAL 
    FROM EMP
    WHERE SAL = (SELECT MAX(SAL) FROM EMP);

-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
SELECT ENAME, SAL 
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);

-- 16. 회사 평균 급여보다 많이 받는 사원의 사번, 이름, 급여, 부서명을 출력(부서명순 정열 같으면 급여 큰순 정렬)
SELECT EMPNO, ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL > (SELECT AVG(SAL) FROM EMP)
    ORDER BY DNAME, SAL DESC;

-- 17. 자신이 속한 부서의 평균보다 많이 받는 사람의 이름, 급여, 부서번호, 반올림한 해당부서평균
SELECT ENAME, SAL, E.DEPTNO, ROUND(AVG)
    FROM EMP E,(SELECT DEPTNO, AVG(SAL) AVG
    FROM EMP 
    GROUP BY DEPTNO)A
    WHERE E.DEPTNO = A.DEPTNO AND SAL > AVG;

-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
SELECT ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);
 
-- 19. 이름, 급여, 해당부서평균
;
SELECT ENAME, SAL, AVG
    FROM EMP E, (SELECT DEPTNO, AVG(SAL) AVG
    FROM EMP
    GROUP BY DEPTNO) A
    WHERE E.DEPTNO = A.DEPTNO;

-- 20. 이름, 급여, 부서명, 해당부서평균
SELECT ENAME, SAL, DNAME, AVG FROM EMP E, DEPT D, (SELECT DEPTNO, AVG(SAL) AVG FROM EMP
    GROUP BY DEPTNO)A
    WHERE E.DEPTNO= D.DEPTNO AND E.DEPTNO = A.DEPTNO;