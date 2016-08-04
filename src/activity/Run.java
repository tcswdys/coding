/**
 *
 */
package activity;

/**
 * @author ydu
 *
 */
public class Run {

    private static String inputUrl;
    private static String outputUrl;

    public static void parseInputArgs(String[] args) throws Exception {
        if (args.length == 2) {
            inputUrl = args[0];
            outputUrl = args[1];
        } else if (args.length == 1) {
            inputUrl = args[0];
            outputUrl = "./output.txt";
        } else {
            System.out.println("input argument invalid. please use run (input file) [output file]");
            throw new Exception();
        }
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        parseInputArgs(args);

        AverageTimeSpent ats = new AverageTimeSpent(inputUrl, outputUrl);
        ats.getAverageTimeSpent();
    }

}
