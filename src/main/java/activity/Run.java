/**
 *
 */
package activity;

/**
 * @author ydu
 *
 */
public class Run {

    private String inputUrl;
    private String outputUrl;

    Run() {
        //no-op
    }

    Run(String[] args) throws Exception {
        parseInputArgs(args);

        AverageTimeSpent ats = new AverageTimeSpent(inputUrl, outputUrl);
        ats.getAverageTimeSpent();
    }

    public void parseInputArgs(String[] args) throws Exception {
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
        new Run(args);
    }

    public String getInput() {
        return inputUrl;
    }

    public String getOutput() {
        return outputUrl;
    }

}
