/**
 *
 */
package activity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

    public void getAverageTimeSpent() throws IOException {
        read(inputUrl);
    }

    public void read(String inputUrl) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(inputUrl));
        String line = "";
        while((line=br.readLine())!=null)
        {
            String[] temp = line.split(",");

        }
        br.close();
    }

    public void write() {

    }
}
