/**
 *
 */
package activity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * @author ydu
 *
 */
public class AverageTimeSpent {

    private String inputUrl;
    private String outputUrl;

    AverageTimeSpent(String inputUrl, String outputUrl) {
        this.inputUrl = inputUrl;
        this.outputUrl = outputUrl;
    }

	public void getAverageTimeSpent(Policy policy) throws IOException {

        Average avg = new AverageFactory().createAverageWithPolicy(policy);

        BufferedReader br = new BufferedReader(new FileReader(inputUrl));
        String line = "";
        while((line=br.readLine())!=null)
        {
            avg.update(line);
        }
        br.close();

        write(outputUrl, avg.getTime());
        avg.cleanUp();
    }

	public void write(String output, Map<String, Long> time) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));
        for (String s : time.keySet()) {
            bw.write(s);
            bw.write(",");
            bw.write(String.valueOf(time.get(s)));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }


}
