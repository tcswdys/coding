/**
 *
 */
package activity;

/**
 * @author ydu
 *
 */
public class AverageFactory {

    public AverageFactory() {
        // no-op
    }

	public Average createAverageWithPolicy(Policy policy) {

        switch (policy) {
        case FILO:
            return new FILOAverage();
        case FIFO:
            return new FIFOAverage();
        default:
            throw new IllegalArgumentException("Unsupported policy: " + policy);
        }
    }
}
