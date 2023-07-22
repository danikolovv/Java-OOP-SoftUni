package ReflectionAndAnnotation.Lab.P01Reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Reflection> reflection = Reflection.class;

        System.out.println(reflection);
        System.out.println(reflection.getSuperclass());
        Arrays.stream(reflection.getInterfaces()).forEach(System.out::println);

        Object reflectionObject = reflection.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObject);

    }
}
