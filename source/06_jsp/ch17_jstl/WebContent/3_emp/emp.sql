-- EmpDao�� �� query

-- ��ü ����Ʈ public ArrayList<EmpDto> getListEmp()
SELECT * FROM EMP;

-- �̸��� job���� �˻��� ����Ʈ public ArrayList<EmpDto> getListEmp(String Name, String job)
SELECT * FROM EMP 
    WHERE ENAME LIKE '%'||TRIM(UPPER('   s'))||'%'
        AND JOB LIKE '%'||UPPER(TRIM('  m'))||'%';