/**
 *
 */
package activity;

import java.util.Map;
import java.util.Stack;

/**
 * @author ydu
 *
 */
public class FILOAverage implements Average {

	private Map<String, Stack<Long>> activity;
	private Map<String, Integer> count;
	private Map<String, Long> time;
	private DBManeger activityDB;
	private DBManeger countDB;
	private DBManeger timeDB;
	private Stack<Long> s;

	private static final String OPEN = "open";
	private static final String ACTIVITYDB = "activity.db";
	private static final String COUNTDB = "count.db";
	private static final String TIMEDB = "time.db";
	private static final String ACTIVITYMAP = "avtMap";
	private static final String COUNTMAP = "cntMap";
	private static final String TIMEMAP = "timeMap";
	private static final String STRING = "string";
	private static final String LONG = "long";
	private static final String INTEGER = "integer";
	private static final String STACK = "stack";

    /**
     */
	@SuppressWarnings("unchecked")
    public FILOAverage() {
	    activityDB = new DBManeger();
        this.activity = activityDB.getMap(ACTIVITYDB, ACTIVITYMAP, STRING, STACK);
        countDB = new DBManeger();
        this.count = countDB.getMap(COUNTDB, COUNTMAP, STRING, INTEGER);
        timeDB = new DBManeger();
        this.time = timeDB.getMap(TIMEDB, TIMEMAP, STRING, LONG);
    }

	@Override
    public void update(String line) {
    	String[] input = line.split(",");
    	s = activity.get(input[0]) == null ? new Stack<>() : activity.get(input[0]);
    	if (input[2].equals(OPEN)) {
//    	    s = activity.get(input[0]) == null ? new Stack<>() : activity.get(input[0]);
    	    s.push(Long.valueOf(input[1]));
//    	    System.out.println(s.peek());
    	    activity.put(input[0], s);
    	} else if (s != null && s.isEmpty()) {
    	    System.out.println(s.peek());
    	    Long duration = Long.valueOf(input[1]) - s.pop();
    	    activity.put(input[0], s);
    	    int c = (count.get(input[0]) == null ? 0 : count.get(input[0])) + 1;

    	    System.out.println(c);
    	    count.put(input[0], c);
    	    Long d = time.get(input[0]) == null ? 0 : time.get(input[0]);

    	    System.out.println(d);
    	    time.put(input[0], (duration + d) / c);
    	}
    }

	@Override
	public Map<String, Long> getTime() {
		return time;
	}

    @Override
    public void cleanUp() {
        activityDB.cleanUp();
        countDB.cleanUp();
        timeDB.cleanUp();
    }

}
