
// Bean이라는 어노테이션을 통해 해당 메서드가 Bena 객체를 생성하는 메서드임을 알 수 있다.

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
@interface Bean {
	String name() default "";
}

@Retention(value=RetentionPolicy.RUNTIME) 
@interface Autowired {
	String name() default "";
}

class KeyBoard {}

class Computer {}

// 만들어주세요!
class Developer{
	@Autowired // 의존성 주입
	private Computer computer;
	@Autowired // 의존성 주입
	private KeyBoard keyboard;
	
}

public class Config {
	// 여기에 내가 생성하고 관리하고 싶은 모든 객체 (Bean) 정보를 메서드로 모두 정의
	@Bean
	public Person getGildong() {
		return new Person("길동", 20, 100);
	}

	@Bean
	public Person getYumi() {
		return new Person("유미", 18, 95);
	}
	
	@Bean(name="computer")
	public Computer getComputer() {
		return new Computer();
	}
	
	@Bean(name="keyboard")
	public KeyBoard  getKeyboard() {
		return new KeyBoard();
	}
	
	@Bean(name="developer")
	public Developer getDeveloper() {
		return new Developer();
	}
}
