/**
 *
 */
package activity;

import java.util.Map;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

/**
 * @author ydu
 *
 */
public class DBManeger {

    private DB dbMaker;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Map getMap(String db, String map, String key, String value) {

        Serializer k = detectPolicy(key);
        Serializer v = detectPolicy(value);
        dbMaker = DBMaker.fileDB(db).fileDeleteAfterClose().make();
        return dbMaker.hashMap(map, k, v).create();
    }

    public void cleanUp() {
        dbMaker.close();
    }

    @SuppressWarnings("rawtypes")
    private Serializer detectPolicy(String in) {
        if (in.equalsIgnoreCase("string")) {
            return Serializer.STRING;
        } else if (in.equalsIgnoreCase("integer")) {
            return Serializer.INTEGER;
        } else if (in.equalsIgnoreCase("long")) {
            return Serializer.LONG;
        } else if (in.equalsIgnoreCase("stack") || in.equalsIgnoreCase("queue")) {
            return Serializer.JAVA;
        }
        return null;
    }
}
