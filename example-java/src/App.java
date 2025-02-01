import static java.lang.System.out;
import java.util.Arrays;

/**
 * A toy program.
 */
public class App {

public static void main(String[] args) throws Exception {
        var argsList = Arrays.asList(args);
        out.printf("Hello, World! I'm a Java program. I was passed %d arguments. They are: %s%n", args.length, argsList);
        Thread.sleep(5_000);
        out.println("Bye!");
    }
}
