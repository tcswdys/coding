/**
 *
 */
package activity;

import java.util.concurrent.ConcurrentMap;

/**
 * @author ydu
 *
 */
public interface Average {

    /**
     * @param line
     * @param time
     * @param status
     */
    void update(String line, ConcurrentMap time, ConcurrentMap status);

}
