package activity;

import org.junit.Assert;
import org.junit.Test;

public class RunTest {

    @Test
    public void testParseInputArgs() throws Exception {
        String[] values = {"/user/testin.txt", "/user/testout.txt", "shortest"};
        Run temp = new Run();
        temp.parseInputArgs(values);
        Assert.assertEquals("/user/testin.txt", temp.getInput());
        Assert.assertEquals("/user/testout.txt", temp.getOutput());
        Assert.assertEquals("shortest", temp.getPolicy());


        String[] values2 = {"/user/testinput.txt"};
        try {
        temp.parseInputArgs(values2);
        Assert.fail("Exceptino expected");
        } catch (Exception e) {
            Assert.assertTrue(true);
        }

    }
}
