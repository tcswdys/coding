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
     */
    void update(String line);

	@SuppressWarnings("rawtypes")
	ConcurrentMap getTime();

}
