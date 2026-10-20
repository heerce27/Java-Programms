import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// Custom annotation for checking blank values
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

// Custom annotation for checking maximum length
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// Form class
class SignupForm {
    @NotBlank
    String username;
    @NotBlank
    @MaxLength(10)
    String password;
    @MaxLength(30)
    String email;
    SignupForm(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}

// Validator
class FormValidator {
    public static List<String> validate(Object obj) {
        List<String> errors = new ArrayList<>();
        // Get all fields of the object
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                // Allow access to private fields also
                field.setAccessible(true);
                Object value = field.get(obj);
                // Check @NotBlank
                if (field.isAnnotationPresent(NotBlank.class)) {
                    if (value == null || value.toString().trim().isEmpty()) {
                        errors.add(field.getName() + " must not be blank");
                    }
                }

                // Check @MaxLength
                if (field.isAnnotationPresent(MaxLength.class)) {
                    MaxLength annotation = field.getAnnotation(MaxLength.class);
                    int max = annotation.value();
                    if (value != null && value.toString().length() > max) {
                        errors.add(field.getName() + " must not exceed " + max + " characters");
                    }
                }
            } catch (IllegalAccessException e) {
                errors.add("Could not access field: "
                           + field.getName());
            }
        }
        return errors;
    }
}

public class Main {
    public static void main(String[] args) {
        SignupForm form = new SignupForm(
                "",
                "verylongpassword123",
                "student@example.com"
        );

        List<String> errors = FormValidator.validate(form);
        if (errors.isEmpty()) {
            System.out.println("Form is valid.");
        } else {
            System.out.println("Validation Errors:");
            for (String error : errors) {
                System.out.println("- " + error);
            }
        }
    }
}