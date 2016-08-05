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

	public Average createAverageWithPolicy(ConcurrentMap<?, ?> time, ConcurrentMap<?, ?> status, String policy) {

        switch (policy) {
        case "shortest":
            return new ShortestAverage(time, status);
        default:
            throw new IllegalArgumentException("Unsupported policy: " + policy);
        }
    }
}
