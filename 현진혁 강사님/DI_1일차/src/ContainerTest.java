import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ContainerTest {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, IllegalArgumentException, NoSuchMethodException, SecurityException {
		Object config = Config.class.getDeclaredConstructor().newInstance();
		Method[] methods = Config.class.getDeclaredMethods();
		
		// 반복문을 돌면서 @Bean이라는 어노테이션이 붙어 있는 객체들을 생성
		Map<String, Object> beans = new HashMap<>();
		for (Method method : methods) {
			if(method.isAnnotationPresent(Bean.class)) {
				Object obj = method.invoke(config); // config.method();
				
				// bean 객체를 관리하기 위한 수단
				beans.put(method.getName(), obj);
			}
		}
		System.out.println(beans);
		

		// 그 다음 단계로 필드 내에 해당 객체들의 의존성 주입이 필요하면 주입
		// 의존성 주입 (DI) - 필드 의존성 주입 @Autowired 필드에 대한
		for(Object object : beans.values()) {
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				String name = field.getName();
				if (field.isAnnotationPresent(Autowired.class)) {
					// 해당 필드에 이미 가지고 있는 객체를 주입
					// obj.computer = computer; // 외부에서는 접근제어자 때문에 직접 주입이 어려움
					field.setAccessible(true); // private임에도 접근 허용
					field.set(object, beans.get(name));
				}
			}
		}
			
		
		// 길동 객체를 원해요
		Person gildong = (Person) beans.get("getGildong");
		gildong.sing();
	}
}
