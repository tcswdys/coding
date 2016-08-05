/**
 *
 */
package activity;

import java.util.concurrent.ConcurrentMap;


/**
 * @author ydu
 *
 */
public class AverageFactory {

    public AverageFactory() {
        // TODO Auto-generated constructor stub
    }

    public static Average createAverageWithPolicy(String[] input, ConcurrentMap time, ConcurrentMap status, String policy) {

        switch (policy) {
        case "shortest":
            return new ShortestAverage(time, status);
        default:
            throw new IllegalArgumentException("Unsupported policy: " + policy);
        }
    }
}
