/**
 *
 */
package activity;

import java.util.concurrent.ConcurrentMap;

/**
 * @author ydu
 *
 */
public class ShortestAverage implements Average {

	private ConcurrentMap<String, Long> time;
	private ConcurrentMap<String, OPEN> status;
	
	private static final String OPEN = "open";
    /**
     * @param time
     * @param status
     */
	public ShortestAverage(ConcurrentMap<String, Long> time, ConcurrentMap<String, OPEN> status) {
        this.time = time;
        this.status = status;
    }

	@Override
    public void update(String line) {
    	String[] input = line.split(",");
    	if (input[2].equals(OPEN)) {
    		time.put(input[0], Long.valueOf(input[1]));
    	}
    }

	@Override
	public ConcurrentMap<String, Long> getTime() {
		return time;
	}

}
