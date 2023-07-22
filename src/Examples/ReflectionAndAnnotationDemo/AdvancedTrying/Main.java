package Examples.ReflectionAndAnnotationDemo.AdvancedTrying;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Reflection> reflectionClass = Reflection.class;

        Field[] fields = reflectionClass.getDeclaredFields();
        Field field = reflectionClass.getField("age");

        Constructor<?>[] constructors = reflectionClass.getConstructors();
        Constructor<?>[] allConstructors = reflectionClass.getDeclaredConstructors();
//        Constructor<Reflection> allConstructorsPrams = reflectionClass.getDeclaredConstructor(String.class);

        Constructor<Reflection> constructor = Reflection.class.getConstructor(String.class, String.class, String.class);
        Reflection reflection = constructor.newInstance("arg1", "arg2", "arg3");

        String fieldName = field.getName();
        Object fieldType = field.getType();

        System.out.println(fieldName);
        System.out.println(fieldType);
        System.out.println(field);

        System.out.println("===");

        Arrays.stream(fields).forEach(System.out::println);

        System.out.println("===");

        field.setAccessible(true);
        Arrays.stream(constructors.getClass().getDeclaredFields()).forEach(f -> System.out.printf("%s -> %s%n", f.getName(), f.getType()));
        Arrays.stream(constructors).forEach(System.out::println);
        
        Arrays.stream(allConstructors).forEach(System.out::println);

        System.out.println("===");

        Arrays.stream(reflection.getClass().getDeclaredFields()).forEach(f -> System.out.printf("%s -> %s%n", f.getName(), f.getType()));

    }
}
