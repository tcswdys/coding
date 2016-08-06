/**
 *
 */
package activity;

import java.io.IOException;

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

    Run(String[] args) throws IOException {
        parseInputArgs(args);

        AverageTimeSpent ats = new AverageTimeSpent(inputUrl, outputUrl);
        ats.getAverageTimeSpent(detectPolicy(policy));
    }

    public void parseInputArgs(String[] args) throws IllegalArgumentException {
        if (args.length < 3) {
            throw new IllegalArgumentException("Error ! Input argument invalid. please have input_file output_file policy");
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

    private Policy detectPolicy(String policy) {
        if (policy.equalsIgnoreCase("fifo")) {
            return Policy.FIFO;
        } else if (policy.equalsIgnoreCase("filo")) {
            return Policy.FILO;
        }
        return Policy.UNKNOWN;
    }

}
