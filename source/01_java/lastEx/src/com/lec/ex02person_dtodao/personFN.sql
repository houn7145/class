-- 프로그램 요구사항에 필요한 DML
-- 기능별 query 작성(1, 2, 3)
-- 1.
INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, '홍길동', (SELECT JNO FROM JOB WHERE JNAME = '가수'), 90, 80, 81);
ROLLBACK;

-- 2.
SELECT ROWNUM||'등' RN, S.* 
    FROM(SELECT P.PNAME||'('||PNO||'번)'PNAME, JNAME, KOR, ENG, MAT, SUM 
            FROM PERSON P,JOB J,(SELECT PNAME, KOR+ENG+MAT SUM 
                                    FROM PERSON ORDER BY SUM DESC)A 
                                    WHERE P.PNAME = A.PNAME AND P.JNO = J.JNO AND JNAME = '배우'
                                    ORDER BY SUM DESC)S;
SELECT ROWNUM RANK, A.*
  FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
            FROM PERSON P, JOB J
            WHERE P.JNO=J.JNO AND JNAME='배우'
            ORDER BY SUM DESC) A;

--  3.
SELECT RN||'등' RN, P.PNAME||'('||PNO||')'PNAME, JNAME, P.KOR, P.ENG, P.MAT, SUM 
    FROM JOB J, PERSON P,(SELECT ROWNUM RN, PNAME, SUM 
        FROM(SELECT PNAME, KOR+ENG+MAT SUM FROM PERSON ORDER BY SUM DESC))A 
    WHERE J.JNO=P.JNO AND A.PNAME = P.PNAME;
    
SELECT JNAME FROM JOB;
