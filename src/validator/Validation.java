package validator;
import java.util.regex.*;

public class Validation {

    public static boolean isValid(String value, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public static boolean isLengthMin(String value, int length) {
        return value.length() >= length;
    }

    public static boolean isLengthMax(String value, int length) {
        return value.length() <= length;
    }
}

