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
public class FIFOAverage implements Average {

    private Map<String, Stack<Long>> activity;
    private Map<String, Integer> count;
    private Map<String, Long> time;

    @Override
    public void update(String line) {
        // TODO Auto-generated method stub

    }

    @Override
    public Map<String, Long> getTime() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void cleanUp() {
        // TODO Auto-generated method stub

    }

}
