import java.util.Arrays;
import java.util.List;

/**
 * A toy program.
 */
public class App {

    public static void main(String[] args) throws Exception {
        List<String> argsList = Arrays.asList(args);
        System.out.printf("Hello, World! I'm a Java program. I was passed %d arguments. They are: %s%n", args.length, argsList);
        Thread.sleep(5_000);
        System.out.println("Bye!");
    }
}
