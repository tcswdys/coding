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
    private String policy;

    Run() {
        //no-op
    }

    Run(String[] args) throws Exception {
        parseInputArgs(args);

        AverageTimeSpent ats = new AverageTimeSpent(inputUrl, outputUrl);
        ats.getAverageTimeSpent(policy);
    }

    public void parseInputArgs(String[] args) throws Exception {
        if (args.length < 3) {
            System.out.println("input argument invalid. please use run input_file output_file policy");
            throw new Exception();
        } else {
            inputUrl = args[0];
            outputUrl = args[1];
            policy = args[2];
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

    public String getPolicy() {
        return policy;
    }

}
