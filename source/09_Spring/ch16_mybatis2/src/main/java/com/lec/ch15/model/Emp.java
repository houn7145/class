package com.lec.ch15.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Emp {
	// emp 테이블 컬럼 + dname, loc + startRow, endRow
	private int empno;
	private String ename;
	private String job;
	private String mgr;
	private Date hiredate;
	private int sal;
	private String comm;
	private int deptno;
	private String dname;
	private String loc;
	// 페이징 처리를 위한 속성 변수
	private int startRow;
	private int endRow;
}
