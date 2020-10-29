package annotation;

import streamapi.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ReflectionMain1 {
    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person("asdasfljkjsdhlfkjbnas;kdfjn");
        Class<? extends Person> aClass = person.getClass();
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if(annotation instanceof Version){
                Version ver = (Version) annotation;
                System.out.println(ver.info());
            }
        }
//        System.out.println(person.getPassword());
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
            declaredField.setAccessible(true);
            System.out.println(declaredField.get(person));
            declaredField.set(person, "Привет, мы хакеры");
            System.out.println(declaredField.get(person));
        }
    }
}
