package ua.training;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;

/**
 * Runner
 *
 * @author Yurii Krat
 * @version 1.0, 08.11.16
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException,
            InvocationTargetException, IllegalAccessException {

        LocalDate date = LocalDate.of(1997, 11, 18);
        Notebook notebook = new Notebook("Ivan", "Ivanov", "911", date);

        Class clazz = Class.forName("ua.training.Notebook");
        System.out.println("Name of the class: " + clazz.getName());
        int modifiers = clazz.getModifiers();
        System.out.println("Class modifiers: " + Modifier.toString(modifiers));

        System.out.print("Invoking methods with annotation: ");
        Method[] methods = clazz.getMethods();
        for (Method method : methods){
            System.out.println("Method " + method.getName() + "() is processed");
            if (method.isAnnotationPresent(MyAnnotation.class)){
                System.out.println("Invoking of " + method.getName() + "()");
                System.out.println("Result: " + method.invoke(notebook));
            }
        }
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println("Constructor: " + constructor.getName());
            Class[] constructorParameters = constructor.getParameterTypes();
            for(Class parameter : constructorParameters) {
                System.out.println("Parameter: " + parameter.getSimpleName());
            }
        }

    }
}
