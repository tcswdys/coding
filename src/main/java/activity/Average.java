/**
 *
 */
package activity;

import java.util.Map;

/**
 * @author ydu
 *
 */
public interface Average {

    /**
     * @param line
     */
    void update(String line);

	Map<String, Long> getTime();

    /**
     *
     */
    void cleanUp();

}
