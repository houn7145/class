package com.lec.ex02_store;
public class StoreMain {
	public static void main(String[] args) {
//		HeadQuarterStore head = new HeadQuarterStore("= = ���� = =");
//		Store1 st1 = new Store1("= = ���ð� 1ȣ�� = =");
//		Store2 st2 = new Store2("= = ���а� 2ȣ�� = =");
//		Store3 st3 = new Store3("= = ���ǰ� 3ȣ�� = =");
//		HeadQuarterStore[] stores = {head, st1, st2, st3};
		HeadQuarterStore[] stores = {
				//new HeadQuarterStore("= = ���� = ="), �߻�Ŭ������ ��ü ���� �Ұ�
				new Store1(),
				new Store2(),
				new Store3()};
//		for(int idx=0 ; idx<stores.length ; idx++) {
//			stores[idx].storeName();
//			stores[idx].kimchi();
//			stores[idx].bude();
//			stores[idx].bibim();
//			stores[idx].sunde();
//			stores[idx].gongibab();
//		}//�Ϲ� for
		for(HeadQuarterStore store : stores) {
			store.storeName();
			store.kimchi();
			store.bude();
			store.bibim();
			store.sunde();
			store.gongibab();
		}// Ȯ�� for
	}// main
}