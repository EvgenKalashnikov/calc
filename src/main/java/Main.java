import static Util.SimpleIntegerMultiplier.multiplyAlgFirst;
import static Util.SimpleIntegerMultiplier.multiplyAlgSecond;

public class Main {
    public static void main(String[] args) {
        useAlgorithm(args);
    }

    private static void useAlgorithm(String[] args) {
        if (args[0].equals("--alg1")) {
            System.out.println(multiplyAlgFirst(args[1],args[2]));
        }else if (args[0].equals("--alg2")) {
            System.out.println(multiplyAlgSecond(args[1],args[2]));
        }else {
            System.out.println("algorithm was chosen wrong");
        }
    }


}
