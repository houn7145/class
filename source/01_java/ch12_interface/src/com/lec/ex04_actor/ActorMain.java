package com.lec.ex04_actor;

public class ActorMain {
	public static void main(String[] args) {
		Actor gong = new Actor("°øÀ¯");
		gong.makePizza(); gong.makeSpaghetti();
		gong.outFire();	gong.saveMan();
		gong.canCatchCriminal(); gong.canSearch();
		
		Chef chefgong = gong;
		chefgong.makePizza(); chefgong.makeSpaghetti();
//		chefgong.outFire();	chefgong.saveMan();
//		chefgong.canCatchCriminal(); chefgong.canSearch();
		
		FireFighter firegong = gong;
//		firegong.makePizza(); firegong.makeSpaghetti();
		firegong.outFire();	firegong.saveMan();
//		firegong.canCatchCriminal(); firegong.canSearch();
		
		PoliceMan policegong = gong;
//		policegong.makePizza(); policegong.makeSpaghetti();
//		policegong.outFire();	policegong.saveMan();	
		policegong.canCatchCriminal(); policegong.canSearch();
	}
}
