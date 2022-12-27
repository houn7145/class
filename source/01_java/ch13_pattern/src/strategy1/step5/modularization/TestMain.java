package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyHigh;
import strategy1.step4.interfaces.KnifeToy;

public class TestMain {
	public static void main(String[] args) {
		// Robot[] robots = {new SuperRobot(), new StandardRobot(), new LowRobot()};
		SuperRobot superRobot = new SuperRobot();
		StandardRobot standardRobot = new StandardRobot();
		LowRobot lowRobot = new LowRobot();
		Robot[] robots = { superRobot, standardRobot, lowRobot };
		for (Robot robot : robots) {
			robot.shape();
			robot.actionRun();
			robot.actionWalk();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
		System.out.println("SuperRobot�� ���� ��ǰ�� ���� ���� ���� ���� ������� ���׷��̵�");
		superRobot.setFly(new FlyHigh());
		robots[0].shape();
		robots[0].actionFly();
		System.out.println("LowRobot�� Knife��ǰ�� '�峭�� ���� �ֽ��ϴ�' ������� ���׷��̵�");
		lowRobot.setKnife(new KnifeToy());
		robots[2].shape();
		robots[2].actionKnife();
	}
}