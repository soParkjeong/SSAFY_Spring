import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;

//어노테이션 정의해보기
@Retention(value=RetentionPolicy.RUNTIME)
@interface MyMethod {
	// MyAnnotation에 대한 추가 정보
	String name() default "";
}


public class Reflection_어노테이션알아보기 {
	public static void main(String[] args) {
		// 하나의 특정 클래스를 어떤 필드들이 정의 되어 있는지
		Field[] fields = Person.class.getDeclaredFields();
		
		for (Field field : fields) {
			String name = field.getName();
			Type type = field.getGenericType();
			System.out.println(name + " - " + type);
		}


		// 하나의 특정 클래스를 어떤 메소드들이 정의 되어 있는지
		Method[] methods = Person.class.getDeclaredMethods();
		
		for (Method method : methods) {
			String name = method.getName();
			int count = method.getParameterCount();
			Annotation[] annotations = method.getAnnotations();
			// System.out.println(name + " - " + count + " - " + Arrays.toString(annotations));
			
			// MyMethod이 붙어 있는 메서드를 출력해라
			if (method.isAnnotationPresent(MyMethod.class)) {
				System.out.println(name + " - " + count + " - " + Arrays.toString(annotations));
			}
		}
	}
}
