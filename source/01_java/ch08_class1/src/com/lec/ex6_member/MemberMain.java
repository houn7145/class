package com.lec.ex6_member;

public class MemberMain {
	public static void main(String[] args) {
		Member member = new Member("aaa", "xxx","홍길동","hong@company.com", "서울 강남구","2000-01-01",'m');
		System.out.println(member.infoString());
		
		Member member1 = new Member("aaa", "xxx", "홍길동", "hong@company.com",
                "서울시 강남구", "2000-01-01", 'M');
		Member member2 = new Member("bbb", "xxx", "신길동", "shin@company.com", 
				"서울시 서대문구 신촌로 141", "1999-01-02", 'F');
		//System.out.println(member1.infoString());
		Member[] members = {member1, member2};
		for(Member member3 : members) {
			System.out.println(member3.infoString());
	}
}
}
