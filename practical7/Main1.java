import java.lang.annotation.*;
import java.lang.reflect.Method;

// Custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

// Class containing test methods
class MyTests {

    @Run
    public void testLogin() {
        System.out.println("Login test executed");
    }

    @Run
    public void testSignup() {
        System.out.println("Signup test executed");
    }

    public void normalMethod() {
        System.out.println("This method should NOT run");
    }

    @Run
    public void testLogout() {
        System.out.println("Logout test executed");
    }
}

// Mini test runner
public class Main1 {
    public static void main(String[] args) {
        MyTests testObject = new MyTests();
        int count = 0;
        
        Method[] methods = MyTests.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Run.class)) {
                try {
                    
                    method.invoke(testObject);
                    count++;
                } catch (Exception e) {
                    System.out.println("Error running: " + method.getName());
                }
            }
        }
        System.out.println();
        System.out.println("Total methods run: " + count);
    }
}