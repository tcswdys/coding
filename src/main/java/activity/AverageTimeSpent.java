/**
 *
 */
package activity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentMap;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import activity.AverageFactory;

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

    public void getAverageTimeSpent(String policy) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(inputUrl));
        String line = "";
        DB db = DBMaker.fileDB("file.db").make();
        ConcurrentMap time = db.hashMap("map").make();

        DB db2 = DBMaker.fileDB("file2.db").make();
        ConcurrentMap status = db2.hashMap("map").make();

        Average avg = new AverageFactory.createAverageWithPolicy(line.split(","), time, status, policy);

        while((line=br.readLine())!=null)
        {
            avg.update(line, time, status);
        }
        br.close();
        db.close();

        write(outputUrl, time);
    }

    public void write(String output, ConcurrentMap time) {

    }


}
