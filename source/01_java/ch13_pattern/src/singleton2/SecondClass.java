package singleton2;

public class SecondClass {
	public SecondClass() {
		System.out.println("SecondClass ������ ���� ��");
		SingletonClass singletonObjet = SingletonClass.getInstance();
		System.out.println("�̱��� ��ü�� i���� " + singletonObjet.getI());
	}
}
