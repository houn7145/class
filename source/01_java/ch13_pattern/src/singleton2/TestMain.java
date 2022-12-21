package singleton2;

public class TestMain {
	public static void main(String[] args) {
		FirstClass firstObj = new FirstClass();
		SecondClass secondObj = new SecondClass();
		SingletonClass singObj = SingletonClass.getInstance(); // 이미 만들어져 있어서 new 못함
		System.out.println("main함수에서 싱글톤 객체의 i값 :" + singObj.getI());
	}

}
