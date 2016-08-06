package activity;

import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FIFOAverageTest {

    private static final String INPUT1 = "1,10,open";
    private static final String INPUT2 = "1,20,close";
    private static final String INPUT3 = "1,30,open";
    private static final String INPUT4 = "1,60,close";

    private FIFOAverage avg;

    @Before
    public void setup() {
        avg = new FIFOAverage();
    }

    @After
    public void clean() {
        avg.cleanUp();
    }

    @Test
    public void testTime1() throws Exception {
        avg.update(INPUT1);
        avg.update(INPUT2);
        Map<String, Long> m = avg.getTime();
        for (String s : m.keySet()) {
            Assert.assertEquals("1", s);
        }
        for (long l : m.values()) {
            Assert.assertEquals(10, l);
        }
    }

    @Test
    public void testTime2() throws Exception {
        avg.update(INPUT1);
        avg.update(INPUT2);
        avg.update(INPUT3);
        avg.update(INPUT4);
        Map<String, Long> m = avg.getTime();
        for (String s : m.keySet()) {
            Assert.assertEquals("1", s);
        }
        for (long l : m.values()) {
            Assert.assertEquals(20, l);
        }
    }

    @Test
    public void testTime3() throws Exception {
        avg.update(INPUT1);
        avg.update(INPUT2);
        avg.update(INPUT4);
        Map<String, Long> m = avg.getTime();
        for (String s : m.keySet()) {
            Assert.assertEquals("1", s);
        }
        for (long l : m.values()) {
            Assert.assertEquals(10, l);
        }
    }

    @Test
    public void testTime4() throws Exception {
        avg.update(INPUT1);
        avg.update(INPUT3);
        avg.update(INPUT4);
        Map<String, Long> m = avg.getTime();
        for (String s : m.keySet()) {
            Assert.assertEquals("1", s);
        }
        for (long l : m.values()) {
            Assert.assertEquals(50, l);
        }
    }

}
