
public class Person {
	String name;
	int age;
	int health;

	public Person(String name, int age, int health) {
		this.name = name;
		this.age = age;
		this.health = health;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", health=" + health +
				'}';
	}

	@MyMethod
	public void sing() {
		System.out.println("" + this.name + "이가 노래를 부릅니다.");
	}
}