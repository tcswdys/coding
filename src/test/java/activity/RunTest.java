package activity;

import org.junit.Assert;
import org.junit.Test;

import main.java.Run;

public class RunTest {

    @Test
    public void testParseInputArgs() throws Exception {
        String[] values = {"/user/testin.txt", "/user/testout.txt"};
        Run temp = new Run();
        temp.parseInputArgs(values);
        Assert.assertEquals("/user/testin.txt", temp.getInput());
        Assert.assertEquals("/user/testout.txt", temp.getOutput());

        String[] values2 = {"/user/testinput.txt"};
        temp.parseInputArgs(values2);
        Assert.assertEquals("/user/testinput.txt", temp.getInput());
        Assert.assertEquals("./output.txt", temp.getOutput());
    }
}
